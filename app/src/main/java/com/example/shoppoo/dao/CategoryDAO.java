package com.example.shoppoo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.shoppoo.entity.Category;

@Dao
public interface CategoryDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Category category);

}
