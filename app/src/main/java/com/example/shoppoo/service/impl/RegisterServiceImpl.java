package com.example.shoppoo.service.impl;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;

import com.example.shoppoo.PolicyConfirmActivity;
import com.example.shoppoo.R;
import com.example.shoppoo.entity.Category;
import com.example.shoppoo.entity.Shop;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.repository.CategoryRepository;
import com.example.shoppoo.repository.UserRepository;
import com.example.shoppoo.service.RegisterService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RegisterServiceImpl implements RegisterService {

    private Context context;

    private View userView;

    private View shopView;

    private Button btnRegister;

    private CategoryRepository categoryRepo;

    private List<Integer> userViewIds = new ArrayList<>();

    private List<Integer> shopViewIds = new ArrayList<>();

    private List<Category> categories = new ArrayList<>();

    private List<Long> categoryIds;

    private User user;

    private Shop shop;

    private UserRepository userRepo;

    ActivityResultLauncher<Intent> startActivity;

    public RegisterServiceImpl(Context context, View userView, View shopView, Button btnRegister, User user, Shop shop, ActivityResultLauncher<Intent> startActivity) {
        this.context = context;
        this.userView = userView;
        this.shopView = shopView;
        this.btnRegister = btnRegister;
        this.user = user;
        this.shop = shop;
        userViewIds.addAll(Arrays.asList(R.id.et_fullname, R.id.et_address, R.id.et_phone_number,
                R.id.et_email, R.id.et_username, R.id.et_password, R.id.et_retype));
        shopViewIds.addAll(Arrays.asList(R.id.et_shop_name, R.id.et_shop_address, R.id.et_description));
        categoryRepo = new CategoryRepository(this.context);
        userRepo = new UserRepository(this.context);
        this.startActivity = startActivity;
    }

    @Override
    public void setCategorySpinnerValues() {
        categories = categoryRepo.findAll();
        categoryIds = categories.stream().map(Category::getId).collect(Collectors.toList());
        ArrayAdapter<String> roleAdapter = new ArrayAdapter<>(context, R.layout.spinner_item,
                categories.stream().map(Category::getName).collect(Collectors.toList()));
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
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userViewIds.stream()
                        .anyMatch(x -> ((EditText)userView.findViewById(x)).getText().toString().trim().length() == 0)
                || ((RadioGroup)userView.findViewById(R.id.rg_gender)).getCheckedRadioButtonId() == -1) {
                    Toast.makeText(context, "Please enter all user information fields!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!((EditText)userView.findViewById(R.id.et_password)).getText().toString()
                        .equals(((EditText)userView.findViewById(R.id.et_retype)).getText().toString())) {
                    Toast.makeText(context, "Retype password is incorrect!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (((CheckBox)userView.findViewById(R.id.cb_shop)).isChecked()
                && shopViewIds.stream()
                        .anyMatch(x -> ((EditText)shopView.findViewById(x)).getText().toString().trim().length() == 0)) {
                    Toast.makeText(context, "Please enter all shop information fields!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String username = ((EditText)userView.findViewById(R.id.et_username)).getText().toString().toLowerCase();
                if (username.contains(" ")) {
                    Toast.makeText(context, "Username is not valid!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (userRepo.findByUsername(username) != null) {
                    Toast.makeText(context, "Username is exist!", Toast.LENGTH_SHORT).show();
                    return;
                }
                user = new User(null,
                        username,
                        ((EditText)userView.findViewById(R.id.et_fullname)).getText().toString().trim(),
                        ((RadioButton) userView.findViewById(R.id.rb_male)).isChecked() ? true : false,
                        ((EditText)userView.findViewById(R.id.et_address)).getText().toString().trim(),
                        ((EditText)userView.findViewById(R.id.et_phone_number)).getText().toString().trim(),
                        ((EditText)userView.findViewById(R.id.et_email)).getText().toString().trim(),
                        ((EditText)userView.findViewById(R.id.et_password)).getText().toString().trim(),
                        "", null, null, null, null, 1);
                if (((CheckBox) userView.findViewById(R.id.cb_shop)).isChecked()) {
                    shop = new Shop(null,
                            ((EditText)shopView.findViewById(R.id.et_shop_name)).getText().toString().trim(),
                            user.getUsername(),
                            categories.get(((Spinner)shopView.findViewById(R.id.spinner_category)).getSelectedItemPosition()).getId(),
                            ((EditText)shopView.findViewById(R.id.et_shop_address)).getText().toString().trim(),
                            0,
                            ((EditText)shopView.findViewById(R.id.et_description)).getText().toString().trim(),
                            null, null, null, null, 1);
                }
                Intent intent = new Intent(context, PolicyConfirmActivity.class);
                intent.putExtra("user", user);
                intent.putExtra("isSeller", ((CheckBox) userView.findViewById(R.id.cb_shop)).isChecked());
                intent.putExtra("shop", shop);
                startActivity.launch(intent);
            }
        });

    }

    @Override
    public void setInfoValues() {
        if (user != null) {
            ((EditText) userView.findViewById(R.id.et_fullname)).setText(user.getFullname());
            ((EditText) userView.findViewById(R.id.et_address)).setText(user.getAddress());
            ((EditText) userView.findViewById(R.id.et_phone_number)).setText(user.getPhoneNumber());
            ((EditText) userView.findViewById(R.id.et_email)).setText(user.getEmail());
            ((EditText) userView.findViewById(R.id.et_username)).setText(user.getUsername());
            ((EditText) userView.findViewById(R.id.et_password)).setText(user.getPassword());
            ((EditText) userView.findViewById(R.id.et_retype)).setText(user.getPassword());
            if (user.getGender()) {
                userView.findViewById(R.id.rb_male).setSelected(true);
            } else {
                userView.findViewById(R.id.rb_female).setSelected(true);
            }

            if (shop != null) {
                userView.findViewById(R.id.cb_shop).setSelected(true);
                ((EditText) shopView.findViewById(R.id.et_shop_name)).setText(shop.getName());
                ((EditText) shopView.findViewById(R.id.et_shop_address)).setText(shop.getAddress());
                ((EditText) shopView.findViewById(R.id.et_description)).setText(shop.getDescription());
                ((Spinner) shopView.findViewById(R.id.spinner_category)).setSelection(categoryIds.indexOf(shop.getCategoryId()));
            }
        }
    }
}
