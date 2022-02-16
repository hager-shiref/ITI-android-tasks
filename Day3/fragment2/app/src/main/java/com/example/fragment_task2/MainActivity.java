package com.example.fragment_task2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextViewFragment textViewFragment = new TextViewFragment();
        FragmentManager mgr= getSupportFragmentManager();
        FragmentTransaction trns=mgr.beginTransaction();
        trns.add(R.id.container,textViewFragment,"Fragment");
        trns.commit();
    }



    @Override
    public void changeData(int v) {
            TextViewFragment textViewFragment= (TextViewFragment) getSupportFragmentManager().findFragmentById(R.id.container);
            textViewFragment.setTextCounter(v);

    }
}