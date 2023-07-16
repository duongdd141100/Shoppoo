package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.shoppoo.common.Constant;
import com.example.shoppoo.entity.User;

public class HistoryBoughtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_bought);
        setTitle(Constant.HISTORY_BOUGHT_TITLE);
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
    }
}