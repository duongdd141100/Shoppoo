package com.example.shoppoo.repository;

import android.content.Context;

import com.example.shoppoo.dao.ShopDAO;
import com.example.shoppoo.entity.Shop;
import com.example.shoppoo.room.ShoppooRoomDatabase;

import java.util.List;

public class ShopRepository {

    private ShopDAO shopDAO;

    public ShopRepository(Context context) {
        this.shopDAO = ShoppooRoomDatabase.getInstance(context).shopDAO();
    }

    public void save(List<Shop> shops) {
        shopDAO.insert(shops);
    }

}
