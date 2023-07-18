package com.example.shoppoo.repository;

import android.content.Context;

import com.example.shoppoo.dao.RoleDAO;
import com.example.shoppoo.entity.Role;
import com.example.shoppoo.room.ShoppooRoomDatabase;

import java.util.Collection;
import java.util.List;

public class RoleRepository {

    private RoleDAO roleDAO;

    public RoleRepository(Context context) {
        this.roleDAO = ShoppooRoomDatabase.getInstance(context).roleDAO();
    }

    public void save(List<Role> roles) {
        roleDAO.insert(roles);
    }

    public List<Role> findByIds(List<String> roleIds) {
        return roleDAO.findByIds(roleIds);
    }

    public List<Role> findAllOtherAdmin() {
        return roleDAO.findAllOtherAdmin();
    }

    public Role findByName(String roleName) {
        return roleDAO.findByName(roleName);
    }
}
