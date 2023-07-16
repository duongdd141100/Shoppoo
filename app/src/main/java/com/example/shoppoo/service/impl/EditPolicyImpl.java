package com.example.shoppoo.service.impl;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shoppoo.R;
import com.example.shoppoo.entity.Role;
import com.example.shoppoo.repository.PolicyRepository;
import com.example.shoppoo.repository.RoleRepository;
import com.example.shoppoo.service.EditPolicyService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EditPolicyImpl implements EditPolicyService, AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Context context;

    private Spinner roleSpinner;

    private EditText tvDescription;

    private Button btnUpdate;

    private RoleRepository roleRepository;

    private PolicyRepository policyRepo;

    private List<Role> roles = new ArrayList<>();

    private Integer roleSelectedPosition;

    public EditPolicyImpl(Context context, Spinner roleSpinner, EditText tvDescription, Button btnUpdate) {
        this.context = context;
        this.roleSpinner = roleSpinner;
        this.tvDescription = tvDescription;
        this.btnUpdate = btnUpdate;
        roleRepository = new RoleRepository(this.context);
        policyRepo = new PolicyRepository(this.context);
        roleSelectedPosition = 0;
    }

    @Override
    public void setRoleSpinnerValues() {
        roles.addAll(roleRepository.findAllOtherAdmin());
        ArrayAdapter<String> roleAdapter = new ArrayAdapter<>(context, R.layout.spinner_item,
                roles.stream().map(Role::getName).collect(Collectors.toList()));
        roleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(roleAdapter);
    }

    @Override
    public void handleItemSelected() {
        roleSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void handleUpdate() {
        btnUpdate.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        roleSelectedPosition = position;
        tvDescription.setText(policyRepo.findByRoleId(roles.get(position).getId()).getDescription());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        policyRepo.updateDescriptionByRoleId(roles.get(roleSelectedPosition).getId(), tvDescription.getText().toString());
        Toast.makeText(context, "Update Successfully!", Toast.LENGTH_SHORT).show();
    }
}
