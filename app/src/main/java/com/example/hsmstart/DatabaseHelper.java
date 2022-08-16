package com.example.hsmstart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.jar.Attributes;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "hsmstart.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table VCA(id Text,name Text,age Text)");
        db.execSQL("Create Table login_details(username Text,password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table VCA");
        db.execSQL("Drop Table login_details");
    }

    public Boolean vcaRegistration(String username, String password, String id, String name, String age) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("age", age);

        contentValues.put("username", username);
        contentValues.put("password", password);

        Long result = database.insert("VCA", null, contentValues);
        return result != -1;
    }

    public Cursor displayData() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from VCA", null);
        return cursor;
    }

}
