package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("posts")
    Call<Post[]> getPosts();
}
