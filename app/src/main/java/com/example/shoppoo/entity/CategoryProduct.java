package com.example.shoppoo.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;



@Entity(tableName = "categories")
public class CategoryProduct implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String categoryName;

    // Getters and setters for id and categoryName

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}


