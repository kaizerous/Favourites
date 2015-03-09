package com.example.erik.coglog;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import android.widget.EditText;


public class MainActivity extends Activity {

    public EditText field;
    public WebView browser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStuff();

        Intent i = getIntent();

        //Get URL from favourites if it exists
        try {
            if (i.getExtras().getString("url") != null) {
                String intentUrl = i.getExtras().getString("url");
                loadURL(intentUrl);
                i.removeExtra("url");
            } else {
                browser.loadUrl(field.getText().toString());
            }
        } catch (Exception e) {
            loadURL("http://www.google.com");
        }


        if (savedInstanceState == null)
        {
            browser.loadUrl(field.getText().toString());
            loadURL(field.getText().toString());
        }

    }
    public void setStuff() {
        field = (EditText) findViewById(R.id.urlField);
        browser = (WebView) findViewById(R.id.webView1);
        browser.setWebViewClient(new MyBrowser());
    }



    //On click method for Add button
    public void AddFavourite(View view) {
        String urlS = field.getText().toString();
        Intent myIntent = new Intent(this, SecondActivity.class);
        myIntent.putExtra("urlString", urlS);
        Log.d("Url:", "UrlS is " + myIntent.getExtras().getString("urlUser"));
        startActivity(myIntent);
    }

    public void ThemePage(View view) {
        Intent themeIntent = new Intent(this, ThirdActivity.class);
        startActivity(themeIntent);
    }

    public void open(View view) {
        Intent i = getIntent();


        //Remove keyboard when Go button is pressed.
        InputMethodManager inputMgr = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText editText = (EditText)findViewById(R.id.urlField);
        inputMgr.hideSoftInputFromWindow(editText.getWindowToken(), 0);

        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        //Try to catch common errors when entering in URLs
try {
    if (field.getText().toString().equals(null) || field.getText().toString().equals("")) {
        loadURL("http://www.google.com");
    } else if (!field.getText().toString().contains("http:") && field.getText().toString().contains("www.") ||
            !field.getText().toString().contains("http://") && field.getText().toString().contains("www.")) {
        loadURL("http://" + field.getText().toString());
    } else if (field.getText().toString().contains("http://") && !field.getText().toString().contains("www.")) {
        String split[] = field.getText().toString().split("//");
        loadURL(split[0] + "www." + split[1]);
    } else if (field.getText().toString().contains("http:") && !field.getText().toString().contains("www.")) {
        String urll = field.getText().toString();
        String split[] = urll.split(":");
        Log.d("Split 0:", " " + split[0]);
        loadURL(split[0] + ":www." + split[1]);
    } else if (!field.getText().toString().contains("http:") && !field.getText().toString().contains("www.") ||
            !field.getText().toString().contains("http://") && !field.getText().toString().contains("www.")) {
        loadURL("http://www." + field.getText().toString());
    } else if (field.getText().toString().contains("http:") && field.getText().toString().contains("www.") ||
            field.getText().toString().contains("http://") && field.getText().toString().contains("www.")) {
        loadURL(field.getText().toString());
    }
}catch (Exception e){
    loadURL("http://www.google.com") ;
}

    }


    public void loadURL(String url) {
        browser.loadUrl(url);
        field.setText(url);
        if(field.getText().toString().contains("akwjhdiahwdiuahdljkwa")){
            setContentView(R.layout.activity_main);
            loadURL("http://www.google.com");
            field = new EditText(this);
            field = (EditText) findViewById(R.id.urlField);
            browser = new WebView(this);
            browser = (WebView) findViewById(R.id.webView1);
            browser.setWebViewClient(new MyBrowser());

        }
        if(field.getText().toString().contains("asdwdafafsdasdawdwada")){
            setContentView(R.layout.radio_two);
            loadURL("http://www.google.com");
            field = new EditText(this);
            field = (EditText) findViewById(R.id.urlField);
            browser = new WebView(this);
            browser = (WebView) findViewById(R.id.webView1);
            browser.setWebViewClient(new MyBrowser());

        }
        if(field.getText().toString().contains("afeaawdawdawdwadawdawd")){
            setContentView(R.layout.radio_three);
            loadURL("http://www.google.com");
            field = new EditText(this);
            field = (EditText) findViewById(R.id.urlField);
            browser = new WebView(this);
            browser = (WebView) findViewById(R.id.webView1);
            browser.setWebViewClient(new MyBrowser());

        }

        if(field.getText().toString().contains("arnold")){
            setContentView(R.layout.radio_four);
            loadURL("http://www.google.com");
            field = new EditText(this);
            field = (EditText) findViewById(R.id.urlField);
            browser = new WebView(this);
            browser = (WebView) findViewById(R.id.webView1);
            browser.setWebViewClient(new MyBrowser());

        }

    }

    //Save WebView when rotated
    @Override
    protected void onSaveInstanceState(Bundle outState )
    {
        super.onSaveInstanceState(outState);
        browser.saveState(outState);
        InputMethodManager inputMgr = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText editText = (EditText)findViewById(R.id.urlField);
        inputMgr.hideSoftInputFromWindow(editText.getWindowToken(), 0);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        browser.restoreState(savedInstanceState);

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }
    }
    public MainActivity getMain() { return this; }

}




