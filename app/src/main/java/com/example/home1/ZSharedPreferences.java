package com.example.home1;

import android.content.Context;
import android.preference.PreferenceManager;

public class ZSharedPreferences {

    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";
    public static final String AGE = "AGE";
    public static final String GENDER = "GENDER";
   // public static final String default_USERNAME = "abdallah";
    //public static final String default_PASSWORD = "311299";
   public static final String default_USERNAME = "1";
    public static final String default_PASSWORD = "1";
    public static final int default_AGE = 10;
    public static final boolean default_GENDER = true;//male


    public static void setString(Context context, String key, String value) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(key, value).commit();
    }

    public static void setInteger(Context context, String key, int value) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(key, value).commit();
    }

    public static void setBoolean(Context context, String key, boolean value) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(key, value).commit();
    }

    public static String getString(Context context, String key, String default_value) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(key, default_value);
    }

    public static int getInteger(Context context, String key, int default_value) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(key, default_value);
    }

    public static boolean getBoolean(Context context, String key, boolean default_value) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(key, default_value);
    }


}
