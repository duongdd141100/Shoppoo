package com.example.shoppoo.entity.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppoo.entity.ProductStatus;
import com.example.shoppoo.entity.User;

import java.util.List;

public class UserWithProductStatus {

    @Embedded
    private User user;

    @Relation(
            parentColumn = "username",
            entityColumn = "username"
    )
    private List<ProductStatus> productStatusList;

}
