package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentJava java = new FragmentJava();
        FragmentManager mgr = getSupportFragmentManager();
        FragmentTransaction trns = mgr.beginTransaction();
        trns.add(R.id.container, java, "My fragment");
        trns.commit();
    }
}