package com.example.rayaivanova.lesson33;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.rayaivanova.lesson33.model.User;

import static com.example.rayaivanova.lesson33.R.id.login_text;

public class LoginActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        text = findViewById(R.id.login_text);
        if (getIntent().getExtras() != null && getIntent().getExtras().getSerializable("user") != null) {
            User user = (User) getIntent().getExtras().getSerializable("user");
            String gender = "female";
            if (user.isMale()) {
                gender = "male";
            }
            text.setText("Welcome " + user.getUsername() + '\n' + "You are " + user.getAge() + " years old" + '\n' + "You are " + gender);
        }
    }


}
