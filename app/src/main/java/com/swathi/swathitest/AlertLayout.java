package com.swathi.swathitest;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AlertLayout extends AppCompatActivity {
    Button alertShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        alertShow = findViewById(R.id.button);
        alertShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
    }

    public void showAlertDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_alert_layout);
        Button yes = (Button) dialog.findViewById(R.id.btn_yes);
        Button no = (Button) dialog.findViewById(R.id.btn_no);
        //if button is clicked, close the custom dialog
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Dismissed..!!", Toast.LENGTH_SHORT).show();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Dismissed..!!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();


    }

}
