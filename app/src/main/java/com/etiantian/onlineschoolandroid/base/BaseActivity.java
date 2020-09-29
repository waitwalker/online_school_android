package com.etiantian.onlineschoolandroid.base;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.etiantian.onlineschoolandroid.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mContext = this;
    }

    ///
    /// @name showToast
    /// @description 显示Toast
    /// @parameters
    /// @return
    /// @author liuca
    /// @date 2020/8/6
    ///
    public void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    ///
    /// @name showToastSync
    /// @description 子线程处理Toast
    /// @parameters
    /// @return
    /// @author liuca
    /// @date 2020/8/6
    ///
    public void showToastSync(String message) {
        Looper.prepare();
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
        Looper.loop();
    }

    ///
    /// @name navigateTo
    /// @description 跳转到某页
    /// @parameters
    /// @return
    /// @author liuca
    /// @date 2020/8/6
    ///
    public void navigateTo(Class cls) {
        Intent intent = new Intent(mContext, cls);
        startActivity(intent);
    }
    
    ///
    /// @description 隐藏顶部ActionBar
    /// @param 
    /// @return 
    /// @author waitwalker
    /// @time 2020/9/2 4:20 PM
    ///
    public void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    ///
    /// @description 显示顶部ActionBar
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 4:20 PM
    ///
    public void showActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.show();
        }
    }

    ///
    /// @description 隐藏键盘
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/4 1:58 PM
    ///
    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

}