package com.swathi.swathitest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;

public class SimpleCalculator extends AppCompatActivity {
    TextView calculator, tvanswer;
    EditText et1, et2;
    AppCompatSpinner spMyValue, spMyValue1;
    AppCompatButton btnDivide, btnMulti, btnAdd, btnSubstract;
    int value1, value2;
    RadioGroup radioGroup;
    RadioButton rb1, rb2, rb3, rb4;

    ImageView imgclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplecalculator);

        calculator = findViewById(R.id.calculator);
        tvanswer = findViewById(R.id.tvAnswer);
        spMyValue = findViewById(R.id.spMyValue);
        spMyValue1 = findViewById(R.id.spMyValue1);
        btnDivide = findViewById(R.id.btnDivide);
        btnMulti = findViewById(R.id.btnMulti);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubstract = findViewById(R.id.btnSubstract);
        radioGroup = findViewById(R.id.rbGroup);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);

        imgclear = findViewById(R.id.imgClear);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb1:
                        Toast.makeText(SimpleCalculator.this, "cliked on divide", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb2:
                        Toast.makeText(SimpleCalculator.this, "clicked on multiply", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb3:
                        Toast.makeText(SimpleCalculator.this, "cliked on addition", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb4:
                        Toast.makeText(SimpleCalculator.this, "clicked on minus", Toast.LENGTH_SHORT).show();
                }
            }
        });
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Integer.parseInt(spMyValue.getSelectedItem().toString());
                value2 = Integer.parseInt(spMyValue1.getSelectedItem().toString());
                int finalValue = value1 / value2;
                tvanswer.setText("Division: " + finalValue);
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Integer.parseInt(spMyValue.getSelectedItem().toString());
                value2 = Integer.parseInt(spMyValue1.getSelectedItem().toString());
                int finalValue = value1 * value2;
                tvanswer.setText("Multiply: " + finalValue);
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Integer.parseInt(spMyValue.getSelectedItem().toString());
                value2 = Integer.parseInt(spMyValue1.getSelectedItem().toString());
                int finalValue = value1 + value2;
                tvanswer.setText("Addition: " + finalValue);
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Integer.parseInt(spMyValue.getSelectedItem().toString());
                value2 = Integer.parseInt(spMyValue1.getSelectedItem().toString());
                int finalValue = value1 - value2;
                tvanswer.setText("Substract: " + finalValue);
            }
        });
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.marks));

        spMyValue.setAdapter(ad);

        spMyValue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Selected Value", "" + spMyValue.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spMyValue1.setAdapter(ad);

        spMyValue1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Selected Value", "" + spMyValue1.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Integer.parseInt(spMyValue.getSelectedItem().toString());
                value2 = Integer.parseInt(spMyValue1.getSelectedItem().toString());
                int finalValue = value1 + value2;
                tvanswer.setText("Addition: " + finalValue);
                for (int i = 5; i <= 10; i++) {
                    Log.e("####", "Values" + i);
                }


            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Integer.parseInt(spMyValue.getSelectedItem().toString());
                value2 = Integer.parseInt(spMyValue1.getSelectedItem().toString());
                int finalValue = value1 / value2;
                tvanswer.setText("Division: " + finalValue);
            }
        });
        btnSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Integer.parseInt(spMyValue.getSelectedItem().toString());
                value2 = Integer.parseInt(spMyValue1.getSelectedItem().toString());
                int finalValue = value1 - value2;
                tvanswer.setText("Substract: " + finalValue);
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Integer.parseInt(spMyValue.getSelectedItem().toString());
                value2 = Integer.parseInt(spMyValue1.getSelectedItem().toString());
                int finalValue = value1 * value2;
                tvanswer.setText("Multiply: " + finalValue);
            }
        });
        imgclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spMyValue.setSelection(0);
                spMyValue1.setSelection(0);
                tvanswer.setText("");
            }
        });
    }
}



