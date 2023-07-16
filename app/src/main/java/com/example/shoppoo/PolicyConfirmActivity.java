package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.shoppoo.entity.Shop;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.service.PolicyConfirmService;
import com.example.shoppoo.service.impl.PolicyConfirmServiceImpl;

public class PolicyConfirmActivity extends AppCompatActivity {

    private EditText edDescription;

    private CheckBox cbConfirm;

    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_confirm);

        edDescription = findViewById(R.id.et_description);
        cbConfirm = findViewById(R.id.cb_confirm);
        btnNext = findViewById(R.id.btn_next);

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
        Shop shop = (Shop) intent.getSerializableExtra("shop");

        PolicyConfirmService policyConfirmService = new PolicyConfirmServiceImpl(this, edDescription, cbConfirm, btnNext, user, shop);
        policyConfirmService.setTextForDescription();
        policyConfirmService.handleConfirmCheckbox();
    }
}