package com.etiantian.onlineschoolandroid.modules.common_tools;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.kaopiz.kprogresshud.KProgressHUD;

public class CommonWebViewActivity extends BaseActivity implements CompoundButton.OnClickListener {

    private WebView webView;
    private ViewGroup leftBackButton;
    private TextView titleTextView;
    private KProgressHUD hud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_webview);
        initView();
        initData();
    }

    private void initView() {
        hideActionBar();
        hud = KProgressHUD.create(this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        webView = findViewById(R.id.common_webview);
        leftBackButton = findViewById(R.id.actionbar_back_button);
        leftBackButton.setOnClickListener(this);
        titleTextView = findViewById(R.id.common_actionbar_textview);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            String url = intent.getStringExtra("url");
            String title = intent.getStringExtra("title");
            titleTextView.setText(title);
            webView.loadUrl(url);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);// 允许使用js
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);//缓存默认
            webSettings.setAllowFileAccess(true);//设置可以访问文件
            webSettings.setJavaScriptCanOpenWindowsAutomatically(true);//支持通过JS打开新窗口
            webSettings.setLoadsImagesAutomatically(true);//支持自动加载图片
            webSettings.setDefaultTextEncodingName("utf-8");
            webSettings.setSupportZoom(false);
            webSettings.setSupportMultipleWindows(false);
            webSettings.setUseWideViewPort(true);//将图片调整到适合webview的大小
            webSettings.setLoadWithOverviewMode(true);//缩放至屏幕大小

            webView.setWebChromeClient(webChromeClient);
            webView.setWebViewClient(webViewClient);
        }
    }

    private WebViewClient webViewClient = new WebViewClient(){
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            hud.show();
            Log.d("1","webview开始加载url:" + url);
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            hud.dismiss();
            Log.d("1","webview停止加载url:" + url);
            super.onPageFinished(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Log.d("1","webview重定向url:" + request.getUrl());
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Log.d("1","webview加载错误url:" + request.getUrl() + "错误:" + error.getDescription());
            super.onReceivedError(view, request, error);
        }


    };

    private WebChromeClient webChromeClient = new WebChromeClient(){
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            Log.d("1","用户协议网页加载进度:" + newProgress);
            super.onProgressChanged(view, newProgress);
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actionbar_back_button:
                break;
        }
    }
}