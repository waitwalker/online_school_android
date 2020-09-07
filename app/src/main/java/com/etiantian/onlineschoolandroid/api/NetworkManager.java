package com.etiantian.onlineschoolandroid.api;

import android.net.Uri;

import com.etiantian.lib_network.client.CommonOkHttpClient;
import com.etiantian.lib_network.request.CommonRequest;
import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.lib_network.response_handler.ResponseHandler;
import com.etiantian.onlineschoolandroid.app.App;
import com.etiantian.onlineschoolandroid.constant.Const;
import com.etiantian.onlineschoolandroid.event.TokenEvent;
import com.etiantian.onlineschoolandroid.model.ActivityCourseAlertModel;
import com.etiantian.onlineschoolandroid.model.CodeModel;
import com.etiantian.onlineschoolandroid.model.LoginModel;
import com.etiantian.onlineschoolandroid.singleton.RuntimeDataManager;
import com.etiantian.onlineschoolandroid.tools.SharedPreferencesManager;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


///
/// @description 网络请求管理类 负责网络请求控制,接口管理等
/// @author waitwalker
/// @time 2020/9/2 9:04 AM
///
public class NetworkManager {
    static class HttpConstants {

        private static final String AppId = App.DEBUG()? "071DC04BB4053F236AD7DF478A8E4A17" : "C2ABCA7EBE1A93D1F0A1C3D9E8D6B79E";
        private static final String AppSecret = App.DEBUG()? "BA451F0E9F31B3A270C08F3BB38E33BE" : "2765F72C83B05066CB7B65F3650E3440";

        private static final String Base_URL = App.DEBUG() ? "http://gw5.bj.etiantian.net:42393/" : "https://school.etiantian.com/";

        // 登录
        public static String Login_URL = Base_URL + "authentication-center/authentication/login?";

        // 活动课
        public static String Activity_URL = Base_URL + "api-study-service/api/activity/prompt";

        // 获取验证码
        public static String Code_URL = Base_URL + "api-cloudaccount-service/api/user/sms";
    }

    ///
    /// @description get 请求通用方法
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 9:03 AM
    ///
    public static void getRequest(String url, RequestParams params, RequestParams headers, NormalResponseCallBack callBack, Class<?> clazz) {
        CommonOkHttpClient.get(CommonRequest.createGetRequest(url, params, headers), new ResponseHandler(callBack, clazz));
    }

    ///
    /// @description post 请求通用方法
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 9:03 AM
    ///
    public static void postRequest(String url, RequestParams params, RequestParams headers, NormalResponseCallBack callBack, Class<?> clazz) {
        CommonOkHttpClient.post(CommonRequest.createPostRequest(url, params, headers), new ResponseHandler(callBack, clazz));
    }

    ///
    /// @description 拼接请求参数
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 9:03 AM
    ///
    public static String mapToQuery(RequestParams map) {
        final List<String> pairs = new ArrayList<String>();
        Map<String,String> hashMap =  map.urlParams;
        for (Map.Entry<String, String> entry: hashMap.entrySet()) {
           String encodedKey = Uri.encode(entry.getKey());
           String encodedValue = Uri.encode(entry.getValue());
           String keyValue = encodedKey + "=" + encodedValue;
           pairs.add(keyValue);
        }
        String joinedStr = String.join("&", pairs);
        return joinedStr;
    }

    ///
    /// @description 登录请求
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 11:27 AM
    ///
    public static void loginFetch(RequestParams params, NormalResponseCallBack callBack) {
        String url =  HttpConstants.Login_URL + mapToQuery(params);
        postRequest(url,null, getBasicHeaders(), callBack, LoginModel.class);
    }

    ///
    /// @description 获取验证码请求: 登录101, 注册102, 忘记密码103, 绑定手机号104
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/7 10:15 AM
    ///
    public static void codeFetch(RequestParams params, NormalResponseCallBack callBack) {
        String url =  HttpConstants.Code_URL + mapToQuery(params);
        postRequest(url, params, getBasicHeaders(), callBack, CodeModel.class);
    }

    ///
    /// @description 获取活动课弹框数据
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/7 10:02 AM
    ///
    public static void activityCourseAlertFetch(NormalResponseCallBack callBack) {
        String url =  HttpConstants.Activity_URL;
        getRequest(url,null, getBearerHeaders(), callBack, ActivityCourseAlertModel.class);
    }


    /////////========== 请求参数 请求头处理封装 =========/////////
    ///
    /// @description 获取token
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 11:42 AM
    ///
    private static String getToken() {
        String token = RuntimeDataManager.instance().getToken();
        if (token == null || token.length() == 0) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("errorCode", -1);
            map.put("message", "token为空");
            EventBus.getDefault().post(map);
            return null;
        }
        return token;
    }

    ///
    /// @description 情况token
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/7 10:03 AM
    ///
    private static void clearBearerToken() {
        RuntimeDataManager.instance().clearToken();
    }

    ///
    /// @description 拼接Bearer类型请求头
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/7 10:11 AM
    ///
    private static RequestParams getBearerHeaders() {
        RequestParams headers = new RequestParams();
        String token = getToken();
        if (token == null) {
            headers.put("Authorization", "");
        }
        headers.put("Authorization", "Bearer " + token);
        return headers;
    }

    ///
    /// @description 拼接Basic类型请求头
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/7 10:12 AM
    ///
    private static RequestParams getBasicHeaders() {
        RequestParams headers = new RequestParams();
        String basic = HttpConstants.AppId + ":" + HttpConstants.AppSecret;
        String base64 = Base64.getEncoder().encodeToString(basic.getBytes());
        headers.put("Authorization", "Basic " + base64);
        return headers;
    }
}

