package com.example.shoppoo.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "tbl_product_status")
public class ProductStatus extends BaseEntity {

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "product_id")
    private Long productId;

    @ColumnInfo(name = "quantity")
    private Integer quantity;

    @ColumnInfo(name = "status")
    private String status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
