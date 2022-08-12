package com.example.hsmstart;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "hsmstart.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table VCA(id Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("Drop Table VCA");
    }

    public Boolean vcaRegistration(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        Long result = database.insert("VCA",null,contentValues);
        if(result == -1){
            return false;
        } else {
            return true;
        }


    }

}
