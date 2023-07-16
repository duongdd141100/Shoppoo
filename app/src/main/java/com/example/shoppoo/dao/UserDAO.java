package com.example.shoppoo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.shoppoo.entity.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<User> users);


    @Query("Select * from tbl_user Where username =:username And password=:password")
    User selectUserByUsernameAndPassword(String username, String password);

    @Query("SELECT * FROM tbl_user WHERE username = :username")
    User findByUsername(String username);
}
