package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by peige on 2017/4/23.
 */

public class WebViewActivity extends AppCompatActivity {

    WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWebView = (WebView) findViewById(R.id.web_view);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        mWebView.loadUrl(url);
    }
}
