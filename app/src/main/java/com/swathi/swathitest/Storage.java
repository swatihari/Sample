package com.swathi.swathitest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import androidx.appcompat.app.AppCompatActivity;


public class Storage extends Activity {
    TextView tvHeading, tvRead;
    EditText et;
    Button btnSave, btnLoad;
    String data = "";
    String fileName = "MyData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        tvHeading = findViewById(R.id.tvHeading);
        tvRead = findViewById(R.id.tvRead);
        et = findViewById(R.id.et);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);


        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(Storage.this, "Please enter Text", Toast.LENGTH_SHORT).show();
                }
                data = et.getText().toString();
                try {
                    FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();
                    Toast.makeText(Storage.this, "Data Saved", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fin = openFileInput(fileName);
                    int c;
                    String temp = "";
                    while ((c = fin.read()) != -1) {
                        temp = temp + Character.toString((char) c);
                    }
                    tvRead.setText(temp);
                    Toast.makeText(getBaseContext(), "file read", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }


            }
        });

    }
}