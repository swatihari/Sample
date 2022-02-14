package com.swathi.swathitest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BroadCastActivity extends AppCompatActivity {

    Button startService, stopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybrodcast);
        startService = findViewById(R.id.btStart);
        stopService = findViewById(R.id.btStop);

        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(BroadCastActivity.this, MyService.class);
                startService(myintent);
            }
        });
        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(BroadCastActivity.this, Broadcast.class);
                startActivity(myintent);
            }
        });

    }
}