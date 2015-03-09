package com.example.erik.coglog;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class ThirdActivity extends ActionBarActivity {
    public RadioGroup radioG;
    public RadioButton r1;
    public RadioButton r2;
    public RadioButton r3;
    public RadioButton r4;
    public Button btn1;
    public Button btn2;
    public int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        setStuff();
        btn1.setOnClickListener(new RadioOnClickListener(this));
        Log.d("test", " " +i);
    }

    public void setStuff(){
        radioG = (RadioGroup) findViewById(R.id.RadioGroup1);
        r1 = (RadioButton) findViewById(R.id.radio1);
        r2 = (RadioButton) findViewById(R.id.radio2);
        r3 = (RadioButton) findViewById(R.id.radio3);
        r4 = (RadioButton) findViewById(R.id.radio4);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button5);
    }

    public void Home(View view) {
        Intent thIntent = new Intent(this, MainActivity.class);
        startActivity(thIntent);
        }
    }

