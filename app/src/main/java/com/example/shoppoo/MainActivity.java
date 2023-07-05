package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Transaction;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shoppoo.dao.CategoryDAO;
import com.example.shoppoo.dao.PolicyDAO;
import com.example.shoppoo.dao.ProductDAO;
import com.example.shoppoo.dao.RoleDAO;
import com.example.shoppoo.dao.ShopDAO;
import com.example.shoppoo.entity.Category;
import com.example.shoppoo.entity.Policy;
import com.example.shoppoo.entity.Product;
import com.example.shoppoo.entity.Role;
import com.example.shoppoo.entity.Shop;
import com.example.shoppoo.room.CategoryRoomDatabase;
import com.example.shoppoo.room.PolicyRoomDatabase;
import com.example.shoppoo.room.ProductRoomDatabase;
import com.example.shoppoo.room.ProductStatusRoomDatabase;
import com.example.shoppoo.room.RoleRoomDatabase;
import com.example.shoppoo.room.ShopRoomDatabase;
import com.example.shoppoo.room.UserRoomDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView shop = findViewById(R.id.my_cart_icon);
        shop.setCompoundDrawablesWithIntrinsicBounds(R.drawable.shop_icon, 0, 0, 0);
        CategoryDAO categoryDAO = CategoryRoomDatabase.getInstance(this).categoryDAO();
//        insertCategory();
        List<Category> categories = categoryDAO.findAll();
        GridLayout topLinearLayout = findViewById(R.id.categories_container);
        for (Category category : categories) {
            TextView textView = new TextView(this);
            textView.setTextSize(30);
            textView.setText(category.getName());
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.category_icon, 0, 0, 0);
            topLinearLayout.addView(textView);
        }
        insertPolicy();
        insertRole();
        insertShop();
        insertProduct();


        ProductStatusRoomDatabase.getInstance(this);
        UserRoomDatabase.getInstance(this);
    }

    private void insertCategory() {
        CategoryDAO categoryDAO = CategoryRoomDatabase.getInstance(this).categoryDAO();
        Category category = new Category();
        category.setName("Apple");
        categoryDAO.insert(category);

        Category category1 = new Category();
        category1.setName("Soccer");
        categoryDAO.insert(category1);

        Category category2 = new Category();
        category2.setName("Badminton");
        categoryDAO.insert(category2);
    }

    private void insertPolicy() {
        PolicyDAO policyDAO = PolicyRoomDatabase.getInstance(this).policyDAO();
        Policy policyBuyer = new Policy();
        policyBuyer.setRoleId(2L);
        policyBuyer.setDescription("Buyer Policy");
        policyDAO.insert(policyBuyer);

        Policy policySeller = new Policy();
        policySeller.setRoleId(3L);
        policySeller.setDescription("Seller Policy");
        policyDAO.insert(policySeller);
    }

    @Transaction
    private void insertRole() {
        RoleDAO roleDAO = RoleRoomDatabase.getInstance(this).roleDAO();
        Role roleAdmin = new Role();
        roleAdmin.setName("Admin");
        Role roleBuyer = new Role();
        roleBuyer.setName("Buyer");
        Role roleSeller = new Role();
        roleSeller.setName("Seller");
//        roleDAO.insert(roleAdmin);
//        roleDAO.insert(roleBuyer);
//        roleDAO.insert(roleSeller);
    }

    private void insertShop() {
        ShopDAO shopDAO = ShopRoomDatabase.getInstance(this).shopDAO();
        for (int i = 0; i < 10; i++) {
            Shop shop = new Shop();
            shop.setName("Shop " + (i + 1));
            shop.setAddress("HN");
            shop.setDescription("Shop " + (i + 1) + " has many good product!");
        }
    }

    private void insertProduct() {
        ProductDAO productDAO = ProductRoomDatabase.getInstance(this).productDAO();
        for (int i = 0; i < 50; i ++) {
            Product product = new Product();
            product.setName("Product " + (i + 1));
            product.setPrice(50L);
            product.setQuantity(500);
            product.setDescription("Product " + (i + 1) + " is very good!");
        }
    }
}