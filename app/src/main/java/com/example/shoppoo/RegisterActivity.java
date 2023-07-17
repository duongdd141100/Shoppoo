package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.shoppoo.common.Constant;
import com.example.shoppoo.service.RegisterService;
import com.example.shoppoo.service.impl.RegisterServiceImpl;

public class RegisterActivity extends AppCompatActivity {

    private RelativeLayout userView;

    private RelativeLayout shopView;

    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle(Constant.REGISTER_TITLE);

        userView = findViewById(R.id.user_info);
        shopView = findViewById(R.id.shop_info);
        btnRegister = findViewById(R.id.btn_register);
        shopView.setVisibility(View.GONE);

        RegisterService registerService = new RegisterServiceImpl(this, userView, shopView, btnRegister);
        registerService.setCategorySpinnerValues();
        registerService.handleShopChecked();
    }
}