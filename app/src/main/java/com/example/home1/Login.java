package com.example.home1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextInputEditText name = findViewById(R.id.et_Name);
        final TextInputEditText pass = findViewById(R.id.etpass);
        Button submet = (Button) findViewById(R.id.btn_submet_login);
        TextView forget =  findViewById(R.id.tv_forget_login);
        Button sign=(Button)findViewById(R.id.btn_Signup);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Login.this,SignUp.class);
                startActivity(i);
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Resetpassword.class);
                startActivity(i);
            }
        });
        submet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().equals(ZSharedPreferences.getString(Login.this, ZSharedPreferences.USERNAME, ZSharedPreferences.default_USERNAME)) &&
                        pass.getText().toString().equals(ZSharedPreferences.getString(Login.this, ZSharedPreferences.PASSWORD, ZSharedPreferences.default_PASSWORD)) ) {
                    Toast.makeText(getBaseContext(),"Welcome",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, Homepage1.class);
                    //  i.putExtra("key1",name.getText().toString());
                    startActivity(i);
                    finish();
//                    Toast.makeText(getBaseContext(), "Log in cpmplete", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_LONG).show();
                    //  Toast.makeText(getBaseContext(),sp.getString("user",""),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}