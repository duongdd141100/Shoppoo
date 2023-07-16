package com.example.shoppoo.service.impl;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.shoppoo.R;
import com.example.shoppoo.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {

    private Context context;

    private View userView;

    private View shopView;

    private Button btnRegister;

    private Boolean isCreateShop;
    public RegisterServiceImpl(Context context, View userView, View shopView, Button btnRegister) {
        this.context = context;
        this.userView = userView;
        this.shopView = shopView;
        this.btnRegister = btnRegister;
    }

    @Override
    public void handleShopChecked() {
        CheckBox cbShop = userView.findViewById(R.id.cb_shop);
        cbShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbShop.isChecked()) {
                    shopView.setVisibility(View.VISIBLE);
                } else {
                    shopView.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void handleRegisterButton() {

    }
}
