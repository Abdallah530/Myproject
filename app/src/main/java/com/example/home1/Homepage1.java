package com.example.home1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Homepage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button getLoc;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage1);
        getLoc = (Button) findViewById(R.id.btn_getLoc);
        ActivityCompat.requestPermissions(Homepage1.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        getLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GpsStriker gt = new GpsStriker(getApplicationContext());
                Location l = gt.getLocation();
                if( l == null){
                    Toast.makeText(getApplicationContext(),"GPS unable to get Value",Toast.LENGTH_SHORT).show();
                }else {
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    Toast.makeText(getApplicationContext(),"GPS Lat = "+lat+"\n lon = "+lon,Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}

