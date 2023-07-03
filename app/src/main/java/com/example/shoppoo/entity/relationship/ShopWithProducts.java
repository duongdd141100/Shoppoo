package com.example.shoppoo.entity.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppoo.entity.Product;
import com.example.shoppoo.entity.Shop;

import java.util.List;

public class ShopWithProducts {

    @Embedded
    private Shop shop;

    @Relation(
            parentColumn = "id",
            entityColumn = "shop_owned"
    )
    private List<Product> products;

}
