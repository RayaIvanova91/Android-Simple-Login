package com.example.rayaivanova.lesson33;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.rayaivanova.lesson33.model.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private EditText password2;
    private EditText email;
    private ToggleButton isMale;
    private EditText age;
    private Button register;

    private boolean validUser = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.reg_name);
        password = findViewById(R.id.reg_password);
        password2 = findViewById(R.id.reg_confirm);
        email = findViewById(R.id.reg_email);
        isMale = findViewById(R.id.gender);
        age = findViewById(R.id.reg_age);

        register = findViewById(R.id.reg_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                User user = null;
                validUser = true;
                if (validData()) {
                    boolean male;
                    if(isMale.getText().toString().equals(isMale.getTextOff())){
                        male=true;
                    }else{
                        male=false;
                    }
                    user = new User(name.getText().toString(), password.getText().toString(), email.getText().toString(), male, Integer.parseInt(age.getText().toString()));
                }
                if(MainActivity.userExists(name.getText().toString())){
                    name.setError("Username already taken");
                    validUser=false;
                }
                if(MainActivity.userExists(email.getText().toString())){
                    email.setError("Email already taken");
                    validUser=false;
                }
                if ((user != null) && validUser) {
                    intent.putExtra("user", user);
                    setResult(3, intent);
                    finish();
                }
            }
        });
    }

    private boolean validData() {
        if (name.getText().toString().isEmpty()) {
            validUser = false;
            name.setError("Invalid name");
        }
        if (password.getText().toString().isEmpty()) {
            validUser = false;
            password.setError("Invalid password");
        }
        if (password2.getText().toString().isEmpty()) {
            validUser = false;
            password2.setError("Please confirm the password");
        }
        if (!password2.getText().toString().equals(password.getText().toString())) {
            validUser = false;
            password2.setError("Password mismatch");
        }
        if (email.getText().toString().isEmpty()) {
            validUser = false;
            email.setError("Invalid email");
        }
        if (age.getText().toString().isEmpty() || Integer.parseInt(age.getText().toString()) <= 0) {
            validUser = false;
            age.setError("Invalid age");
        }
        return validUser;
    }
}
