package com.etiantian.onlineschoolandroid.modules.common_tools;


import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;

public class CommonWebViewActivity extends BaseActivity implements CompoundButton.OnClickListener {

    private WebView webView;
    private ViewGroup leftBackButton;
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_webview);
        initView();
    }

    private void initView() {
        hideActionBar();
        webView = findViewById(R.id.common_webview);

        leftBackButton = findViewById(R.id.actionbar_back_button);
        leftBackButton.setOnClickListener(this);
        titleTextView = findViewById(R.id.common_actionbar_textview);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actionbar_back_button:
                break;
        }
    }
}