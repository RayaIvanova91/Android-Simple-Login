package com.example.rayaivanova.lesson33;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rayaivanova.lesson33.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<User> users;
    private EditText username;
    private EditText password;
    private Button login;
    private Button register;

    private boolean valid = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            users = (ArrayList<User>) savedInstanceState.getSerializable("users");
        } else {
            users = new ArrayList<>();
        }
        username = findViewById(R.id.username);
        password = this.findViewById(R.id.password);
        login = this.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valid = true;
                validData();
                if (valid) {
                    User user = getUser(username.getText().toString());
                    Intent intent = new Intent(MainActivity.this, HotelsActivity.class);
                    intent.putExtra("user", user);
                    MainActivity.this.startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid login data", Toast.LENGTH_SHORT).show();
                }
            }
        });
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivityForResult(intent, 4);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        password.setText("");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("users", users);
    }
    /*   @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("MainActivity", "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity", "onPause");
    }*/


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        username.setError(null);
        password.setError(null);
        if (data == null || data.getExtras().getSerializable("user") == null) {
            username.setText("");
            password.setText("");
        } else {
            User user = (User) data.getExtras().getSerializable("user");
            users.add(user);
            username.setText(user.getUsername());
            password.setText(user.getPassword());
        }

    }

    private User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username) || user.getEmail().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static boolean userExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username) || user.getEmail().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private boolean validData() {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        if (user.isEmpty()) {
            valid = false;
            username.setError("Please enter a username");
        }

        if (pass.isEmpty()) {
            valid = false;
            password.setError("Please enter a password");
        }
        if (userExists(user)) {
            User currentUser = getUser(user);
            if (!pass.equals(currentUser.getPassword())) {
                valid = false;
                password.setError("Invalid Password");
            }
        } else {
            valid = false;
            username.setError("No such user");
        }
        return valid;
    }
}
