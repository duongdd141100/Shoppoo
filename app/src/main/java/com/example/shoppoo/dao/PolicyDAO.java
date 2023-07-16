package com.example.shoppoo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.shoppoo.entity.Policy;

import java.util.List;

@Dao
public interface PolicyDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<Policy> policies);

    @Query("SELECT * FROM tbl_policy WHERE role_id = :roleId")
    Policy findByRoleId(Long roleId);
}
