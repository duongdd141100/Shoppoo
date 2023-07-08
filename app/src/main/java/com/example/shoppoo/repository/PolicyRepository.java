package com.example.shoppoo.repository;

import android.content.Context;

import com.example.shoppoo.dao.PolicyDAO;
import com.example.shoppoo.entity.Policy;
import com.example.shoppoo.room.PolicyRoomDatabase;

import java.util.List;

public class PolicyRepository {

    private PolicyDAO policyDAO;

    public PolicyRepository(Context context) {
        this.policyDAO = PolicyRoomDatabase.getInstance(context).policyDAO();
    }

    public void save(List<Policy> policies) {
        policyDAO.insert(policies);
    }

}
