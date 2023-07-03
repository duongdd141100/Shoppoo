package com.example.shoppoo.entity.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppoo.entity.Category;
import com.example.shoppoo.entity.Shop;

import java.util.List;

public class CategoryWithShops {

    @Embedded
    private Category category;

    @Relation(
            parentColumn = "id",
            entityColumn = "category_id"
    )
    private List<Shop> shops;

}
