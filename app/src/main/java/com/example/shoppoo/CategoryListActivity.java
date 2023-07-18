package com.example.shoppoo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.shoppoo.dao.CategoryProductDAO;
import com.example.shoppoo.entity.CategoryProduct;
import com.example.shoppoo.room.AppDatabase;

import java.util.List;
import java.util.ArrayList;

public class CategoryListActivity extends AppCompatActivity {

    private ListView listViewCategories;
    private CategoryProductDAO categoryDao;
    private List<String> categories;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        listViewCategories = findViewById(R.id.listViewCategories);
        categories = new ArrayList<>();

        // Initialize and set the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                categories
        );

        // Set up swipe gesture listener for ListView
        listViewCategories.setOnTouchListener(new OnSwipeTouchListener(this, listViewCategories));
        listViewCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = (String) parent.getItemAtPosition(position);
                Toast.makeText(CategoryListActivity.this, "Selected Category: " + selectedCategory, Toast.LENGTH_SHORT).show();
            }
        });


        listViewCategories.setAdapter(adapter);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "change-database-name").build();
//        ToDO: Change database name before use

        categoryDao = db.categoryDao();

        displayCategories();

        // Set up swipe gesture listener for ListView
        listViewCategories.setOnTouchListener(new OnSwipeTouchListener(this, listViewCategories));
        listViewCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CategoryProduct selectedCategory = (CategoryProduct) parent.getItemAtPosition(position);
                Toast.makeText(CategoryListActivity.this, "Selected Category: " + selectedCategory.getCategoryName(), Toast.LENGTH_SHORT).show();
                editCategoryProduct(selectedCategory);
            }
        });

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

    void editCategoryProduct(CategoryProduct category) {
        // ...
//        Intent intent = new Intent(CategoryListActivity.this, EditCategoryActivity.class);
//        intent.putExtra("category", category);
//        startActivity(intent);
    }
    // Method to delete a category from the list
    void deleteCategoryProduct(CategoryProduct position) {
//        if (position >= 0 && position < categories.size()) {
//            categories.remove(position);
//            ArrayAdapter<String> adapter = (ArrayAdapter<String>) listViewCategories.getAdapter();
//            adapter.notifyDataSetChanged();
//        }
    }
}
//
//public class CategoryListActivity extends AppCompatActivity {
//
//    private ListView listViewCategories;
//    private List<String> categories;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_category_list);
//
//        listViewCategories = findViewById(R.id.listViewCategories);
//        categories = new ArrayList<>(); // Replace with your list of categories
//
//        // Initialize and set the adapter
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                categories
//        );
//        listViewCategories.setAdapter(adapter);
//
//
//        listViewCategories.setOnTouchListener(new OnSwipeTouchListener(this, listViewCategories));
//        listViewCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String selectedCategory = (String) parent.getItemAtPosition(position);
//                Toast.makeText(CategoryListActivity.this, "Selected Category: " + selectedCategory, Toast.LENGTH_SHORT).show();
//                editCategory(selectedCategory);
//            }
//        });
//    }
//
//    private void editCategory(String category) {
//        // Handle the edit action for the selected category
//        // For example, navigate to the edit screen with the category data
//    }
//
//    private void deleteCategory(String category) {
//        // Show a confirmation dialog for deleting the selected category
//        // If confirmed, perform the delete action
//        // Otherwise, cancel the delete action
//    }
//}