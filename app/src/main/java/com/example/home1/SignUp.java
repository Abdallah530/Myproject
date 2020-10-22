package com.example.home1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final TextInputEditText user = findViewById(R.id.et_Name);
        final TextInputEditText pass = findViewById(R.id.et_password);
        final TextInputEditText old = findViewById(R.id.et_age);
        Button con = (Button) findViewById(R.id.btn_confirm_sign);
        final RadioButton male = (RadioButton) findViewById(R.id.radioButton_MAle);
        final RadioButton female = (RadioButton) findViewById(R.id.radioButton__Female);

//        male.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getBaseContext(), "male", Toast.LENGTH_LONG).show();
//            }
//
//
//        });
//        female.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getBaseContext(), "Female", Toast.LENGTH_LONG).show();
//            }
//        });
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZSharedPreferences.setString(SignUp.this, ZSharedPreferences.USERNAME, user.getText().toString());
                ZSharedPreferences.setString(SignUp.this, ZSharedPreferences.PASSWORD, pass.getText().toString());
                try {
                    ZSharedPreferences.setInteger(SignUp.this, ZSharedPreferences.AGE, Integer.parseInt(old.getText().toString()));
                } catch (Exception e) {
                    Toast.makeText(SignUp.this, "Age is invalid", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (male.isChecked())
                    ZSharedPreferences.setBoolean(SignUp.this, ZSharedPreferences.GENDER, true);
                else
                    ZSharedPreferences.setBoolean(SignUp.this, ZSharedPreferences.GENDER, false);
//                Toast.makeText(getBaseContext(), "welcome", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}