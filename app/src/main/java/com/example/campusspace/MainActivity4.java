package com.example.campusspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {

    Button Profile;
    Button Book;
    Button Cancel;
    Button Bookings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Profile = findViewById(R.id.Profile);
        Bookings = findViewById(R.id.Bookings);
        Book = findViewById(R.id.Book);
        Cancel = findViewById(R.id.Cancel);

        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity4.this,MainActivity5.class);
                startActivity(intent1);
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity4.this,MainActivity12.class);
                startActivity(intent1);
            }
        });

        Bookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity4.this,MainActivity6.class);
                startActivity(intent2);
            }
        });

        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity4.this, MainActivity7.class);
                startActivity(intent2);
            }
        });

    }
}