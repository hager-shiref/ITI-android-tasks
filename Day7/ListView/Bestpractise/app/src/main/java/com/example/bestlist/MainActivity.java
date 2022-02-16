package com.example.bestlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        Day [] days= {new Day("Saturday", "Saturday Description", R.drawable.image1),
                new Day("Sunday","Sunday Description",R.drawable.image2),
                new Day("Monday","Monday Description",R.drawable.image3),
                new Day("Tuesday","Tuesday Description",R.drawable.image4),
                new Day("Wednesday","Wednesday Description",R.drawable.image5),
                new Day("Thursday","Thursday Description",R.drawable.image6),
                new Day("Friday","Friday Description",R.drawable.image7 )
        };
        DayAdapter adapter = new DayAdapter(this,days);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,parent.getAdapter().getItem(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}