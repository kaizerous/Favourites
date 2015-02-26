package com.example.kalechenier.test;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;

public class WebViewActivity extends Activity {

    private WebView webView;
    private WebView webView2;
    private WebView webView3;
    private WebView webView4;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);


        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.google.com");

        webView2 = (WebView) findViewById(R.id.webView1);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.loadUrl("http://www.reddit.com");

        webView3 = (WebView) findViewById(R.id.webView1);
        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.loadUrl("http://www.facebook.com");

        webView4 = (WebView) findViewById(R.id.webView1);
        webView4.getSettings().setJavaScriptEnabled(true);
        webView4.loadUrl("http://www.youtube.com");






        //LOAD CUSTOM WEBPAGE
        //String customHtml = "<html><body><h1>Hello, WebView</h1></body></html>";
        //webView.loadData(customHtml, "text/html", "UTF-8");

    }

}






