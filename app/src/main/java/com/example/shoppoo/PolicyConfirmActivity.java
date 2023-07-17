package com.example.shoppoo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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

    private User user;

    private Shop shop;

    private Boolean isSeller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_confirm);

        edDescription = findViewById(R.id.et_description);
        cbConfirm = findViewById(R.id.cb_confirm);
        btnNext = findViewById(R.id.btn_next);

        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");
        shop = (Shop) intent.getSerializableExtra("shop");
        isSeller = intent.getBooleanExtra("isSeller", false);

        PolicyConfirmService policyConfirmService = new PolicyConfirmServiceImpl(this, edDescription, cbConfirm, btnNext, user, shop);
        policyConfirmService.setTextForDescription();
        policyConfirmService.handleConfirmCheckbox();
        policyConfirmService.handleNextButton();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent= new Intent();
            intent.putExtra("user", user);
            intent.putExtra("shop", shop);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}