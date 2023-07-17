package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        imageView = findViewById(R.id.product_image);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Picasso.with(this).load("error")
                .error(R.drawable.product_icon).placeholder(R.drawable.product_icon).into(imageView);
    }
}