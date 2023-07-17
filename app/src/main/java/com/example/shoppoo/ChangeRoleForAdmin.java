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

public class ChangeRoleForAdmin extends AppCompatActivity {

    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_role_for_admin);
        userDAO = ShoppooRoomDatabase.getInstance(this).userDAO();
        EditText userName = findViewById(R.id.username);
        Button save =findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = userDAO.selectUserByUsername(userName.getText().toString());
                if (user != null) {
                    userDAO.changeRoleforAdminByUsername(user.getUsername());
                    user = userDAO.selectUserById(user.getId());
                    Intent intent = new Intent(ChangeRoleForAdmin.this, MainActivity.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }else {
                    Toast.makeText(ChangeRoleForAdmin.this, "Username does not exist ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}