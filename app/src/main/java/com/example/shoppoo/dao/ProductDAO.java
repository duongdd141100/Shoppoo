package com.example.shoppoo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.shoppoo.entity.Product;

import java.util.List;

@Dao
public interface ProductDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<Product> products);

    @Query("SELECT * FROM tbl_product")
    List<Product> findAll();

    @Query("SELECT * FROM tbl_product WHERE id = :id")
    Product findById(Long id);
}
