package com.etiantian.onlineschoolandroid.singleton;

///
/// @description APP 运行时数据管理
/// @author waitwalker
/// @time 2020/9/4 3:14 PM
///
public class RuntimeDataManager {
    private volatile static RuntimeDataManager instance = null;

    //采用单利模式
    public static RuntimeDataManager instance() {
        if (instance == null) {
            synchronized (RuntimeDataManager.class) {
                if (instance == null) {
                    instance = new RuntimeDataManager();
                }
            }
        }
        return instance;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /// token
    private String token;
}
