package com.example.campusspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity7 extends AppCompatActivity {
    TextView au,cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        au = findViewById(R.id.au);
        cl = findViewById(R.id.cl);

        au.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity7.this,MainActivity11.class);
                startActivity(intent1);
            }
        });

        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity7.this,MainActivity8.class);
                startActivity(intent2);
            }
        });
    }
}