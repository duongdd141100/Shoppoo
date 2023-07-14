package com.example.shoppoo.repository;

import android.content.Context;

import com.example.shoppoo.dao.ProductDAO;
import com.example.shoppoo.entity.Product;
import com.example.shoppoo.room.ShoppooRoomDatabase;

import java.util.List;

public class ProductRepository {

    private ProductDAO productDAO;

    public ProductRepository(Context context) {
        productDAO = ShoppooRoomDatabase.getInstance(context).productDAO();
    }

    public void save(List<Product> products) {
        productDAO.insert(products);
    }

    public List<Product> findAll() {
        return productDAO.findAll();
    }
}
