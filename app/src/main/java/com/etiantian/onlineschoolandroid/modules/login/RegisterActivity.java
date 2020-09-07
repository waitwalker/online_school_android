package com.etiantian.onlineschoolandroid.modules.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.entrance.BaseActivity;
import com.etiantian.onlineschoolandroid.entrance.TabBarNavigationActivity;
import com.etiantian.onlineschoolandroid.model.LoginModel;
import com.etiantian.onlineschoolandroid.singleton.RuntimeDataManager;
import com.etiantian.onlineschoolandroid.tools.SharedPreferencesManager;
import com.kaopiz.kprogresshud.KProgressHUD;

public class RegisterActivity extends BaseActivity implements CompoundButton.OnClickListener {

    /// 登录整体背景
    ViewGroup backgroundView;

    /// 用户登录
    private TextView textView;
    /// 用户名输入框
    private EditText account_input;
    /// 删除用户名
    private ImageView account_delete;

    /// 验证码输入框
    private EditText code_input;
    /// 验证码按钮
    private Button code_button;
    /// 验证码倒计时
    private CodeCountDownTimer codeCountDownTimer;

    /// 密码输入框
    private EditText password_input;
    /// 显示与隐藏密码
    private ImageView password_visible_imageView;
    /// 密码是否可见
    private boolean password_visible_ = false;

    /// 选择地区
    private EditText area_input;
    private ImageView area_dropdown;

    /// 注册按钮
    private Button register_button;
    /// 用户协议选中
    private CheckBox checkBox;
    /// 用户协议按钮
    private Button user_privacy_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        initView();
        initData();
    }

    ///
    /// @description 初始化View
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 2:11 PM
    ///
    private void initView() {

        /// 背景
        backgroundView = findViewById(R.id.register_background);
        backgroundView.setOnClickListener(this);
        textView = findViewById(R.id.textView);

        /// 账号相关
        account_input = findViewById(R.id.register_account_input);
        account_delete = findViewById(R.id.register_account_delete);
        account_delete.setOnClickListener(this);

        /// 验证码相关
        code_input = findViewById(R.id.register_code_input);
        code_button = findViewById(R.id.register_code_visible);
        code_button.setOnClickListener(this);
        codeCountDownTimer = new CodeCountDownTimer(60000, 1000);

        /// 密码相关
        password_input = findViewById(R.id.register_password_input);
        password_visible_imageView = findViewById(R.id.register_password_visible);
        password_visible_imageView.setOnClickListener(this);

        /// 选择地区相关
        area_input = findViewById(R.id.register_area_input);
        area_input.setClickable(true);
        area_input.setFocusable(false);
        area_input.setFocusableInTouchMode(false);
        area_input.setLongClickable(false);
        area_input.setOnClickListener(this);

        area_dropdown = findViewById(R.id.register_area_drop);
        area_dropdown.setOnClickListener(this);

        /// 注册按钮
        register_button = findViewById(R.id.register_button);
        register_button.setOnClickListener(this);

        /// 单选框按钮
        checkBox = findViewById(R.id.check_button);

        /// 用户协议
        user_privacy_button = findViewById(R.id.user_privacy_button);
        user_privacy_button.setOnClickListener(this);

        /// 监听用户名文本框变化
        account_input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                Log.d("1","输入完成点击确认,调用此方法");
                return false;
            }
        });
        account_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("1","文本输入之前");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("1","文本输入发生变化");
                if (account_input.getText().toString().length() > 0) {
                    account_delete.setVisibility(View.VISIBLE);
                } else {
                    account_delete.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("1","文本输入之后");
            }
        });

        /// 监听密码文本框变化
        password_input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                Log.d("1","输入完成点击确认,调用此方法");
                return false;
            }
        });
        password_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("1","文本输入之前");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("1","文本输入发生变化");
                if (password_input.getText().toString().length() > 0) {
                    password_visible_imageView.setVisibility(View.VISIBLE);
                } else {
                    password_visible_imageView.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("1","文本输入之后");
            }
        });
    }

    ///
    /// @description 初始化数据
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/7 9:34 AM
    ///
    private void initData() {


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
            case R.id.register_background:
                hideKeyboard();
                break;
            case R.id.register_account_delete:
                account_input.setText("");
                break;
            case R.id.register_password_visible:
                password_visible_ = !password_visible_;
                if (password_visible_) {
                    password_input.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    password_input.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                password_input.setSelection(password_input.getText().length());
                password_visible_imageView.setSelected(password_visible_);
                break;
            case R.id.register_button:
                loginAction();
                break;
            case R.id.check_button:
                break;
            case R.id.user_privacy_button:
                navigateTo(UserPrivacyActivity.class);
                break;
            case R.id.register_area_input:
                showToast("地区输入框点击了");
                break;
            case R.id.register_area_drop:
                showToast("地区输入框点击了");
                break;
            case R.id.register_code_visible:
                codeCountDownTimer.start();
                break;
        }
    }

    /// 登录按钮点击事件
    private void loginAction() {

        if (account_input.getText().length() == 0 || password_input.getText().length() == 0) {
            showToast("请输入完整账号密码后,登录!");
            return;
        }

        final KProgressHUD hud = KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("登录中...")
                .show();

        RequestParams map =new RequestParams();
        map.put("username",account_input.getText().toString());
        map.put("password",password_input.getText().toString());
        NetworkManager.login((RequestParams) map, new NormalResponseCallBack() {

            @Override
            public void onSuccess(Object responseObj) {
                hud.dismiss();
                Log.d("1","响应成功");
                LoginModel loginModel = (LoginModel) responseObj;

                // 缓存数据
                SharedPreferencesManager.instance().putString("token", loginModel.getAccess_token());
                SharedPreferencesManager.instance().putLong("expiration", loginModel.getExpiration());

                SharedPreferencesManager.instance().putString("account", account_input.getText().toString());
                SharedPreferencesManager.instance().putString("password", password_input.getText().toString());

                RuntimeDataManager.instance().setToken(loginModel.getAccess_token());

                // 跳转到首页
                navigateTo(TabBarNavigationActivity.class);
            }

            @Override
            public void onFailure(Object responseObj) {
                hud.dismiss();
                Log.d("1","响应失败");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
        super.onBackPressed();
    }

    ///
    /// @description 验证码倒计时类
    /// @author waitwalker
    /// @time 2020/9/7 9:37 AM
    ///
    private class CodeCountDownTimer extends CountDownTimer {

        public CodeCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            code_button.setClickable(false);
            code_button.setText("重新获取" + l/1000 + "秒");
        }

        @Override
        public void onFinish() {
            code_button.setText("获取验证码");
            code_button.setClickable(true);
        }
    }
}