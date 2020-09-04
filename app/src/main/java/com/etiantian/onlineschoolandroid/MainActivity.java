package com.etiantian.onlineschoolandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.entrance.BaseActivity;
import com.etiantian.onlineschoolandroid.entrance.TabBarNavigationActivity;
import com.etiantian.onlineschoolandroid.modules.login.LoginActivity;
import com.etiantian.onlineschoolandroid.modules.welcome.WelcomeActivity;
import com.etiantian.onlineschoolandroid.singleton.RuntimeDataManager;
import com.etiantian.onlineschoolandroid.tools.PackageInfoManager;
import com.etiantian.onlineschoolandroid.tools.SharedPreferencesManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Date;
import java.util.HashMap;

///
/// @description 入口页:执行splash动画,然后依据逻辑跳转到:1)欢迎页或者2)主页或者3)登录页
/// @author waitwalker
/// @time 2020/9/2 2:28 PM
///
public class MainActivity extends BaseActivity implements CompoundButton.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gotoPage();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

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
            case R.id.button:
                String name = SharedPreferencesManager.instance().getString("name");
                Log.d("1","获取到的name:" + name);
                break;
        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}