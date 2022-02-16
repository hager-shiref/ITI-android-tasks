package com.example.json;

import androidx.annotation.NonNull;

public class Post {
    private int id;
    private  int userId;
    private String title;
    private String body;

    public void setId(int id) {
        this.id = id;
    }

    public Post(int id, int userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NonNull
    @Override
    public String toString() {
        return "id"+id + "\n userId : "+userId +"\n title"+title+"\n body : "+body;

    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
