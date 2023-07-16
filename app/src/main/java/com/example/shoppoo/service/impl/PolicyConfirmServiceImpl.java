package com.example.shoppoo.service.impl;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.shoppoo.entity.Policy;
import com.example.shoppoo.entity.Shop;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.repository.PolicyRepository;
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

    private PolicyRepository policyRepo;

    public PolicyConfirmServiceImpl(Context context, EditText edDescription, CheckBox cbConfirm, Button btnNext, User user, Shop shop) {
        this.context = context;
        this.edDescription = edDescription;
        this.cbConfirm = cbConfirm;
        this.btnNext = btnNext;
        this.user = user;
        this.shop = shop;
        policyRepo = new PolicyRepository(this.context);
    }

    @Override
    public void setTextForDescription() {
        user = new User(5L, "duongdd_user", "Do Duc Duong", true, "HN", "0912345678",
                "duongdd@gmail.com","1414", "2;3", null, null, null, null, null);
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

    }
}
