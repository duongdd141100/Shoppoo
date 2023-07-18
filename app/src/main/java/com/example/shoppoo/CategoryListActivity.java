package com.example.shoppoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.shoppoo.dao.CategoryProductDAO;
import com.example.shoppoo.entity.CategoryProduct;
import com.example.shoppoo.room.AppDatabase;

import java.util.List;

public class CategoryListActivity extends AppCompatActivity {

    private ListView listViewCategories;
    private CategoryProductDAO categoryDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        listViewCategories = findViewById(R.id.listViewCategories);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "change-database-name").build();
//        ToDO: Change database name before use

        categoryDao = db.categoryDao();

        displayCategories();

        listViewCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CategoryProduct category = (CategoryProduct) parent.getItemAtPosition(position);
                editCategoryProduct(category);
            }
        });

    }

    private void displayCategories() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<CategoryProduct> categories = categoryDao.getAllCategories();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter<CategoryProduct> adapter = new ArrayAdapter<>(
                                CategoryListActivity.this,
                                android.R.layout.simple_list_item_1,
                                categories
                        );
                        listViewCategories.setAdapter(adapter);
                    }
                });
            }
        }).start();
    }

    private void editCategoryProduct(CategoryProduct category) {
        // ...
        Intent intent = new Intent(CategoryListActivity.this, EditCategoryActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}