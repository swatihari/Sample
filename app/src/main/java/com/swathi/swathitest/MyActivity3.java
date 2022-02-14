package com.swathi.swathitest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyActivity3 extends AppCompatActivity {
    TextView tv1;
    EditText et1, et2, et3;
    Button b1;
    CalendarView cv;


    @Override
    protected void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_task);
        et1 = findViewById(R.id.name);
        et2 = findViewById(R.id.password);
        et3 = findViewById(R.id.dateofbirth);



    }


}
