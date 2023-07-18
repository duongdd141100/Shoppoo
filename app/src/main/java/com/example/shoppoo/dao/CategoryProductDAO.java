package com.example.shoppoo.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.shoppoo.entity.CategoryProduct;

import java.util.List;

@Dao
public interface CategoryProductDAO {

    @Insert
    void insert(CategoryProduct category);

    @Query("SELECT * FROM categories")
    List<CategoryProduct> getAllCategories();
}
