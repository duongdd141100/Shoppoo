package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppoo.adapter.CategoryAdapter;
import com.example.shoppoo.adapter.ProductAdapter;
import com.example.shoppoo.common.Constant;
import com.example.shoppoo.entity.Role;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.repository.CategoryRepository;
import com.example.shoppoo.repository.ProductRepository;
import com.example.shoppoo.repository.RoleRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private CategoryRepository categoryRepo;

    private ProductRepository productRepo;

    private RoleRepository roleRepo;

    private SharedPreferences preferences;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categoryRepo = new CategoryRepository(this);
        productRepo = new ProductRepository(this);
        roleRepo = new RoleRepository(this);

        Intent intent = getIntent();
        if (intent != null) {
            user = (User) intent.getSerializableExtra("user");
            if (user != null) {
                preferences = getSharedPreferences(Constant.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
                preferences.edit().putString("username", user.getUsername());
            }
        }

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        RecyclerView categoriesContainer = findViewById(R.id.categories_container);
        categoriesContainer.setLayoutManager(layoutManager);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryRepo.findAll(), this);
        categoriesContainer.setAdapter(categoryAdapter);

        RecyclerView.LayoutManager layoutManagerVertical = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, true);
        RecyclerView productsContainer = findViewById(R.id.product_container);
        productsContainer.setLayoutManager(layoutManagerVertical);
        ProductAdapter productAdapter = new ProductAdapter(productRepo.findAll(), this);
        productsContainer.setAdapter(productAdapter);

        TextView shop = findViewById(R.id.my_cart_icon);
        shop.setCompoundDrawablesWithIntrinsicBounds(R.drawable.shop_icon, 0, 0, 0);
        TextView tvLogin = findViewById(R.id.tv_login);
        TextView tvMenu = findViewById(R.id.tv_menu);
        if (user == null) {
            onUserNull(shop, tvLogin, tvMenu);
        } else {
            onUserNotnull(shop, tvLogin, tvMenu);
        }

    }

    private void onUserNotnull(TextView shop, TextView tvLogin, TextView tvMenu) {
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (roleRepo.findByIds(Arrays.asList(user.getRole().split(";")))
                        .stream().anyMatch(x -> Constant.BUYER_ROLE.equals(x.getName()))) {
                    Intent intent = new Intent(MainActivity.this, MyCartActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "You are not Buyer!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        tvLogin.setText("Profile");
        registerForContextMenu(tvMenu);
        tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, tvMenu);
                popupMenu.getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu());
                Menu menu = popupMenu.getMenu();
                HashMap<List<String>, List<Integer>> mapRolesWithMenuItems = createMapRolesWithMenuItems();
                List<Role> roles = roleRepo.findByIds(Arrays.stream(user.getRole().split(";")).collect(Collectors.toList()));
                mapRolesWithMenuItems.get(roles.stream().map(Role::getName).collect(Collectors.toList())).stream().forEach(x -> {
                    menu.findItem(x).setVisible(false);
                });
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (R.id.logout == item.getItemId()) {
                            user = null;
                            finish();
                            startActivity(getIntent());
                        }
                        if (R.id.edit_policy == item.getItemId()) {
                            Intent intent = new Intent(MainActivity.this, EditPolicyActivity.class);
                            startActivity(intent);
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    private HashMap<List<String>, List<Integer>> createMapRolesWithMenuItems() {
        HashMap<List<String>, List<Integer>> mapRolesWithMenuItems = new HashMap<>();
        mapRolesWithMenuItems.put(Arrays.asList(Constant.ADMIN_ROLE),
                Arrays.asList(R.id.create_shop,
                        R.id.history_bought,
                        R.id.view_warehouse));
        mapRolesWithMenuItems.put(Arrays.asList(Constant.SELLER_ROLE),
                Arrays.asList(R.id.edit_policy,
                        R.id.add_account,
                        R.id.history_bought,
                        R.id.view_category,
                        R.id.view_role,
                        R.id.view_shop,
                        R.id.view_buyer));
        mapRolesWithMenuItems.put(Arrays.asList(Constant.BUYER_ROLE),
                Arrays.asList(R.id.edit_policy,
                        R.id.view_warehouse,
                        R.id.add_account,
                        R.id.view_category,
                        R.id.view_role,
                        R.id.view_shop,
                        R.id.view_buyer));
        mapRolesWithMenuItems.put(Arrays.asList(Constant.BUYER_ROLE, Constant.SELLER_ROLE),
                Arrays.asList(R.id.edit_policy,
                        R.id.add_account,
                        R.id.view_category,
                        R.id.view_role,
                        R.id.view_shop,
                        R.id.view_buyer));
        return mapRolesWithMenuItems;
    }

    private void onUserNull(TextView shop, TextView tvLogin, TextView tvMenu) {
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Please Login to use!", Toast.LENGTH_SHORT).show();
            }
        });

        tvLogin.setText("Login");
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: handle login click
            }
        });
        tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Please Login to use!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}