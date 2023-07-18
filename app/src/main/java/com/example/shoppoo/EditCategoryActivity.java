package com.example.shoppoo;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.shoppoo.dao.CategoryProductDAO;
import com.example.shoppoo.entity.CategoryProduct;
import com.example.shoppoo.room.AppDatabase;

public class EditCategoryActivity extends AppCompatActivity {

    private EditText editTextCategory;
    private CategoryProductDAO categoryDao;
    private CategoryProduct category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_category);

        editTextCategory = findViewById(R.id.editTextCategory);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "my-database-name").build();

        categoryDao = db.categoryDao();


        CategoryProduct category = (CategoryProduct) getIntent().getSerializableExtra("category");

//        category = getIntent().getParcelableExtra("category");
        if (category != null) {
            editTextCategory.setText(category.getCategoryName());
        } else {
            Toast.makeText(this, "Invalid category", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    // Add code here to handle the category editing logic
    // For example, update the category in the database
}