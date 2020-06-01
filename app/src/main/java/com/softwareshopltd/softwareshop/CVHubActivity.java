package com.softwareshopltd.softwareshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class CVHubActivity extends AppCompatActivity {

    ProgressBar progressBar;
    WebView cvHUBsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_v_hub);

        progressBar = findViewById(R.id.progress_circular);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        cvHUBsite = findViewById(R.id.cvHUBsite);

        renderWebPage("https://cvhub4africa.com", cvHUBsite);
    }

    protected void renderWebPage(String urlToRender, final WebView webViewToDoStuff){
        webViewToDoStuff.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                cvHUBsite.setVisibility(View.VISIBLE);
                webViewToDoStuff.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url){
                webViewToDoStuff.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        });

        webViewToDoStuff.setWebChromeClient(new WebChromeClient(){
            public void onProgressChanged(WebView view, int newProgress){

                progressBar.setProgress(newProgress);

                if (newProgress == 100){
                    progressBar.setVisibility(View.GONE);
                    webViewToDoStuff.setVisibility(View.VISIBLE);
                }
            }
        });

        webViewToDoStuff.getSettings().setJavaScriptEnabled(true);
        webViewToDoStuff.loadUrl(urlToRender);
    }

    //When I show a page with an hyperlink
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if ((keyCode == KeyEvent.KEYCODE_BACK) && cvHUBsite.canGoBack()){
            cvHUBsite.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
