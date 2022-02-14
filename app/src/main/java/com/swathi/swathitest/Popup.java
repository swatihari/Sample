package com.swathi.swathitest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Popup extends Activity {
    TextView tvHeading, tvadd;
    ImageView imgClear;
    Spinner spinner1, spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        tvHeading = findViewById(R.id.tvHeading);
        tvadd = findViewById(R.id.tvadd);
        imgClear = findViewById(R.id.imgClear);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);

        ArrayAdapter stateAdapter
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.states));
        spinner1.setAdapter(stateAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Selected Value", "" + spinner1.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
