package com.etiantian.onlineschoolandroid.modules.splash;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import androidx.appcompat.app.ActionBar;

import com.airbnb.lottie.LottieAnimationView;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.entrance.TabBarNavigationActivity;
import com.etiantian.onlineschoolandroid.modules.login.LoginActivity;
import com.etiantian.onlineschoolandroid.modules.welcome.WelcomeActivity;
import com.etiantian.onlineschoolandroid.singleton.RuntimeDataManager;
import com.etiantian.onlineschoolandroid.tools.PackageInfoManager;
import com.etiantian.onlineschoolandroid.tools.SharedPreferencesManager;

import java.util.Date;

///
/// @description 入口页:执行splash动画,然后依据逻辑跳转到:1)欢迎页或者2)主页或者3)登录页
/// @author waitwalker
/// @time 2020/9/2 2:28 PM
///
public class SplashActivity extends BaseActivity implements CompoundButton.OnClickListener {

    private LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        lottieAnimationView = findViewById(R.id.lottie_layer);
        //自定义动画的速率和时长
        ValueAnimator valueAnimator = ValueAnimator
                .ofFloat(0f, 1f)
                .setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                Log.d("1","动画进度:" + value);
                if (value == 1.0) {
                    gotoPage();
                }
            }
        });
        valueAnimator.start();

    }

    ///
    /// @description 跳转到相应页面
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/7 3:16 PM
    ///
    private void gotoPage() {
        int versionCode = PackageInfoManager.getVersionCode(this);
        int savedVersionCode = SharedPreferencesManager.instance().getInt("versionCode");

        Log.d("1","App版本号:" + versionCode);
        // 版本号一致 跳到首页 不需要展示欢迎引导页
        if (versionCode == savedVersionCode) {
            String token = SharedPreferencesManager.instance().getString("token");
            long savedExpiration = SharedPreferencesManager.instance().getLong("expiration");
            long currentTimestamp = new Date().getTime();

            // 到首页
            if (token.length() > 0 && savedExpiration > currentTimestamp) {
                RuntimeDataManager.instance().setToken(token);
                navigateTo(TabBarNavigationActivity.class);
            } else {
                // 到登录页
                RuntimeDataManager.instance().setToken(null);
                navigateTo(LoginActivity.class);
            }
        } else {
            // 到欢迎引导页
            navigateTo(WelcomeActivity.class);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}