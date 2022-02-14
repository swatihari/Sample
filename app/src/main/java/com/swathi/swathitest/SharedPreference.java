package com.swathi.swathitest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class SharedPreference extends Activity {
    SharedPreferences sharedpreferences;
    EditText name;
    EditText password;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Password = "passwordkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);
        name =  findViewById(R.id.etUsername);
        password =  findViewById(R.id.etPassword);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Password)) {
            password.setText(sharedpreferences.getString(Password, ""));

        }

    }

    public void Save(View view) {
        String n = name.getText().toString();
        String e = password.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Password, e);
        editor.commit();
    }

    public void clear(View view) {
        name =  findViewById(R.id.etUsername);
        password =  findViewById(R.id.etPassword);
        name.setText("");
        password.setText("");

    }

    public void Get(View view) {
        name =  findViewById(R.id.etUsername);
        password =  findViewById(R.id.etPassword);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Password)) {
            password.setText(sharedpreferences.getString(Password, ""));

        }
    }


}
