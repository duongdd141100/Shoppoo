package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.shoppoo.common.Constant;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.service.HistoryBoughtService;
import com.example.shoppoo.service.impl.HistoryBoughtServiceImpl;

public class HistoryBoughtActivity extends AppCompatActivity {

    private RecyclerView recyclerViewHistoryBought;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_bought);
        setTitle(Constant.HISTORY_BOUGHT_TITLE);

        recyclerViewHistoryBought = findViewById(R.id.recycle_history_bought);
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
        HistoryBoughtService historyBoughtService = new HistoryBoughtServiceImpl(this, recyclerViewHistoryBought, user);
        historyBoughtService.setProductHistoryRecycleView();
    }
}