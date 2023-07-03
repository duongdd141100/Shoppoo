package com.example.shoppoo.entity.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppoo.entity.Policy;
import com.example.shoppoo.entity.Role;

public class RoleAndPolicy {

    @Embedded
    private Role role;

    @Relation(
            parentColumn = "id",
            entityColumn = "role_id"
    )
    private Policy policy;

}
