package com.example.shoppoo.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "tbl_policy")
public class Policy extends BaseEntity {

    @ColumnInfo(name = "role_id")
    private Long roleId;

    @ColumnInfo(name = "description")
    private String description;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
