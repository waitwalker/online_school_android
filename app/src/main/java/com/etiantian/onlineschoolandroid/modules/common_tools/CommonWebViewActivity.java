package com.etiantian.onlineschoolandroid.modules.common_tools;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.kaopiz.kprogresshud.KProgressHUD;

public class CommonWebViewActivity extends BaseActivity implements CompoundButton.OnClickListener {

    private WebView webView;
    private ViewGroup leftBackButton;
    private Button backButton;
    private TextView titleTextView;
    private KProgressHUD hud;
    private ViewGroup homework_container;
    private ImageView answer_card;
    private ImageView edit_icon;

    @SuppressLint("JavascriptInterface")
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
        backButton = findViewById(R.id.back_button_id);
        backButton.setOnClickListener(this);
        titleTextView = findViewById(R.id.common_actionbar_textview);
        homework_container = findViewById(R.id.homework_container);
        answer_card = findViewById(R.id.answer_card);

        edit_icon = findViewById(R.id.edit_icon);

    }

    @SuppressLint("JavascriptInterface")
    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            String url = intent.getStringExtra("url");
            String title = intent.getStringExtra("title");
            boolean showAnswerCard = intent.getBooleanExtra("showAnswerCard", false);
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

            webView.addJavascriptInterface(new JavaScriptChannel(), "native");
            if (showAnswerCard) {
                homework_container.setVisibility(View.VISIBLE);
            } else {
                homework_container.setVisibility(View.INVISIBLE);
            }
        }
    }

    @JavascriptInterface
    public void message(final String message) {

        Log.d("1","h5传给原生的消息:" + message);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
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
            answer_card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 无参数调用 显示答题卡
                    webView.loadUrl("javascript:showAnswerCard()");
                }
            });

            edit_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 无参数调用 编辑
                    webView.loadUrl("javascript:showDraftCard()");
                }
            });
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

            Log.d("1","js和原生交互");
            return super.onJsAlert(view, url, message, result);
        }

        @Override
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Log.d("1","js和原生交互consoleMessage:" + consoleMessage.message());
            return super.onConsoleMessage(consoleMessage);
        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            Log.d("1","js和原生交互");
            return super.onJsConfirm(view, url, message, result);
        }

        /// 获取网页中标题
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
            case R.id.back_button_id:
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    finish();
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null) {
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            webView.clearHistory();
            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.destroy();
            webView = null;
        }
    }

    private static class JavaScriptChannel {

        @SuppressLint("JavascriptInterface")
        @JavascriptInterface
        public void handlerMessage(String msg) {
            System.out.println("JS成功调用了Android的hello方法");
        }
    }
}