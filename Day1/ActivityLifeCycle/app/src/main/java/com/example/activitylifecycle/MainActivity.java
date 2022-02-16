package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static  final String TAG= MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Activity LifeCycle","OnCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Activity LifeCycle" , "On Start");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Activity LifeCycle" , "On Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Activity LifeCycle" , "On Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Activity LifeCycle" , "On Stop");
    }
    protected void onRestart() {
        super.onRestart();
        Log.i("Activity lifecycle","on Restart ");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("lifecycle","onDestroy ");
    }
}