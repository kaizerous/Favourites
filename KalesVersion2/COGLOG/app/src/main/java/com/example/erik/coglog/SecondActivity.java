package com.example.erik.coglog;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class SecondActivity extends ActionBarActivity {
    MainActivity _ma;
    private ListView mainListView;
    public DBHelper _favdb;
    public ArrayAdapter<String> listAdapter;
    public ArrayList<Favourite> favArr;
    public EditText edit1;
    public EditText edit2;
    public Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        _ma = new MainActivity().getMain();
        edit1 = (EditText) findViewById(R.id._et);
        edit2 = (EditText) findViewById(R.id._et1);
        btn1 = (Button) findViewById(R.id.button4);

        Log.d("Second Activity Start ", "Started");
        String UrlS = getIntent().getExtras().getString("urlString");
        edit1.setText(UrlS);

        mainListView = (ListView) findViewById(R.id.mainListView);
        ArrayList<String> urlList = new ArrayList<String>();

        favArr = new ArrayList<>();

        listAdapter = new ArrayAdapter<>(this, R.layout.list_row, urlList);
        mainListView.setAdapter(listAdapter);
        mainListView.setOnItemClickListener(new FavOnClickListener(_ma, this));

        btn1.setOnClickListener(new InsertOnClickListener(this));
        refresh();


    }
    //Refresh and update the database
    public void refresh() {
        try {
            _favdb = new DBHelper(this);
            SQLiteDatabase db = _favdb.getReadableDatabase();
            db.rawQuery("SELECT * from favs", null);
            Cursor dbCursor = db.query("favs", null, null, null, null, null, null);
            dbCursor.moveToFirst();
            while (dbCursor.moveToNext())
            {
                Log.d("DB ENTRY: ",  dbCursor.getString(0));
                listAdapter.add(dbCursor.getString(0));
                favArr.add(new Favourite(dbCursor.getString(0), dbCursor.getString(1)));
            }
            dbCursor.close();
            db.close();
        } catch (Exception e) {

        }
    }

    public void HomePage(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public MainActivity getMain() { return _ma; }
}

