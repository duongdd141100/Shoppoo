package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.shoppoo.dao.UserDAO;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.room.ShoppooRoomDatabase;

public class ViewProfileActivity extends AppCompatActivity {

    private User user;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        userDAO = ShoppooRoomDatabase.getInstance(this).userDAO();
        Intent intent = getIntent();
        EditText userName = findViewById(R.id.username);
        EditText fullName = findViewById(R.id.fullname);
        EditText address = findViewById(R.id.address);
        EditText phoneNumber = findViewById(R.id.phonenumber);
        EditText email = findViewById(R.id.email);
        RadioButton male = (RadioButton) findViewById(R.id.male);
        RadioButton female = (RadioButton) findViewById(R.id.female);
        if (intent != null) {
            user = (User) intent.getSerializableExtra("user");
            userName.setText(user.getUsername());
            fullName.setText(user.getFullname());
            address.setText(user.getAddress());
            phoneNumber.setText(user.getPhoneNumber());
            email.setText(user.getEmail());
            if(user.getGender()) {
                male.setChecked(true);
            }else female.setChecked(true);
        }
        Button edit =findViewById(R.id.edit_profileButton);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewProfileActivity.this, EditProfileActivity.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
    }
}