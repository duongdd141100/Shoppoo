package com.example.shoppoo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.shoppoo.entity.ProductStatus;

import java.util.List;

@Dao
public interface ProductStatusDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<ProductStatus> productStatusList);

    @Query("SELECT * FROM tbl_product_status WHERE username = :username AND status = :status")
    List<ProductStatus> findByUsernameAnStatus(String username, String status);

    @Query("DELETE FROM tbl_product_status WHERE id IN(:productStatusSelectedIds)")
    void deleteByIds(List<String> productStatusSelectedIds);

    @Query("SELECT sum(ps.quantity * p.price) FROM tbl_product_status ps" +
            " inner join tbl_product p" +
            " on p.id = ps.product_id" +
            " where ps.id in (:ids)")
    Long getTotalPriceByIds(List<String> ids);
}
