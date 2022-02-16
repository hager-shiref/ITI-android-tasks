package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
Button prev,next;
TextView txtId,txtUserId,txtTitle,txtBody;
ArrayList<Post> contactList;
int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        contactList = new ArrayList<>();
        new GetPosts().execute();
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0){
                    Toast.makeText(MainActivity.this,"it's the first post",Toast.LENGTH_SHORT).show();
                }
                else {
                    i--;
                    update(i);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                update(i);
            }
        });
    }
    private void update(int i){
        txtId.setText( contactList.get(i).getId()+"");
        txtUserId.setText(contactList.get(i).getUserId()+"");
        txtTitle.setText(contactList.get(i).getTitle());
        txtBody.setText(contactList.get(i).getBody());
    }
    private void initComponent(){
        prev=findViewById(R.id.prev);
        next=findViewById(R.id.next);
        txtId=findViewById(R.id.ID);
        txtUserId=findViewById(R.id.userId);
        txtTitle=findViewById(R.id.texttitle);
        txtBody=findViewById(R.id.body);
    }
     class GetPosts extends AsyncTask<Void, Void, Void> {
         @Override
         protected void onPostExecute(Void aVoid) {
             super.onPostExecute(aVoid);

             txtId.setText( contactList.get(0).getId()+"");
             txtUserId.setText(contactList.get(0).getUserId()+"");
             txtTitle.setText(contactList.get(0).getTitle());
             txtBody.setText(contactList.get(0).getBody());
         }

         @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();
            String url = "https://jsonplaceholder.typicode.com/posts";
            String jsonStr = sh.makeServiceCall(url);
             Log.i("MainJson","Data"+jsonStr);
            if(jsonStr !=null){
                try {
                    //JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONArray contacts = new JSONArray(jsonStr);
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
                        int id = c.getInt("id");
                        int user_id = c.getInt("userId" );
                        String title = c.getString("title");
                        String body = c.getString("body");
                        Post post=new Post(id,user_id,title,body);
                        contactList.add(post);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
                return null;
        }
    }
}