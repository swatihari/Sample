package com.swathi.swathitest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyTask extends AppCompatActivity {

    TextView tv1;
    EditText name, password;
    Button btnLogin, btnRegister;
    ImageView imgclear;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        tv1 = findViewById(R.id.tv1);
        name = findViewById(R.id.etname);
        password = findViewById(R.id.etpassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        imgclear = findViewById(R.id.imgClear);
        WebView browser = (WebView) findViewById(R.id.webView);
        browser.loadUrl("https://www.cartrade.com");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(MyTask.this, "Please enter username", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(MyTask.this, "Please enter password", Toast.LENGTH_SHORT).show();
                } else {
                    if (name.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                        Intent myintent = new Intent(MyTask.this, HomeScreen_1.class);
                        startActivity(myintent);
                    } else {
                        Toast.makeText(MyTask.this, "Wrong credentials", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
imgclear.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        name.setText("");
        password.setText("");
    }
});
    }
}