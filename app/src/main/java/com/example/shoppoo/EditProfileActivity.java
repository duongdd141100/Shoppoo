package com.example.shoppoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.shoppoo.dao.UserDAO;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.room.ShoppooRoomDatabase;

public class EditProfileActivity extends AppCompatActivity {
    private User user;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        userDAO = ShoppooRoomDatabase.getInstance(this).userDAO();
        Intent intent = getIntent();
        EditText fullName = findViewById(R.id.fullname);
        EditText address = findViewById(R.id.address);
        EditText phoneNumber = findViewById(R.id.phonenumber);
        EditText email = findViewById(R.id.email);
        RadioButton male = (RadioButton) findViewById(R.id.male);
        RadioButton female = (RadioButton) findViewById(R.id.female);
        if (intent != null) {
            user = (User) intent.getSerializableExtra("user");
            fullName.setText(user.getFullname());
            address.setText(user.getAddress());
            phoneNumber.setText(user.getPhoneNumber());
            email.setText(user.getEmail());
            if(user.getGender()) {
                male.setChecked(true);
            }else female.setChecked(true);
        }
        Button save =findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setFullname(fullName.getText().toString());
                user.setAddress(address.getText().toString());
                user.setPhoneNumber(phoneNumber.getText().toString());
                user.setEmail(email.getText().toString());
                if (male.isChecked()) {
                    user.setGender(true);
                }else user.setGender(false);
                userDAO.updateUser(user.getFullname(),user.getAddress(),user.getPhoneNumber(),user.getEmail(),user.getGender(), user.getId());
                User user1 = userDAO.selectUserById(user.getId());
                if (user1.getFullname().equals(user.getFullname()) &&
                        user1.getAddress().equals(user.getAddress()) &&
                        user1.getPhoneNumber().equals(user.getPhoneNumber()) &&
                        user1.getEmail().equals(user.getEmail()) &&
                        user1.getGender() == (user.getGender())) {
                    Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                    intent.putExtra("user",user1);
                    startActivity(intent);
                }else Toast.makeText(EditProfileActivity.this, "Update fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}