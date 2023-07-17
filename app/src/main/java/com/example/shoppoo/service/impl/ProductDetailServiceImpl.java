package com.example.shoppoo.service.impl;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shoppoo.R;
import com.example.shoppoo.entity.Product;
import com.example.shoppoo.entity.Shop;
import com.example.shoppoo.repository.ProductRepository;
import com.example.shoppoo.repository.ShopRepository;
import com.example.shoppoo.service.ProductDetailService;

public class ProductDetailServiceImpl implements ProductDetailService {

    private Context context;

    private Long id;

    private Button btnMinus;

    private Button btnPlus;

    private Button btnAdd;

    private TextView tvName;

    private TextView tvQuantityValue;

    private TextView tvPrice;

    private TextView tvTotal;

    private TextView tvDescription;

    private TextView tvShop;

    private ProductRepository productRepo;

    private ShopRepository shopRepo;

    public ProductDetailServiceImpl(Context context, Long id, View view) {
        this.context = context;
        this.id = id;
        btnMinus = view.findViewById(R.id.btn_minus);
        btnPlus = view.findViewById(R.id.btn_plus);
        btnAdd = view.findViewById(R.id.btn_add);
        tvName = view.findViewById(R.id.tv_product_name);
        tvQuantityValue = view.findViewById(R.id.tv_quantity_value);
        tvPrice = view.findViewById(R.id.tv_price);
        tvTotal = view.findViewById(R.id.tv_total);
        tvDescription = view.findViewById(R.id.tv_description);
        tvShop = view.findViewById(R.id.tv_shop);
        productRepo = new ProductRepository(this.context);
        shopRepo = new ShopRepository(this.context);
    }

    @Override
    public void setProductInfo() {
        Product product = productRepo.findById(id);
        Shop shop = shopRepo.findById(product.getId());
        tvName.setText(product.getName());
        tvPrice.setText("Price: $" + product.getPrice());
        tvQuantityValue.setText("0");
        tvTotal.setText("Total: $ 0");
        tvDescription.setText("Description: " + product.getDescription());
        tvShop.setText("Shop: " + shop.getName());
    }
}
