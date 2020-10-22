package com.example.home1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Resetpassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
        final EditText e1=(EditText)findViewById(R.id.new_user);
        final EditText e2=(EditText)findViewById(R.id.new_pass);
        Button con=(Button)findViewById(R.id.btn_confirmreset);

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e1.getText().toString().equals(ZSharedPreferences.getString(Resetpassword.this,ZSharedPreferences.USERNAME,ZSharedPreferences.default_USERNAME))) {
//                    Toast.makeText(getBaseContext(),"change complete",Toast.LENGTH_LONG).show();
                    ZSharedPreferences.setString(Resetpassword.this,ZSharedPreferences.PASSWORD, e2.getText().toString());
                    Toast.makeText(getBaseContext(),"Your Password is changed",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(getBaseContext(),"not change",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

