package com.example.shoppoo.repository;

import android.content.Context;

import com.example.shoppoo.dao.ProductStatusDAO;
import com.example.shoppoo.entity.ProductStatus;
import com.example.shoppoo.room.ShoppooRoomDatabase;

import java.util.List;

public class ProductStatusRepository {

    private ProductStatusDAO productStatusDAO;

    public ProductStatusRepository(Context context) {
        productStatusDAO = ShoppooRoomDatabase.getInstance(context).productStatusDAO();
    }

    public void save(List<ProductStatus> productStatusList) {
        productStatusDAO.insert(productStatusList);
    }

}
