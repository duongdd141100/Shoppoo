package com.example.shoppoo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.shoppoo.entity.Role;

import java.util.List;

@Dao
public interface RoleDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<Role> roles);

    @Query("SELECT * FROM tbl_role WHERE id IN (:roleIds)")
    List<Role> findByIds(List<String> roleIds);
}
