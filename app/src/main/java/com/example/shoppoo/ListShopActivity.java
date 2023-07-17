package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.shoppoo.dao.ShopDAO;
import com.example.shoppoo.entity.Shop;
import com.example.shoppoo.room.ShoppooRoomDatabase;

import java.util.List;

public class ListShopActivity extends AppCompatActivity {

    private ShopDAO shopDAO;
    private RecyclerView recyclerViewShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_shop);
        shopDAO = ShoppooRoomDatabase.getInstance(this).shopDAO();
        List<Shop> shopList = shopDAO.selectAllShop();
        recyclerViewShop = findViewById(R.id.recyclerviewShop);
        recyclerViewShop.setLayoutManager(new LinearLayoutManager(this));

    }
}