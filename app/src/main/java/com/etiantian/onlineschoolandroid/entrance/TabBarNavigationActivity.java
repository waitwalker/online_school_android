package com.etiantian.onlineschoolandroid.entrance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.model.ActivityCourseAlertModel;
import com.etiantian.onlineschoolandroid.modules.login.LoginActivity;
import com.etiantian.onlineschoolandroid.tools.SharedPreferencesManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

public class TabBarNavigationActivity extends BaseActivity implements CompoundButton.OnClickListener {

    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_bar_navigation);
        initView();
        initData();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logout_button:
                SharedPreferencesManager.instance().remove("token");
                SharedPreferencesManager.instance().remove("expiration");
                navigateTo(LoginActivity.class);
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }

    /// 初始化view
    private void initView() {
        logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(this);
    }

    /// 初始化data
    private void initData() {
        EventBus.getDefault().register(this);
        testAPI();
    }

    private void testAPI() {
        NetworkManager.activityCourseAlert(new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.d("1","响应成功");
                ActivityCourseAlertModel activityCourseAlertModel = (ActivityCourseAlertModel) responseObj;
                Log.d("1","活动课接口:" + activityCourseAlertModel.getMsg());
                showToast(activityCourseAlertModel.getData().getDescription());
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","响应失败");
            }
        });
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