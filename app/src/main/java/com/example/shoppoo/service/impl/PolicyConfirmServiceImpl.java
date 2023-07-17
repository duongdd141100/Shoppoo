package com.example.shoppoo.service.impl;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shoppoo.MainActivity;
import com.example.shoppoo.entity.Policy;
import com.example.shoppoo.entity.Shop;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.repository.PolicyRepository;
import com.example.shoppoo.repository.ShopRepository;
import com.example.shoppoo.repository.UserRepository;
import com.example.shoppoo.service.PolicyConfirmService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PolicyConfirmServiceImpl implements PolicyConfirmService {

    private Context context;

    private EditText edDescription;

    private CheckBox cbConfirm;

    private Button btnNext;

    private User user;

    private Shop shop;

    private Boolean isSeller;

    private PolicyRepository policyRepo;

    private UserRepository userRepo;

    private ShopRepository shopRepo;

    public PolicyConfirmServiceImpl(Context context, EditText edDescription, CheckBox cbConfirm, Button btnNext, User user, Shop shop, Boolean isSeller) {
        this.context = context;
        this.edDescription = edDescription;
        this.cbConfirm = cbConfirm;
        this.btnNext = btnNext;
        this.user = user;
        this.shop = shop;
        this.isSeller = isSeller;
        policyRepo = new PolicyRepository(this.context);
        userRepo = new UserRepository(this.context);
        shopRepo = new ShopRepository(this.context);
    }

    @Override
    public void setTextForDescription() {
        List<Policy> policies = policyRepo.findAll();
        String policyDescription = String.join("\n\n", policies.stream()
                .filter(x -> Arrays.stream(user.getRole().split(";")).collect(Collectors.toList()).contains(x.getRoleId().toString()))
                .map(Policy::getDescription).collect(Collectors.toList()));
        edDescription.setText(policyDescription);

    }

    @Override
    public void handleConfirmCheckbox() {
        cbConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbConfirm.isChecked()) {
                    btnNext.setEnabled(true);
                } else {
                    btnNext.setEnabled(false);
                }
            }
        });
    }

    @Override
    public void handleNextButton() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRepo.save(Arrays.asList(user));
                if (isSeller) {
                    shopRepo.save(Arrays.asList(shop));
                }
                Toast.makeText(context, "Your account is created! Please login to use!", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });
    }
}
