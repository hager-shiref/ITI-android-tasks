package com.example.boundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.Provider;

public class MainActivity extends AppCompatActivity {
    BoundService service;
    ServiceConnection connection;
    Button dateBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connection =new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder iBinder) {
                BoundService.MyBinder binder=(BoundService.MyBinder)iBinder;
                service=binder.getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) { }
        };
        Intent intent =new Intent(getApplicationContext(),BoundService.class);
        bindService(intent,connection,BIND_AUTO_CREATE);
        dateBtn=findViewById(R.id.date);
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,service.getCurrentTime(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}