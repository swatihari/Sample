package com.swathi.swathitest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class Grading extends AppCompatActivity {
    TextView tv, tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9;
    EditText et, et1, et2, et3, et4, et5;
    Button b1;
    int hindim, englishm, telugum, mathm, socialm, sciencem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grading);
        tv = findViewById(R.id.tv);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);
        tv8 = findViewById(R.id.tv8);
        et = findViewById(R.id.et);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        b1 = findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!et.getText().toString().equals(""))
                    englishm = Integer.parseInt(et.getText().toString());
                if (!et1.getText().toString().equals(""))
                    hindim = Integer.parseInt(et1.getText().toString());
                if (!et2.getText().toString().equals(""))
                    telugum = Integer.parseInt(et2.getText().toString());
                if (!et3.getText().toString().equals(""))
                    mathm = Integer.parseInt(et3.getText().toString());
                if (!et4.getText().toString().equals(""))
                    sciencem = Integer.parseInt(et4.getText().toString());
                if (!et5.getText().toString().equals(""))
                    socialm = Integer.parseInt(et5.getText().toString());
                if (englishm > 100) {
                    Toast.makeText(Grading.this, "English marks should be less than 100", Toast.LENGTH_SHORT).show();
                } else if (hindim > 100) {
                    Toast.makeText(Grading.this, "Hindi marks should be less than 100", Toast.LENGTH_SHORT).show();
                } else if (telugum > 100) {
                    Toast.makeText(Grading.this, "Telugu marks should be less than 100", Toast.LENGTH_SHORT).show();
                } else if (mathm > 100) {
                    Toast.makeText(Grading.this, "Maths marks should be less than 100", Toast.LENGTH_SHORT).show();
                } else if (sciencem > 100) {
                    Toast.makeText(Grading.this, "Science marks should be less than 100", Toast.LENGTH_SHORT).show();
                } else if (socialm > 100) {
                    Toast.makeText(Grading.this, "Social marks should be less than 100", Toast.LENGTH_SHORT).show();
                } else {
                    int finalValue = englishm + hindim + telugum + mathm + sciencem + socialm;
                    float grade = (float) finalValue / 6;
                    if (grade > 80) {
                        tv8.setText("Total:" + finalValue + " Grade A Percentage  " + Math.round(grade));
                    } else if (grade > 70 && grade < 80) {
                        tv8.setText("Total:" + finalValue + " Grade B Percentage  " + Math.round(grade));
                    } else if (grade > 60 && grade < 70) {
                        tv8.setText("Total:" + finalValue + " Grade C Percentage  " + Math.round(grade));
                    } else if (grade < 60) {
                        tv8.setText("Total:" + finalValue + " Grade D Percentage  " + Math.round(grade));
                    }

                }
            }
        });

    }
}