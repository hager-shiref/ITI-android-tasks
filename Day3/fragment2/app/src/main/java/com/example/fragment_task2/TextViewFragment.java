package com.example.fragment_task2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextViewFragment extends Fragment {

    TextView textCounter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("create","OnCreate");
       View view= inflater.inflate(R.layout.fragment_text_view, container, false);
        textCounter=view.findViewById(R.id.counter);
       return view;
    }
    public  void setTextCounter(int v){
       this.textCounter.setText(v + "");
    }
}