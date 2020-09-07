package com.etiantian.onlineschoolandroid.modules.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.etiantian.onlineschoolandroid.MainActivity;
import com.etiantian.onlineschoolandroid.R;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        invadeStatusBar();
        Thread myThread = new Thread() {//创建子线程
            @Override
            public void run() {
                try {
                    Intent it = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(it);
                    finish();//关闭当前活动
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();//启动线程

    }

    protected void invadeStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}