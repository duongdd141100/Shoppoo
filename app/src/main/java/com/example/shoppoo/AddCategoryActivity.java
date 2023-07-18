package com.example.shoppoo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.shoppoo.dao.CategoryProductDAO;
import com.example.shoppoo.entity.CategoryProduct;
import com.example.shoppoo.room.AppDatabase;

public class AddCategoryActivity extends AppCompatActivity {

    private EditText editTextCategory;
    private CategoryProductDAO categoryDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        editTextCategory = findViewById(R.id.editTextCategory);
        Button buttonAddCategory = findViewById(R.id.buttonAddCategory);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "change-database-name").build();
//                TODO: Change database name before merge
        categoryDao = db.categoryDao();

        buttonAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoryName = editTextCategory.getText().toString();
                if (!categoryName.isEmpty()) {
                    CategoryProduct category = new CategoryProduct();
                    category.setCategoryName(categoryName);
                    insertCategory(category);

                    Toast.makeText(
                            AddCategoryActivity.this,
                            "Category added: " + categoryName,
                            Toast.LENGTH_SHORT
                    ).show();

                    finish(); // Finish the activity after adding the category
                } else {
                    Toast.makeText(
                            AddCategoryActivity.this,
                            "Please enter a category name",
                            Toast.LENGTH_SHORT
                    ).show();

                    Intent intent = new Intent(AddCategoryActivity.this, CategoryListActivity.class);
                    startActivity(intent);

                    finish(); // Finish the activity after adding the category
                }
            }
        });
    }

    private void insertCategory(CategoryProduct category) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                categoryDao.insert(category);
            }
        }).start();
    }
}
