package com.swathi.swathitest;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class ClickPopup extends Activity {
    Button btnClickhere;
    ImageView imgClear;
    Spinner spinner1, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpop);
        btnClickhere = findViewById(R.id.btnClickhere);
        btnClickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
    }

    public void showAlertDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_popup);
        imgClear = dialog.findViewById(R.id.imgClear);
        spinner1 = dialog.findViewById(R.id.spinner1);
        spinner2 = dialog.findViewById(R.id.spinner2);

        ArrayAdapter statesAdapter
                = new ArrayAdapter(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.states));
        spinner1.setAdapter(statesAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Selected Value", "" + spinner1.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter citiesAdapter
                = new ArrayAdapter(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.cities));
        spinner2.setAdapter(citiesAdapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Selected Value", "" + spinner2.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dialog.show();
        imgClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
