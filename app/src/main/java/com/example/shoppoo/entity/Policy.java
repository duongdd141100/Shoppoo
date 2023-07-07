package com.example.shoppoo.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.Date;

@Entity(tableName = "tbl_policy")
public class Policy extends BaseEntity {

    @ColumnInfo(name = "role_id")
    private Long roleId;

    @ColumnInfo(name = "description")
    private String description;

    public Policy(@NonNull Long id, Long roleId, String description, Date createdDate, String createdBy, Date updatedDate, String updatedBy, Integer version) {
        super(id, createdDate, createdBy, updatedDate, updatedBy, version);
        this.roleId = roleId;
        this.description = description;
    }

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
