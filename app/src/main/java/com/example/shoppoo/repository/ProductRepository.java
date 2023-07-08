package com.example.shoppoo.repository;

import android.content.Context;

import com.example.shoppoo.dao.ProductDAO;
import com.example.shoppoo.entity.Product;
import com.example.shoppoo.room.ProductRoomDatabase;

import java.util.List;

public class ProductRepository {

    private ProductDAO productDAO;

    public ProductRepository(Context context) {
        productDAO = ProductRoomDatabase.getInstance(context).productDAO();
    }

    public void save(List<Product> products) {
        productDAO.insert(products);
    }

}
