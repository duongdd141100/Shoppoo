package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shoppoo.adapter.ShopAdapter;
import com.example.shoppoo.dao.ShopDAO;
import com.example.shoppoo.entity.Shop;
import com.example.shoppoo.room.ShoppooRoomDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListShopActivity extends AppCompatActivity {

    List<Shop>shops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_shop);
        shops = new ArrayList<>();
        ShopDAO shopDAO = ShoppooRoomDatabase.getInstance(this).shopDAO();
        shops = shopDAO.selectAllShop();

        RecyclerView recyclerView = findViewById(R.id.shopRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ShopAdapter wordAdapter = new ShopAdapter(shops, this);
        recyclerView.setAdapter(wordAdapter);


        Button button = findViewById(R.id.btn_create);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
            }
        });

    }
}