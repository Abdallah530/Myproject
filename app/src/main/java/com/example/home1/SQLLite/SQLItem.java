package com.example.home1.SQLLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.home1.ZSharedPreferences;

public class SQLItem extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ZDB";

    public static final String TABLE_NAME = "Item";

    public static final String itemId = "id";
    public static final String itemName = "name";
    public static final String itemUserName = "user_name";

    public SQLItem(Context context) {
        super(context, DATABASE_NAME, null, 1);
        onCreate(getWritableDatabase());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(
                    "CREATE TABLE " + TABLE_NAME + " (" +
                            itemId + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                            itemName + " TEXT," +
                            itemUserName + " TEXT" +
                            ") ");
        } catch (Exception e) {
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(itemName, item.getName());
        contentValues.put(itemUserName, item.getUserName());

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Item[] getGroupItem(Context context) {
        String userName = ZSharedPreferences.getString(context, ZSharedPreferences.USERNAME, ZSharedPreferences.default_USERNAME);

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + itemUserName + " = ?", new String[]{userName});

        Item items[] = new Item[res.getCount()];
        if (res.getCount() == 0) {
            return items;
        }
        for (int i = 0; res.moveToNext(); i++) {
            items[i] = new Item(context);
            items[i].setId(res.getInt(0));
            items[i].setName(res.getString(1));
        }
        return items;
    }

}
