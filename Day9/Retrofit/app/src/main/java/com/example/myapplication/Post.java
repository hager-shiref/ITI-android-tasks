package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("userId")
    private int userId;
    private int id;
    private String title;
    private String body;
    public void setUserid(int userId) {
        this.userId = userId;
    }
    public int getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public String getBody() {
        return body;
    }

}
