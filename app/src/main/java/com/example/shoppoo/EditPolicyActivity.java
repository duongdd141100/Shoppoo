package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.shoppoo.common.Constant;
import com.example.shoppoo.entity.Role;
import com.example.shoppoo.repository.RoleRepository;
import com.example.shoppoo.service.EditPolicyService;
import com.example.shoppoo.service.impl.EditPolicyImpl;

import java.util.List;

public class EditPolicyActivity extends AppCompatActivity {

    private Spinner roleSpinner;

    private EditText tvDescription;

    private Button btnUpdate;

    EditPolicyService editPolicyService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_policy);
        setTitle(Constant.EDIT_POLICY_TITLE);

        roleSpinner = findViewById(R.id.role_spinner);
        tvDescription = findViewById(R.id.et_description);
        btnUpdate = findViewById(R.id.btn_update);

        editPolicyService = new EditPolicyImpl(this, roleSpinner, tvDescription, btnUpdate);
        editPolicyService.setRoleSpinnerValues();
    }
}