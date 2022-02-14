package com.swathi.swathitest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LifeCycleActivity extends Activity {
    Button btonCreate, btonStart, btonResume, btonPause, btonStop, btonRestart, btonDestroy;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        btonCreate = findViewById(R.id.btonCreate);
        btonStart = findViewById(R.id.btonStart);
        btonResume = findViewById(R.id.btonResume);
        btonPause = findViewById(R.id.btonPause);
        btonStop = findViewById(R.id.btonStop);
        btonRestart = findViewById(R.id.btonRestart);
        btonDestroy = findViewById(R.id.btonDestroy);

        btonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LifeCycleActivity.this, "called when activity is first created", Toast.LENGTH_LONG).show();
            }
        });
        btonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LifeCycleActivity.this, "called when activity is becoming visible to the user", Toast.LENGTH_LONG).show();
            }
        });
        btonResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LifeCycleActivity.this, "called when activity will start interacting with the user", Toast.LENGTH_LONG).show();
            }
        });
        btonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LifeCycleActivity.this, "called when activity is not visible to the user", Toast.LENGTH_LONG).show();
            }
        });
        btonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LifeCycleActivity.this, "called when activity is no longer visible to the user", Toast.LENGTH_LONG).show();
            }
        });
        btonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LifeCycleActivity.this, "called after your activity is stopped, prior to start", Toast.LENGTH_LONG).show();
            }
        });
        btonDestroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LifeCycleActivity.this, "called before the activity is destroyed", Toast.LENGTH_LONG).show();
            }
        });
    }
}


