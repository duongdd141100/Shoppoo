package com.example.shoppoo.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.Date;

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

    public ProductStatus(@NonNull Long id, String username, Long productId, Integer quantity, String status,
                         Date createdDate, String createdBy, Date updatedDate, String updatedBy, Integer version) {
        super(id, createdDate, createdBy, updatedDate, updatedBy, version);
        this.username = username;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
    }

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
