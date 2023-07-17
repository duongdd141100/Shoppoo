package com.example.shoppoo.service.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppoo.R;
import com.example.shoppoo.common.Constant;
import com.example.shoppoo.common.ProductStatusEnum;
import com.example.shoppoo.entity.Product;
import com.example.shoppoo.entity.ProductStatus;
import com.example.shoppoo.entity.Shop;
import com.example.shoppoo.repository.ProductRepository;
import com.example.shoppoo.repository.ProductStatusRepository;
import com.example.shoppoo.repository.ShopRepository;
import com.example.shoppoo.service.ProductDetailService;

import java.util.Arrays;

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

    private Product product;

    private ProductStatusRepository productStatusRepo;

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
        productStatusRepo = new ProductStatusRepository(this.context);
    }

    @Override
    public void setProductInfo() {
        product = productRepo.findById(id);
        Shop shop = shopRepo.findById(product.getShopOwned());
        tvName.setText(product.getName());
        tvPrice.setText("Price: $ " + product.getPrice());
        tvQuantityValue.setText("0");
        tvTotal.setText("Total: $ 0");
        tvDescription.setText("Description: " + product.getDescription());
        tvShop.setText("Shop: " + shop.getName());
    }

    @Override
    public void handleMinusButton() {
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer quantity = Integer.parseInt(tvQuantityValue.getText().toString());
                if (quantity == 0) {
                    Toast.makeText(context, "Quantity cannot less than 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                quantity -= 1;
                tvQuantityValue.setText(quantity.toString());
                tvTotal.setText("Total: $ " + (product.getPrice() * quantity));
            }
        });
    }

    @Override
    public void handlePlusButton() {
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer quantity = Integer.parseInt(tvQuantityValue.getText().toString());
                if (quantity == product.getQuantity()) {
                    Toast.makeText(context, "This product has no more", Toast.LENGTH_SHORT).show();
                    return;
                }
                quantity += 1;
                tvQuantityValue.setText(quantity.toString());
                tvTotal.setText("Total: $ " + (product.getPrice() * quantity));
            }
        });
    }

    @Override
    public void handleAddButton() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "");
                if (username.isEmpty()) {
                    Toast.makeText(context, "Please login to use!", Toast.LENGTH_SHORT).show();
                    return;
                }
                productStatusRepo.save(Arrays.asList(new ProductStatus(null, username, product.getId(),Integer.parseInt(tvQuantityValue.getText().toString()),
                        ProductStatusEnum.IN_CART.getKey(), null, null, null, null, 1)));
                Toast.makeText(context, "Add product to your cart successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
