package com.example.shoppoo.entity.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppoo.entity.Shop;
import com.example.shoppoo.entity.User;

import java.util.List;

public class UserWithShops {

    @Embedded
    private User user;

    @Relation(
            parentColumn = "username",
            entityColumn = "founder"
    )
    private List<Shop> shops;

}
