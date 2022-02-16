package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnNext,btnClose;
    EditText edtMobile,edtMessage;
    public  static final  String MOBILE_NUMBER="mobile";
    public  static  final  String  MESSAGE="message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtMobile=findViewById(R.id.editTextMobile);
        edtMessage=findViewById(R.id.editTextMessage);
        btnNext=findViewById(R.id.next);
        btnClose=findViewById(R.id.close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent=new Intent(MainActivity.this,SecondActivity.class);
                nextIntent.putExtra(MOBILE_NUMBER,edtMobile.getText().toString());
                nextIntent.putExtra(MESSAGE,edtMessage.getText().toString());
                startActivity(nextIntent);

            }
        });
    }
}