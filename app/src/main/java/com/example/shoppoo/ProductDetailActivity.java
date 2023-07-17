package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.shoppoo.common.Constant;
import com.example.shoppoo.service.ProductDetailService;
import com.example.shoppoo.service.impl.ProductDetailServiceImpl;
import com.squareup.picasso.Picasso;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView imageView;

    private View mainLayout;

    private Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        setTitle(Constant.PRODUCT_DETAIL_TITLE);

        mainLayout = findViewById(R.id.activity_product_detail);
        imageView = findViewById(R.id.product_image);


        Intent intent = getIntent();
        id = intent.getLongExtra("id", -1);

        ProductDetailService productDetailService = new ProductDetailServiceImpl(this, id, mainLayout);
        productDetailService.setProductInfo();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Picasso.with(this).load("error")
                .error(R.drawable.product_icon).placeholder(R.drawable.product_icon).into(imageView);
    }
}