package com.etiantian.onlineschoolandroid.modules.common_tools;


import android.os.Bundle;
import android.webkit.WebView;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;

public class CommonWebViewActivity extends BaseActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_webview);
        initView();
    }

    private void initView() {
        hideActionBar();
        webView = findViewById(R.id.common_webview);
    }
}