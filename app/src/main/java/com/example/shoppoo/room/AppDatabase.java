package com.example.shoppoo.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.shoppoo.dao.CategoryProductDAO;
import com.example.shoppoo.entity.CategoryProduct;

@Database(entities = {CategoryProduct.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CategoryProductDAO categoryDao();
}