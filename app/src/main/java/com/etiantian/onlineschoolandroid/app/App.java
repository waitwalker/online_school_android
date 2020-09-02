package com.etiantian.onlineschoolandroid.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.etiantian.onlineschoolandroid.tools.PackageInfoManager;

public class App extends Application {
    @SuppressLint("StaticFieldLeak")
    static private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
    
    ///
    /// @description 是否debug 模式
    /// @param 
    /// @return 
    /// @author waitwalker
    /// @time 2020/9/2 4:54 PM
    ///
    public static boolean DEBUG() {
        return PackageInfoManager.isDebug(mContext);
    }
}
