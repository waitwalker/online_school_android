package com.etiantian.onlineschoolandroid.modules.common_tools;

import android.util.Log;

import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.modules.login.UserInfoModel;
import com.etiantian.onlineschoolandroid.singleton.RuntimeDataManager;

///
/// @description 通用工具管理类
/// @author waitwalker
/// @time 2020/10/19 9:33 AM
///
public class CommonToolManager {


    ///
    /// @description 获取用户信息
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/10/19 9:25 AM
    ///
    public static void fetchUserInfo() {
        NetworkManager.userInfoFetch(new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.d("1","获取用户信息成功");
                UserInfoModel userInfoModel = (UserInfoModel)responseObj;
                RuntimeDataManager.instance().setUserInfoModel(userInfoModel);
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","获取用户信息失败");
            }
        });
    }
}
