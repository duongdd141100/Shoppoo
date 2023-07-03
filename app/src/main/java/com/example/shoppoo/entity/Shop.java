package com.example.shoppoo.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "tbl_shop")
public class Shop extends BaseEntity {

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "founder")
    private String founder;

    @ColumnInfo(name = "category_id")
    private Long categoryId;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "product_count")
    private Integer productCount;

    @ColumnInfo(name = "description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
