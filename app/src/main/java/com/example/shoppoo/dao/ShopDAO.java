package com.example.shoppoo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.shoppoo.entity.Shop;

import java.util.List;

@Dao
public interface ShopDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<Shop> shops);

    @Query("SELECT * FROM tbl_shop WHERE id = :id")
    Shop findById(Long id);
}
