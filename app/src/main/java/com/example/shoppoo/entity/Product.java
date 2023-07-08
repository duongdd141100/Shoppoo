package com.example.shoppoo.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.Date;

@Entity(tableName = "tbl_product")
public class Product extends BaseEntity {

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "price")
    private Long price;

    @ColumnInfo(name = "quantity")
    private Integer quantity;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "shop_owned")
    private Long shopOwned;

    public Product(@NonNull Long id, String name, Long price, Integer quantity, String description, Long shopOwned,
                   Date createdDate, String createdBy, Date updatedDate, String updatedBy, Integer version) {
        super(id, createdDate, createdBy, updatedDate, updatedBy, version);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.shopOwned = shopOwned;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getShopOwned() {
        return shopOwned;
    }

    public void setShopOwned(Long shopOwned) {
        this.shopOwned = shopOwned;
    }
}
