package com.example.shoppoo.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "tbl_role")
public class Role extends BaseEntity {

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

}
