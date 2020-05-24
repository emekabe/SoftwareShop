package com.softwareshopltd.softwareshop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebsiteActivity extends AppCompatActivity {

    private WebView webPage;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        webPage = findViewById(R.id.webpage);

        webPage.setWebViewClient(new WebViewClient());
        webPage.getSettings().setJavaScriptEnabled(true);
        webPage.loadUrl("https://softwareshopltd.com/");

    }
}
