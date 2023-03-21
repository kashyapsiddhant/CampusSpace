package com.example.campusspace;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName = "Signup.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Sign.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table allusers(email TEXT primary key, password TEXT)");
        MyDatabase.execSQL("Create table orders(id integer primary key autoincrement,"+"name text,menu text, date text, starttime text, endtime text, hallname text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1) {
        MyDatabase.execSQL("drop Table if exists allusers");
        MyDatabase.execSQL("drop Table if exists orders");
    }
    public Boolean insertData(String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result = MyDatabase.insert("allusers", null, contentValues);

        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email = ?", new String[]{email});

        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email = ? and password = ?", new String[]{email, password});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean insertOrder(String name,String menu, String date, String time1, String time2,String hallname, int id){
        SQLiteDatabase db = getReadableDatabase();
        ByteArrayOutputStream objectByteArrayOutputStream = new ByteArrayOutputStream();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("menu",menu);
        contentValues.put("date",date);
        contentValues.put("time1",time1);
        contentValues.put("time2",time2);
        contentValues.put("id",id);
        long idd = db.insert("orders",null, contentValues);
        if(idd<=0) {
            return false;
        }
        else {
            return true;
        }
    }


}