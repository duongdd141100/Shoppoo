package com.example.shoppoo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppoo.adapter.CartAdapter;
import com.example.shoppoo.adapter.MyCartListener;
import com.example.shoppoo.common.DataCommon;
import com.example.shoppoo.common.ProductStatusEnum;
import com.example.shoppoo.entity.ProductStatus;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.repository.ProductStatusRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyCartActivity extends AppCompatActivity implements MyCartListener{

    private ProductStatusRepository productStatusRepo;

    private List<String> productStatusSelectedIds = new ArrayList<>();

    List<ProductStatus> productStatusList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        productStatusRepo = new ProductStatusRepository(this);
        ((TextView) findViewById(R.id.tv_title)).setTypeface(null, Typeface.BOLD);
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");

        productStatusList = productStatusRepo.findByUsernameAnStatus(user.getUsername(), ProductStatusEnum.IN_CART.getKey());
        RecyclerView.LayoutManager layoutManagerVertical = new LinearLayoutManager(this);
        RecyclerView cartContainer = findViewById(R.id.cart_container);
        cartContainer.setLayoutManager(layoutManagerVertical);
        CartAdapter productAdapter = new CartAdapter(productStatusList, this, this);
        cartContainer.setAdapter(productAdapter);
        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productStatusSelectedIds == null || productStatusSelectedIds.size() == 0) {
                    Toast.makeText(MyCartActivity.this, "Please select product!", Toast.LENGTH_SHORT).show();
                } else {
                    productStatusRepo.deleteByIds(productStatusSelectedIds);
                    ((CheckBox) findViewById(R.id.checkbox_all)).setChecked(false);
                    ((TextView) findViewById(R.id.tv_price_value)).setText("$ 0");
                    finish();
                    startActivity(getIntent());
                    Toast.makeText(MyCartActivity.this, "Remove Successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        CheckBox checkAll = findViewById(R.id.checkbox_all);
        checkAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkAll.isChecked()) {
                    List<String> allIds = productStatusList.stream().map(x -> x.getId().toString()).collect(Collectors.toList());
                    productStatusSelectedIds.clear();
                    productStatusSelectedIds.addAll(allIds);
                    Long totalPrice = productStatusRepo.getTotalPriceByIds(allIds);
                    productAdapter.selectedAll(allIds, totalPrice);

                    ((TextView) findViewById(R.id.tv_total_value)).setText("$ " + totalPrice);
                } else {
                    productStatusSelectedIds.clear();
                    productAdapter.unselectedAll();
                    ((TextView) findViewById(R.id.tv_total_value)).setText("$ 0");
                }
            }
        });
    }

    @Override
    public void onCheckboxSelectedListener(List<String> productStatusIds, Boolean isSelectedAll, Long totalPrice) {
        ((CheckBox) findViewById(R.id.checkbox_all)).setChecked(isSelectedAll);
        productStatusSelectedIds.clear();
        productStatusSelectedIds.addAll(productStatusIds);
        ((TextView) findViewById(R.id.tv_total_value)).setText("$ " + totalPrice);

    }
}