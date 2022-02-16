package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
Button prev,next;
TextView id,title,userId,body;
Post[] postArray;
int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        APIInterface apiInterface= APIClient.getClient().create(APIInterface.class);
        Call<Post[]> call=apiInterface.getPosts();
        call.enqueue(new Callback<Post[]>() {
            @Override
            public void onResponse(Call<Post[]> call, Response<Post[]> response) {
                if(response.isSuccessful()){
                     postArray = response.body();
                     setUI(postArray[0]);

                }
            }

            @Override
            public void onFailure(Call<Post[]> call, Throwable t) {
                String s= t.getMessage();
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(i==0){
                   Toast.makeText(MainActivity.this,"it's the first Post",Toast.LENGTH_SHORT).show();
               }
               else {
                   i--;
                   setUI(postArray[i]);
               }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                setUI(postArray[i]);
            }
        });
    }

    public  void initComponent(){
        prev=findViewById(R.id.prevButton);
        next=findViewById(R.id.next);
        id=findViewById(R.id.ID);
        title=findViewById(R.id.texttitle);
        userId=findViewById(R.id.userid);
        body=findViewById(R.id.body);
    }
    private void setUI(Post post){
        userId.setText(post.getUserId()+"");
        id.setText(post.getId()+"");
        title.setText(post.getTitle());
        body.setText(post.getBody());
    }
}