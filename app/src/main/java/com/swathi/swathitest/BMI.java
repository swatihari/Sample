package com.swathi.swathitest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class BMI extends AppCompatActivity {
    EditText etWeight, etHeight;
    Spinner spWeightUnit, spHeightUnit;
    RadioGroup rbGroup;
    RadioButton rbMale, rbFemale;
    Button btnCalculate;
    TextView result, tvResult1, tvResult2, tvResult3, tvResult4, tvResult5;
    float value1, value2;
    float bmiValue;
    ImageView imgclear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        result = findViewById(R.id.result);
        spWeightUnit = findViewById(R.id.spWeightUnit);
        spHeightUnit = findViewById(R.id.spHeightUnit);
        rbGroup = findViewById(R.id.rbGroup);
        rbMale = findViewById(R.id.rbmale);
        rbFemale = findViewById(R.id.rbfemale);
        btnCalculate = findViewById(R.id.calculate);
        tvResult1 = findViewById(R.id.tvResult1);
        tvResult2 = findViewById(R.id.tvResult2);
        tvResult3 = findViewById(R.id.tvResult3);
        tvResult4 = findViewById(R.id.tvResult4);
        tvResult5 = findViewById(R.id.tvResult5);
        imgclear = findViewById(R.id.imgClear);


        ArrayAdapter weightAdapter
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.weight));

        spWeightUnit.setAdapter(weightAdapter);

        spWeightUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Selected Value", "" + spWeightUnit.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter heightAdapter
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.height));

        spHeightUnit.setAdapter(heightAdapter);

        spHeightUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Selected Value", "" + spHeightUnit.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maleCalculation();
               // sendBroadcast(new Intent(BMI.this, MyBroadCast.class).setAction("MyDemo"));

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregisterReceiver(new MyBroadCast());
    }

    private void maleCalculation() {
        if (spHeightUnit.getSelectedItemPosition() == 1) {
            value1 = Float.parseFloat(etWeight.getText().toString());
            value2 = Float.parseFloat(etHeight.getText().toString());
            bmiValue = value1 / (value2 * value2);
            result.setText("" + bmiValue);
            if (bmiValue < 18.5) {
                tvResult2.setTextColor(ContextCompat.getColor(BMI.this, R.color.purple_700));
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(50);
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                tvResult2.startAnimation(anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        anim.cancel();
                    }
                }, 5000);
            } else if (bmiValue > 18.5 && bmiValue < 24.9) {
                tvResult3.setTextColor(ContextCompat.getColor(BMI.this, R.color.purple_200));
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(50);
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                tvResult3.startAnimation(anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        anim.cancel();
                    }
                }, 5000);
            } else if (bmiValue > 24.9 && bmiValue < 29.9) {
                tvResult4.setTextColor(ContextCompat.getColor(BMI.this, R.color.black));
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(50);
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                tvResult4.startAnimation(anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        anim.cancel();
                    }
                }, 5000);

            } else if (bmiValue > 30) {
                tvResult5.setTextColor(ContextCompat.getColor(BMI.this, R.color.red));
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(50);
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                tvResult5.startAnimation(anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        anim.cancel();
                    }
                }, 5000);
            }
        } else if (spHeightUnit.getSelectedItemPosition() == 2) {
            value1 = Integer.parseInt(etWeight.getText().toString());
            value2 = Integer.parseInt(etHeight.getText().toString());
            bmiValue = ((value1 / (value2 * value2)) * 703);

            result.setText("" + bmiValue);
        } else if (bmiValue < 18.5) {
            tvResult2.setTextColor(ContextCompat.getColor(BMI.this, R.color.white));
        } else if (bmiValue > 18.5 && bmiValue < 24.9) {
            tvResult3.setTextColor(ContextCompat.getColor(BMI.this, R.color.purple_200));
        } else if (bmiValue > 24.9 && bmiValue < 29.9) {
            tvResult4.setTextColor(ContextCompat.getColor(BMI.this, R.color.teal_700));

        } else if (bmiValue > 30) {
            tvResult5.setTextColor(ContextCompat.getColor(BMI.this, R.color.red));
        } else {
            Toast.makeText(BMI.this, "please select unit", Toast.LENGTH_SHORT).show();
        }
        imgclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("");
                spWeightUnit.setSelection(0);
                spHeightUnit.setSelection(0);
                rbMale.setChecked(false);
                rbFemale.setChecked(false);
                etWeight.setText("");
                etHeight.setText("");

            }
        });
    }
}
