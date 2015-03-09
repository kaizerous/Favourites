package com.example.erik.coglog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "favDB";
    private static final int DBVERSION = 2;
    private static final String TBCRT = "CREATE TABLE favs (NAME TEXT, URL TEXT);";

    public DBHelper(Context context){
        super(context, DBNAME, null, DBVERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TBCRT);
    }

    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {}
}
