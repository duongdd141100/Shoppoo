package com.example.shoppoo.repository;

import android.content.Context;

import com.example.shoppoo.dao.CategoryDAO;
import com.example.shoppoo.entity.Category;
import com.example.shoppoo.room.ShoppooRoomDatabase;

import java.util.List;

public class CategoryRepository {

    private CategoryDAO categoryDAO;

    public CategoryRepository(Context context) {
        this.categoryDAO = ShoppooRoomDatabase.getInstance(context).categoryDAO();
    }

    public void save(List<Category> categories) {
        categoryDAO.insert(categories);
    }

}
