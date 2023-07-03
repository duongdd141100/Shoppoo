package com.example.shoppoo.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id", typeAffinity = 1, index = true)
    private Long id;

    @ColumnInfo(name = "created_date")
    private Date createdDate;

    @ColumnInfo(name = "created_by")
    private String createdBy;

    @ColumnInfo(name = "updated_date")
    private Date updatedDate;

    @ColumnInfo(name = "updated_by")
    private String updatedBy;

    @ColumnInfo(name = "version")
    private Integer version;

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
