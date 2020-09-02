package com.etiantian.onlineschoolandroid.tools;

import android.content.SharedPreferences;

import com.etiantian.onlineschoolandroid.app.App;

public class SharedPreferencesManager {
    private static final String FILENAME = "_filename_shared_";

    private volatile static SharedPreferencesManager instance = null;

    //采用单利模式
    public static SharedPreferencesManager instance() {
        if (instance == null) {
            synchronized (SharedPreferencesManager.class) {
                if (instance == null) {
                    instance = new SharedPreferencesManager();
                    instance.init();
                }
            }
        }
        return instance;
    }

    private SharedPreferences sharedPreferences = null;

    // 初始化 App.getContext():全局Context也就是Application
    private void init() {
        sharedPreferences = App.getContext().getSharedPreferences(FILENAME, 0);
    }

    ///
    /// @description 存储字符串
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 11:01 AM
    ///
    public void putString(String key, String value) {
        sharedPreferences.edit().putString(key,value).apply();
    }

    ///
    /// @description 存储数值
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 11:01 AM
    ///
    public void putInt(String key, int value) {
        sharedPreferences.edit().putInt(key,value).apply();
    }

    ///
    /// @description 存储长数值
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 11:01 AM
    ///
    public void putLong(String key, int value) {
        sharedPreferences.edit().putLong(key,value).apply();
    }

    ///
    /// @description 获取字符串
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 11:02 AM
    ///
    public String getString(String key) {
        return sharedPreferences.getString(key,"");
    }

    ///
    /// @description 获取数值
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 11:02 AM
    ///
    public int getInt(String key) {
        return sharedPreferences.getInt(key,666666);
    }

    ///
    /// @description 获取长数值
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 11:02 AM
    ///
    public long getLong(String key) {
        return sharedPreferences.getLong(key,666666);
    }

    ///
    /// @description 移除存储
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 12:00 PM
    ///
    public void remove(String key) {
        sharedPreferences.edit().remove(key).apply();
    }
}
