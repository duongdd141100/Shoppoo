package com.example.shoppoo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.shoppoo.entity.ProductStatus;

import java.util.List;

@Dao
public interface ProductStatusDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<ProductStatus> productStatusList);
}
