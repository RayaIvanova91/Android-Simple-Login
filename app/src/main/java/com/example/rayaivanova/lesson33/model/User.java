package com.example.rayaivanova.lesson33.model;

import java.io.Serializable;

public class User implements Serializable{
    private String username;
    private String password;
    private String email;
    private boolean isMale;
    private int age;

    public User(String username, String password, String email, boolean isMale, int age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isMale = isMale;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return isMale;
    }
}
