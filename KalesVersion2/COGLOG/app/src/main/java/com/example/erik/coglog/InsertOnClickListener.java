package com.example.erik.coglog;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


public class InsertOnClickListener implements Button.OnClickListener {
    private SecondActivity _screen;

    public InsertOnClickListener(SecondActivity screen)
    {
        super();
        _screen = screen;

    }

    @Override
    public void onClick(View v) {
        String name = _screen.edit2.getText().toString(),
                url = _screen.edit1.getText().toString();
        SQLiteDatabase db = _screen._favdb.getWritableDatabase();
        db.execSQL("INSERT OR REPLACE INTO favs (NAME, URL) VALUES ('"+  name + "','" + url + "');");
        _screen.favArr.add(new Favourite(name, url));
        _screen.listAdapter.add(_screen.favArr.get(_screen.favArr.size() - 1).toString());
        db.close();

    }
}

