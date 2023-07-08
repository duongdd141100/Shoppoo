package com.example.shoppoo.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.Date;

@Entity(tableName = "tbl_category")
public class Category extends BaseEntity {

    @ColumnInfo(name = "name")
    private String name;

    public Category(@NonNull Long id, String name, Date createdDate, String createdBy, Date updatedDate, String updatedBy, Integer version) {
        super(id, createdDate, createdBy, updatedDate, updatedBy, version);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
