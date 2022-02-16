package com.example.downloadimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button btnDownload;
    EditText edtText;
    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    new DownloadTask().execute(edtText.getText().toString());
            }
        });
    }
    private  void initComponent(){
        btnDownload=findViewById(R.id.button);
        edtText=findViewById(R.id.edit);
        imgView=findViewById(R.id.imageView);
    }
    class  DownloadTask extends AsyncTask<String,Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... urls) {
            return download(urls[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgView.setImageBitmap(bitmap);
        }
    }

    private Bitmap download(String url) {
        HttpURLConnection connection=null;
        InputStream is=null;
        Bitmap bitmap=null;
        try {
            URL urlObject = new URL(url);
            connection=(HttpURLConnection) urlObject.openConnection();
            is=connection.getInputStream();
            bitmap= BitmapFactory.decodeStream(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                is.close();
                connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }
}