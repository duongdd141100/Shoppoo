package com.example.shoppoo.service.impl;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.shoppoo.R;
import com.example.shoppoo.entity.Role;
import com.example.shoppoo.repository.RoleRepository;
import com.example.shoppoo.service.EditPolicyService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EditPolicyImpl implements EditPolicyService {

    private Context context;

    private Spinner roleSpinner;

    private EditText tvDescription;

    private Button btnUpdate;

    private RoleRepository roleRepository;

    private List<Role> roles = new ArrayList<>();

    public EditPolicyImpl(Context context, Spinner roleSpinner, EditText tvDescription, Button btnUpdate) {
        this.context = context;
        this.roleSpinner = roleSpinner;
        this.tvDescription = tvDescription;
        this.btnUpdate = btnUpdate;
        roleRepository = new RoleRepository(this.context);
    }

    @Override
    public void setRoleSpinnerValues() {
        roles.addAll(roleRepository.findAllOtherAdmin());
        ArrayAdapter<String> roleAdapter = new ArrayAdapter<>(context, R.layout.spinner_item,
                roles.stream().map(Role::getName).collect(Collectors.toList()));
        roleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(roleAdapter);
    }
}
