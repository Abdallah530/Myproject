package com.example.home1;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import static android.content.Context.LOCATION_SERVICE;

public class GpsStriker implements LocationListener {
    Context context;
    public GpsStriker(Context c){
        context=c;

    }

public Location getLocation(){
    if (ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED) {
        Log.e("fist","error");
        return null;
    }
    try {
        LocationManager lm = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        boolean isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isGPSEnabled){
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000,10,this);
            Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return loc;
        }else{
            Log.e("sec","error");
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return null;
}




    @Override
    public void onLocationChanged(@NonNull Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }
}
