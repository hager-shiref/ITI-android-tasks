package com.example.badlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


class DayAdapter extends ArrayAdapter<Day>{
    private Context context;
    private Day [] days;

    public DayAdapter(@NonNull Context context, @NonNull Day[]objects) {
        super(context, R.layout.mylist,R.id.title,objects);
        this.context = context;
        days=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=null;
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.mylist,parent,false);
        TextView textViewTitle=view.findViewById(R.id.title);
        TextView textViewDescription =view.findViewById(R.id.subtitle);
        ImageView imageView=view.findViewById(R.id.imageView);
        textViewTitle.setText(days[position].getDayTitle());
        textViewDescription.setText(days[position].getDayDescription());
        imageView.setImageResource(days[position].getImageResourceId());
        return  view;
    }
}