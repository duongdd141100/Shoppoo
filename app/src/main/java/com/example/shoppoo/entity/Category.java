package com.example.shoppoo.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "tbl_category")
public class Category extends BaseEntity {

    @ColumnInfo(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
