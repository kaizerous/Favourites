package com.example.erik.coglog;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;


public class RadioOnClickListener implements Button.OnClickListener {
    private ThirdActivity _screen;

    public RadioOnClickListener(ThirdActivity screen)
    {
        super();
        _screen = screen;

    }

    @Override
    public void onClick(View v) {
        Intent myTheme = new Intent(_screen, MainActivity.class);

        //random string so users cannot guess theme through URL

        if (_screen.r1.isChecked()) {
            myTheme.putExtra("url", "akwjhdiahwdiuahdljkwa");
            _screen.startActivity(myTheme);

        }

        if (_screen.r2.isChecked()) {
            myTheme.putExtra("url", "asdwdafafsdasdawdwada");
            _screen.startActivity(myTheme);
            }

        if (_screen.r3.isChecked()) {
            myTheme.putExtra("url", "afeaawdawdawdwadawdawd");
            _screen.startActivity(myTheme);
            }

        if (_screen.r4.isChecked()) {
            myTheme.putExtra("url", "arnold");
            _screen.startActivity(myTheme);
        }

    }

}
