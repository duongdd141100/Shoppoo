package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shoppoo.adapter.ShopAdapter;
import com.example.shoppoo.adapter.UserAdapter;
import com.example.shoppoo.dao.ShopDAO;
import com.example.shoppoo.dao.UserDAO;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.room.ShoppooRoomDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListBuyerActivity extends AppCompatActivity {

    List<User> buyers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buyer);
        buyers = new ArrayList<>();
        UserDAO userDAO = ShoppooRoomDatabase.getInstance(this).userDAO();
        buyers = userDAO.selectAllBuyer();

        RecyclerView recyclerView = findViewById(R.id.buyerRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter wordAdapter = new UserAdapter(buyers, this);
        recyclerView.setAdapter(wordAdapter);



    }
}