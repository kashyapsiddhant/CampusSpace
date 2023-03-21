package com.example.campusspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        textView = findViewById(R.id.details);
        Intent intent = getIntent();
        String location = intent.getStringExtra(MainActivity11.AUDITORIUM);
        String build = intent.getStringExtra(MainActivity8.BUILDING);
        String floo = intent.getStringExtra(MainActivity8.FLOOR);
        String roo = intent.getStringExtra(MainActivity8.ROOM);
        String startdate = intent.getStringExtra(MainActivity11.STARTDATE);
        String starttime = intent.getStringExtra(MainActivity11.STARTTIME);
        String endtime = intent.getStringExtra(MainActivity11.ENDTIME);
        String enddate = intent.getStringExtra(MainActivity11.ENDDATE);
        textView.setText("LOCATION : \n"+ location+"\n"+build+"\n"+floo+"\n"+roo+"\n"+
                "\nSTART DATE : \n"+ startdate+"\n"+
                "\nEND DATE : \n"+ enddate+"\n"+
                "\nSTART TIME : \n"+ starttime+"\n"+
                "\nEND TIME : \n"+ endtime);





    }
}