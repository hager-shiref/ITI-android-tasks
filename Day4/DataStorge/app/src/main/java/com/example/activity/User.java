package com.example.activity;

public class User {
    private String message;
    private String phone;

    public User(String message, String phone) {
        this.message = message;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
