package com.example.shoppoo.entity.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppoo.entity.Product;
import com.example.shoppoo.entity.ProductStatus;

import java.util.List;

public class ProductWithProductStatus {

    @Embedded
    private Product product;

    @Relation(
            parentColumn = "id",
            entityColumn = "product_id"
    )
    private List<ProductStatus> productStatusList;

}
