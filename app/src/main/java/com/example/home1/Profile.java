package com.example.home1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.home1.SQLLite.Item;
import com.example.home1.SQLLite.SQLItem;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView text = (TextView) findViewById(R.id.tv);
        String userName = ZSharedPreferences.getString(Profile.this, ZSharedPreferences.USERNAME, ZSharedPreferences.default_USERNAME);
        String password = ZSharedPreferences.getString(Profile.this, ZSharedPreferences.PASSWORD, ZSharedPreferences.default_PASSWORD);
        int age = ZSharedPreferences.getInteger(Profile.this, ZSharedPreferences.AGE, ZSharedPreferences.default_AGE);
        boolean gender = ZSharedPreferences.getBoolean(Profile.this, ZSharedPreferences.GENDER, ZSharedPreferences.default_GENDER);
        String stringGender;
        if (gender)
            stringGender = "Male";
        else
            stringGender = "Female";
        SQLItem sqlItem = new SQLItem(Profile.this);
        Item[] items = sqlItem.getGroupItem(Profile.this);
        String x = "";

        for (int i = 0; i < items.length; i++) {
            x += items[i].getName() + "\n";
        }
        text.setText("userName : " + userName + "\n" +
                "password : " + password + "\n" +
                "age : " + age + "\n" +
                "gender : " + stringGender + "\n" +
                "items : " + x + "\n"
        );
//        text.setText(SignUp);
    }
}