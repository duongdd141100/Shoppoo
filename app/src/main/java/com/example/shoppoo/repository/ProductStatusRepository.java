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

    public List<ProductStatus> findByUsernameAnStatus(String username, String status) {
        return productStatusDAO.findByUsernameAnStatus(username, status);
    }

    public void deleteByIds(List<String> productStatusSelectedIds) {
        productStatusDAO.deleteByIds(productStatusSelectedIds);
    }

    public Long getTotalPriceByIds(List<String> productStatusSelectedIds) {
        return productStatusDAO.getTotalPriceByIds(productStatusSelectedIds);
    }
}
