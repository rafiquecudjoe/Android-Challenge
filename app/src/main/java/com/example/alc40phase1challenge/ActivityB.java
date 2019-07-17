package com.example.alc40phase1challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity {
    private WebView webView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        webView = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progresBar);

        //set toolbar
        getSupportActionBar().setTitle(getString(R.string.about_alc));


        //load url
        progressBar.setMax(50);
        webView.setVisibility(View.INVISIBLE);
        webView.loadUrl(getString(R.string.andela_about_page));

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {



                                     @Override
                                     public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
                                         handler.proceed();

                                     }


                                     @Override
                                     public void onPageFinished(WebView view, String url) {
                                         super.onPageFinished(view, url);
                                         webView.setVisibility(View.VISIBLE);
                                         progressBar.setVisibility(View.GONE);
                                     }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Toast.makeText(ActivityB.this, R.string.error_loading_page, Toast.LENGTH_SHORT).show();
            }
                                 }


        );
    }

    //backpress from webpage
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }

    }



}

