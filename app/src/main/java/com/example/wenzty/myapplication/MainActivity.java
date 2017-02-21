package com.example.wenzty.myapplication;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.loadUrl("http://a1.gdcp.cn/index.shtml");
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        mWebView.setWebChromeClient( new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress==100){
                    Toast.makeText(MainActivity.this,"网页加载完成",Toast.LENGTH_LONG).show();
                }else {

                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }

        public boolean onKeyDown(int keyCode,KeyEvent event){

        if (keyCode==KeyEvent.KEYCODE_BACK){
            if (mWebView.canGoBack()){
                mWebView.goBack();
                return true;
            }else{
                System.exit(0);
            }
        }

        return super.onKeyDown(keyCode,event);
    }

    }

