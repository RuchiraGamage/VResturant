package com.example.ruchira.vresturant.Model;


public class User {

    private String Name,password;

    public User(String name, String password) {
        Name = name;
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
