package com.example.shoppoo.repository;

import android.content.Context;

import com.example.shoppoo.dao.UserDAO;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.room.ShoppooRoomDatabase;

import java.util.List;

public class UserRepository {

    private UserDAO userDAO;

    public UserRepository(Context context) {
        this.userDAO = ShoppooRoomDatabase.getInstance(context).userDAO();
    }

    public void save(List<User> users) {
        userDAO.insert(users);
    }

}
