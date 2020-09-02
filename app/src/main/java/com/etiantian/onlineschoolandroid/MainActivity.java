package com.etiantian.onlineschoolandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.entrance.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.login.LoginActivity;
import com.etiantian.onlineschoolandroid.tools.SharedPreferencesManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

        EventBus.getDefault().register(this);

        SharedPreferencesManager.instance().putString("name","张三");
        SharedPreferencesManager.instance().putString("token","fkssfgdsg");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);



        NetworkManager.activityCourseAlert(new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.d("1","响应成功");
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","响应失败");
            }
        });


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

    ///
    /// @description 处理EventBus发来的消息
    /// @param 
    /// @return 
    /// @author waitwalker
    /// @time 2020/9/2 2:05 PM
    ///
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleEventBus(Object object){

        Log.d("1","消息:");
        if (object instanceof HashMap) {
            HashMap hashMap = (HashMap) object;
            int errorCode = (int) hashMap.get("errorCode");
            String message = (String) hashMap.get("message");
            String errorMsg;

            Log.d("1","错误码:" + errorCode + "\n" + "错误消息:" + message);

            switch (errorCode) {
                case 401:
                    showToast("授权失败");
                    navigateTo(LoginActivity.class);
                    break;
                case 403:
                    showToast("禁止访问");
                    break;
                case 404:
                    showToast("网络错误404");
                    break;
                case 413:
                    showToast("上传文件太大");
                    break;
                case 500:
                    showToast("服务器错误");
                    break;
                default:
                    break;
            }
        }
    }


    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}