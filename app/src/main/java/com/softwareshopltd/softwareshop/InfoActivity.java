package com.softwareshopltd.softwareshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        WebView cvHUBsite = findViewById(R.id.cvHUBsite);

        cvHUBsite.getSettings().setJavaScriptEnabled(true);
        cvHUBsite.setWebViewClient(new WebViewClient());

        cvHUBsite.loadUrl("https://cvhub4africa.com");

    }
}
