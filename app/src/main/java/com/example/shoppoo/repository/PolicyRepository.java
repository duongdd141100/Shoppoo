package com.example.shoppoo.repository;

import android.content.Context;

import com.example.shoppoo.dao.PolicyDAO;
import com.example.shoppoo.entity.Policy;
import com.example.shoppoo.room.ShoppooRoomDatabase;

import java.util.List;

public class PolicyRepository {

    private PolicyDAO policyDAO;

    public PolicyRepository(Context context) {
        this.policyDAO = ShoppooRoomDatabase.getInstance(context).policyDAO();
    }

    public void save(List<Policy> policies) {
        policyDAO.insert(policies);
    }

    public Policy findByRoleId(Long id) {
        return policyDAO.findByRoleId(id);
    }
}
