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

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        Button loginButton = findViewById(R.id.loginButton);
        userDAO = ShoppooRoomDatabase.getInstance(this).userDAO();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ( (EditText) findViewById(R.id.username)).getText().toString().trim();
                String password = ( (EditText) findViewById(R.id.password)).getText().toString().trim();
                if (username.equals("") || password.equals(""))
                    {
                        Toast.makeText(LoginActivity.this, "Username or password empty", Toast.LENGTH_SHORT).show();
                    }else {
                        User user = userDAO.selectUserByUsernameAndPassword(username,password);
                        if (user==null) {
                            Toast.makeText(LoginActivity.this, "Login fail", Toast.LENGTH_SHORT).show();
                        }else {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("user",user);
                            startActivity(intent);
                        }
                }
            }
        });
    }
}