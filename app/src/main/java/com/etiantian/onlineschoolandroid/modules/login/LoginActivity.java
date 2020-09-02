package com.etiantian.onlineschoolandroid.modules.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.model.LoginModel;
import com.etiantian.onlineschoolandroid.entrance.BaseActivity;
import com.etiantian.onlineschoolandroid.tools.SharedPreferencesManager;

public class LoginActivity extends BaseActivity implements CompoundButton.OnClickListener {

    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    ///
    /// @description 初始化View
    /// @param 
    /// @return 
    /// @author waitwalker
    /// @time 2020/9/2 2:11 PM
    ///
    private void initView() {
        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);
    }

    ///
    /// @description 监听点击事件
    /// @param 
    /// @return 
    /// @author waitwalker
    /// @time 2020/9/2 2:11 PM
    ///
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                loginAction();
                break;
        }
    }

    private void loginAction() {
        RequestParams map =new RequestParams();
        map.put("username","18600000001");
        map.put("password","a11111");
        NetworkManager.login((RequestParams) map, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.d("1","响应成功");
                LoginModel loginModel = (LoginModel) responseObj;
                SharedPreferencesManager.instance().putString("token", loginModel.getAccess_token());
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","响应失败");
            }
        });
    }

    ///
    /// @description 处理安卓物理返回键
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 2:06 PM
    ///
    @Override
    public void onBackPressed() {
        return;
    }
}