package com.example.shoppoo.repository;

import android.content.Context;

import com.example.shoppoo.dao.RoleDAO;
import com.example.shoppoo.entity.Role;
import com.example.shoppoo.room.RoleRoomDatabase;

import java.util.List;

public class RoleRepository {

    private RoleDAO roleDAO;

    public RoleRepository(Context context) {
        this.roleDAO = RoleRoomDatabase.getInstance(context).roleDAO();
    }

    public void save(List<Role> roles) {
        roleDAO.insert(roles);
    }

}
