package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondActivity extends AppCompatActivity {
    TextView txtViewMobile,txtViewMessage;
    Button btnClose , saveShared,loadShared,internalSave,internalLoad,saveSql,loadSql;
    public  static  final String   SHARED_PREF="sharedPrefs";
    public  static  final String   MOBILE="mobile";
    public  static  final String   MESSAGE="message";
    public  static  final String  FILENAME="mobile";

    String mobileNumber;
    String message;
    DataBaseHelper dataBaseHelper;
    User users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        dataBaseHelper=new DataBaseHelper(this);
        initComponent();
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        saveShared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        loadShared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
                updateViews();
            }
        });
        updateViews();
    internalSave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            internalSave();
        }
    });
    internalLoad.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            internalLoad();
        }
    });
    saveSql.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             users=new User(message,mobileNumber);
           dataBaseHelper.insertData(users);
           txtViewMessage.setText("");
           txtViewMobile.setText("");
        }
    });
    loadSql.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dataBaseHelper.getAllUser();
            txtViewMobile.setText(users.getPhone());
            txtViewMessage.setText(users.getMessage());
        }
    });
    }
public  void initComponent(){
    txtViewMessage=findViewById(R.id.txtViewMessage);
    txtViewMobile=findViewById(R.id.txtViewMobile);
    btnClose=findViewById(R.id.btnClose);
    saveShared=findViewById(R.id.saveShared);
    loadShared=findViewById(R.id.loadShared);
    internalSave=findViewById(R.id.internalSave);
    internalLoad=findViewById(R.id.internalLoad);
    mobileNumber=getIntent().getStringExtra(MainActivity.MOBILE_NUMBER);
    message=getIntent().getStringExtra(MainActivity.MESSAGE);
    saveSql=findViewById(R.id.savaSql);
    loadSql=findViewById(R.id.loadSql);
}
    public  void saveData(){
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(MOBILE,txtViewMobile.getText().toString());
        editor.putString(MESSAGE,txtViewMessage.getText().toString());
        editor.apply();
        txtViewMobile.setText("");
        txtViewMessage.setText("");
    }
    public void loadData(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        message=sharedPreferences.getString(MESSAGE,"");
        mobileNumber=sharedPreferences.getString(MOBILE,"");

    }
    public void updateViews(){
        txtViewMobile.setText(mobileNumber);
        txtViewMessage.setText(message);
    }
    public  void internalSave(){
        FileOutputStream fos=null;
        DataOutputStream dataOutputStream;
        try {

             fos=   openFileOutput(FILENAME,MODE_PRIVATE);
            dataOutputStream= new DataOutputStream(fos);
            String data=txtViewMobile.getText().toString();
            String data1=txtViewMessage.getText().toString();

            dataOutputStream.writeUTF(data);
            dataOutputStream.writeUTF(data1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        txtViewMobile.setText("");
        txtViewMessage.setText("");
    }
    public  void internalLoad(){
        FileInputStream fis=null;
        DataInputStream dataInputStream;
        try {
            fis= openFileInput(FILENAME);
            dataInputStream=new DataInputStream(fis);
          String text1=  dataInputStream.readUTF().toString();
            String text2=  dataInputStream.readUTF().toString();
            txtViewMobile.setText(text1);
            txtViewMessage.setText(text2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
