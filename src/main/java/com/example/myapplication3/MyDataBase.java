package com.example.myapplication3;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {


    public static final String dbName = "yousef.db";   //database name
    public static final int dbVersion = 1;         //database version

    //users tabel
    public static final String user_tabel_Name = "users";
    public static final String Uclo_id_name = "id";
    public static final String Uclo_name = "name";
    public static final String Uclo_email = "email";
    public static final String Uclo_password = "password";


    public MyDataBase(@Nullable Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+user_tabel_Name+" ("+Uclo_id_name+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +Uclo_name+" Text, "+Uclo_email+" INTEGER, "+Uclo_password+" Text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //insert_users
    public boolean insert_users(users_tabel user)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Uclo_name,user.getname());
        contentValues.put(Uclo_email,user.getemail());
        contentValues.put(Uclo_password,user.getpassword());
        //check if insert done or not
        long result_insert = sqLiteDatabase.insert(user_tabel_Name,null,contentValues);
        if(result_insert == -1)
            return false;
        return true;

    }



}

//update_users
    /*
    public boolean update_users(users_tabel user)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Uclo_name,user.getname());
        contentValues.put(Uclo_email,user.getemail());
        contentValues.put(Uclo_password,user.getpassword());

        String args[] = new String[]{user.getId()+""};
        int result_update = sqLiteDatabase.update(user_tabel_Name,contentValues,"id=?",args);
        if(result_update < 1)
            return false;
        return true;
    }