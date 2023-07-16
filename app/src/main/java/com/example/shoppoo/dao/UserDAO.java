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

    @Query("UPDATE tbl_user SET fullname = :fullname, address = :address, phone_number = :phoneNumber, email = :email, gender = :gender WHERE id = :userId")
    void updateUser(String fullname, String address, String phoneNumber, String email, boolean gender, long userId);

    @Query("SELECT * FROM tbl_user WHERE id = :id")
    User selectUserById(Long id);
}
