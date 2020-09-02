package com.etiantian.onlineschoolandroid.entrance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;

import com.etiantian.onlineschoolandroid.R;

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

}