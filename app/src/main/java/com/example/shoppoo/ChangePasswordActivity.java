package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shoppoo.dao.UserDAO;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.room.ShoppooRoomDatabase;

public class ChangePasswordActivity extends AppCompatActivity {

    private User user;
    private UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        userDAO = ShoppooRoomDatabase.getInstance(this).userDAO();
        Intent intent = getIntent();
        EditText oldPassword = findViewById(R.id.oldpassword);
        EditText newPassword = findViewById(R.id.newpassword);
        EditText cfNewPassword = findViewById(R.id.cfnewpassword);
        if (intent != null) {
            user = (User) intent.getSerializableExtra("user");
        }
        Button save =findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!oldPassword.getText().toString().equals(user.getPassword()) ||
                    !newPassword.getText().toString().equals(cfNewPassword.getText().toString())) {
                    Toast.makeText(ChangePasswordActivity.this, "Update fail", Toast.LENGTH_SHORT).show();
                }else {
                    userDAO.changePassword(newPassword.getText().toString(),user.getId());
                    user = userDAO.selectUserById(user.getId());
                    Intent intent = new Intent(ChangePasswordActivity.this, MainActivity.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }
            }
        });
    }
}