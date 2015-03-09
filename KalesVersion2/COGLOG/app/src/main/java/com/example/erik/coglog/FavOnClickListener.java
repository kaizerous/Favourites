package com.example.erik.coglog;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class FavOnClickListener implements ListView.OnItemClickListener {
    private MainActivity _ma;
    private SecondActivity _sa;
    private ArrayList<Favourite> fArr;
    public FavOnClickListener(MainActivity ma, SecondActivity sa) {
        _ma = ma;
        _sa = sa;
        fArr = _sa.favArr;
    }
    @Override
    public void onItemClick(AdapterView<?> pView, View view, int pos, long id) {
        ListView lv = (ListView) pView;
        Log.d("test", "fArr size = " + fArr.size());
        for (int i = 0; i < fArr.size(); i++) {
            Log.d("test", "fArr.get(i) = " + fArr.get(i).getUrl());
            if (fArr.get(i).getName().equals(lv.getItemAtPosition(pos).toString())) {
                Intent intent = new Intent(_sa, MainActivity.class);
                intent.putExtra("url", fArr.get(i).getUrl());
                _sa.startActivity(intent);

            }

        }
    }
}
