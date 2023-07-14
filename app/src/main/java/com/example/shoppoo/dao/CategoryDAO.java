package com.example.shoppoo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.shoppoo.entity.Category;

import java.util.List;

@Dao
public interface CategoryDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Category category);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<Category> categories);

    @Query("SELECT * FROM tbl_category")
    List<Category> findAll();
}
