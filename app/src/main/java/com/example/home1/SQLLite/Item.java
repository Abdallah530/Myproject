package com.example.home1.SQLLite;

import android.content.Context;

import com.example.home1.ZSharedPreferences;

public class Item {

    private int id;
    private String name;
    private String userName;

    public Item(Context context) {
        userName = ZSharedPreferences.getString(context, ZSharedPreferences.USERNAME, ZSharedPreferences.default_USERNAME);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
