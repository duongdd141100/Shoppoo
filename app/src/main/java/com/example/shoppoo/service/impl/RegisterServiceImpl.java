package com.example.shoppoo.service.impl;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.example.shoppoo.R;
import com.example.shoppoo.entity.Category;
import com.example.shoppoo.repository.CategoryRepository;
import com.example.shoppoo.service.RegisterService;

import java.util.stream.Collectors;

public class RegisterServiceImpl implements RegisterService {

    private Context context;

    private View userView;

    private View shopView;

    private Button btnRegister;

    private Boolean isCreateShop;

    private CategoryRepository categoryRepo;
    public RegisterServiceImpl(Context context, View userView, View shopView, Button btnRegister) {
        this.context = context;
        this.userView = userView;
        this.shopView = shopView;
        this.btnRegister = btnRegister;
        categoryRepo = new CategoryRepository(this.context);
    }

    @Override
    public void setCategorySpinnerValues() {
        ArrayAdapter<String> roleAdapter = new ArrayAdapter<>(context, R.layout.spinner_item,
                categoryRepo.findAll().stream().map(Category::getName).collect(Collectors.toList()));
        roleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner)shopView.findViewById(R.id.spinner_category)).setAdapter(roleAdapter);
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
