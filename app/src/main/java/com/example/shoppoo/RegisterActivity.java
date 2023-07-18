package com.example.shoppoo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.shoppoo.common.Constant;
import com.example.shoppoo.entity.Shop;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.service.RegisterService;
import com.example.shoppoo.service.impl.RegisterServiceImpl;

public class RegisterActivity extends AppCompatActivity {

    private RelativeLayout userView;

    private RelativeLayout shopView;

    private Button btnRegister;

    private User user;

    private Shop shop;

    private ActivityResultLauncher<Intent> startActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 1) {
                        Intent intent = result.getData();
                        user = (User) intent.getSerializableExtra("user");
                        shop = (Shop) intent.getSerializableExtra("shop");
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle(Constant.REGISTER_TITLE);

        userView = findViewById(R.id.user_info);
        shopView = findViewById(R.id.shop_info);
        btnRegister = findViewById(R.id.btn_register);
        shopView.setVisibility(View.GONE);

        RegisterService registerService = new RegisterServiceImpl(this, userView, shopView, btnRegister, user, shop, startActivity);
        registerService.setCategorySpinnerValues();
        registerService.setInfoValues();
        registerService.handleShopChecked();
        registerService.handleRegisterButton();
    }
}