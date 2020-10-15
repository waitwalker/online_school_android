package com.etiantian.onlineschoolandroid.api;

import android.net.Uri;

import com.etiantian.lib_network.client.CommonOkHttpClient;
import com.etiantian.lib_network.request.CommonRequest;
import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.lib_network.response_handler.ResponseHandler;
import com.etiantian.onlineschoolandroid.app.App;
import com.etiantian.onlineschoolandroid.model.ActivityCourseAlertModel;
import com.etiantian.onlineschoolandroid.model.CodeModel;
import com.etiantian.onlineschoolandroid.model.LoginModel;
import com.etiantian.onlineschoolandroid.model.RegisterModel;
import com.etiantian.onlineschoolandroid.modules.common_tools.VideoURLModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.MyCourseSubjectModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.ai_test.AITestModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.LiveListModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.current_period.MaterialPackageModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.recommend.RecommendModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.subject_detail.MaterialModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.change_material.MaterialVersionListModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.subject_detail.ResourceInfoModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.subject_detail.SubjectDetailModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.KnowledgeGuideModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.MicroCourseModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.WisdomModel;
import com.etiantian.onlineschoolandroid.singleton.RuntimeDataManager;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


///
/// @description 网络请求管理类 负责网络请求控制,接口管理等
/// @author waitwalker
/// @time 2020/9/2 9:04 AM
///
public class NetworkManager {
    public static class HttpConstants {

        private static final String AppId = !App.DEBUG()? "071DC04BB4053F236AD7DF478A8E4A17" : "C2ABCA7EBE1A93D1F0A1C3D9E8D6B79E";
        private static final String AppSecret = !App.DEBUG()? "BA451F0E9F31B3A270C08F3BB38E33BE" : "2765F72C83B05066CB7B65F3650E3440";

        private static final String Base_URL = !App.DEBUG() ? "http://gw5.bj.etiantian.net:42393/" : "https://school.etiantian.com/";

        // 登录
        public static String Login_URL = Base_URL + "authentication-center/authentication/login?";

        // 活动课
        public static String Activity_URL = Base_URL + "api-study-service/api/activity/prompt";

        // 获取验证码
        public static String Code_URL = Base_URL + "api-cloudaccount-service/api/user/sms";

        // 注册
        public static String Register_URL = Base_URL + "api-cloudaccount-service/api/user/register";

        /// 我的课程卡片接口
        public static String MyCourse_Subject_URL = Base_URL +"api-study-service/api/course/v2.3/courses";

        /// 我的课程推荐学习接口
        public static String MyCourse_Recommend_URL = Base_URL +"api-study-service/api/course/home/recommend";

        /// 获取教材版本
        public static String Material_version_URL = Base_URL + "api-service-general-wx/materials/grade/subject?";

        /// 获取教材版本列表
        public static String Material_version_List_URL = Base_URL + "api-service-general-wx/materials/version/material?";

        /// 获取智慧学习列表
        public static String Wisdom_List_URL = Base_URL + "api-service-course-wx/wx-chapter/node/points?";

        /// 获取AI测试列表
        public static String AI_Test_List_URL = Base_URL + "api-service-general-wx/student-class/chapters?";

        /// 直播列表
        public static String Live_List_URL = Base_URL + "api-study-service/api/lives/plans";


        /// 活动课链接
        /// 联通活动课
        public static String Union_Activity_URL = "https://huodong.etiantian.com/liantong/indexm.html?token=" + getToken();

        /// 测验AB试卷
        public static String Test_AB_URL = "https://item.etiantian.com/nwx-app/ab.html?token=" + getToken();

        /// AI测试
        public static String AI_Test_Html_URL = "https://item.etiantian.com/nwx-app/ai.html?token=" + getToken();

        /// 小升初活动课--语文
        public static String Primary_Activity_Chinese_URL = "https://huodong.etiantian.com/activity01/mobile10.html?token=" + getToken();
        /// 小升初活动课--数学
        public static String Primary_Activity_Math_URL = "https://huodong.etiantian.com/activity01/mobile11.html?token=" + getToken();
        /// 小升初活动课--英语
        public static String Primary_Activity_English_URL = "https://huodong.etiantian.com/activity01/mobile12.html?token=" + getToken();

        /// 四中名师
        public static String New_Semester_Activity = "https://huodong.etiantian.com/activity01/mobile12.html?token=" + getToken();

        /// cc回放地址
        public static String CC_PlayBack_HTML = Base_URL + "cc-web/back.html?";

        /// cc直播地址
        public static String CC_Live_HTML = Base_URL + "cc-web/mobile2.html?";

        /// 大师直播中作业h5地址
        public static String Homework_HTML = "https://item.etiantian.com/nwx-app/" + "homework.html?";

        /// 获取视频URL
        public static String Video_URL = Base_URL + "api-study-service/api/lives/download";

        /// 资料包
        public static String Material_Package_URL = Base_URL + "api-study-service/api/course/coursewares/list";

        /// 学科详情页
        public static String Subject_Detail_URL = Base_URL + "api-study-service/api/course/v2.1/courses/grade/subject?";

        /// 微课视频数据
        public static String Micro_Course_URL = Base_URL + "api-resource-service/api/resources/wk/";

        /// 资源信息数据
        public static String Resource_Info_URL = Base_URL + "api-resource-service/api/resources/";

        /// 知识导学类别
        public static String Knowledge_Guide_URL = Base_URL + "api-service-course-wx/wx-chapter/resource?";

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
    /// @description post 请求通用方法
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 9:03 AM
    ///
    public static void postRequestWithJsonParameter(String url, RequestParams params, RequestParams headers, NormalResponseCallBack callBack, Class<?> clazz) {
        CommonOkHttpClient.post(CommonRequest.createPostRequestWithJsonParameter(url, params, headers), new ResponseHandler(callBack, clazz));
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
        String url =  HttpConstants.Code_URL;
        RequestParams headers = getBasicHeaders();
        headers.put("content-type","application/json");
        postRequestWithJsonParameter(url, params, headers, callBack, CodeModel.class);
    }

    ///
    /// @description 注册请求
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/7 1:29 PM
    ///
    public static void registerFetch(RequestParams params, NormalResponseCallBack callBack) {
        String url =  HttpConstants.Register_URL;
        RequestParams headers = getBasicHeaders();
        headers.put("content-type","application/json");
        postRequestWithJsonParameter(url, params, headers, callBack, RegisterModel.class);
    }

    ///
    /// @description 我的课程学科列表
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 11:27 AM
    ///
    public static void myCourseSubjectFetch(NormalResponseCallBack callBack) {
        getRequest(HttpConstants.MyCourse_Subject_URL,null, getBearerHeaders(), callBack, MyCourseSubjectModel.class);
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

    ///
    /// @description 推荐学习接口
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/7 10:02 AM
    ///
    public static void recommendFetch(NormalResponseCallBack callBack) {
        String url =  HttpConstants.MyCourse_Recommend_URL;
        getRequest(url,null, getBearerHeaders(), callBack, RecommendModel.class);
    }

    ///
    /// @description 获取教材版本
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/17 9:28 AM
    ///
    public static void materialVersionFetch(RequestParams params, NormalResponseCallBack callBack) {
        String url =  HttpConstants.Material_version_URL + mapToQuery(params);
        getRequest(url,null, getBearerHeaders(), callBack, MaterialModel.class);
    }

    ///
    /// @description 获取教材版本列表
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/17 9:28 AM
    ///
    public static void materialVersionListFetch(RequestParams params, NormalResponseCallBack callBack) {
        String url =  HttpConstants.Material_version_List_URL + mapToQuery(params);
        getRequest(url,null, getBearerHeaders(), callBack, MaterialVersionListModel.class);
    }

    ///
    /// @description 获取智慧学习列表
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/17 9:28 AM
    ///
    public static void wisdomListFetch(RequestParams params, NormalResponseCallBack callBack) {
        String url =  HttpConstants.Wisdom_List_URL + mapToQuery(params);
        getRequest(url,null, getBearerHeaders(), callBack, WisdomModel.class);
    }

    ///
    /// @description 获取AI测试列表
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/17 9:28 AM
    ///
    public static void aiTestListFetch(RequestParams params, NormalResponseCallBack callBack) {
        String url =  HttpConstants.AI_Test_List_URL + mapToQuery(params);
        getRequest(url,null, getBearerHeaders(), callBack, AITestModel.class);
    }

    ///
    /// @description 获取大师直播列表
    /// @param 
    /// @return 
    /// @author waitwalker
    /// @time 2020/9/24 2:28 PM
    ///
    public static void liveListFetch(RequestParams params, NormalResponseCallBack callBack) {
        String url =  HttpConstants.Live_List_URL;
        RequestParams headers = getBearerHeaders();
        headers.put("content-type","application/json");
        postRequestWithJsonParameter(url, params, headers, callBack, LiveListModel.class);
    }

    ///
    /// @description 获取视频播放URL
    /// @param 
    /// @return 
    /// @author waitwalker
    /// @time 2020/9/25 9:58 AM
    ///
    public static void videoURLFetch(RequestParams params, NormalResponseCallBack callBack) {
        String url = HttpConstants.Video_URL;
        getRequest(url, params, getBearerHeaders(), callBack, VideoURLModel.class);
    }

    ///
    /// @description 获取资料包
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/28 2:56 PM
    ///
    public static void materialPackageFetch(RequestParams params, NormalResponseCallBack callBack) {
        getRequest(HttpConstants.Material_Package_URL, params, getBearerHeaders(), callBack, MaterialPackageModel.class);
    }

    ///
    /// @description 获取知识导学
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/28 2:56 PM
    ///
    public static void knowledgeGuideFetch(RequestParams params, NormalResponseCallBack callBack) {
        getRequest(HttpConstants.Knowledge_Guide_URL + mapToQuery(params), null, getBearerHeaders(), callBack, KnowledgeGuideModel.class);
    }

    ///
    /// @description 学科详情获取
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/17 9:28 AM
    ///
    public static void subjectDetailFetch(RequestParams params, NormalResponseCallBack callBack) {
        String url =  HttpConstants.Subject_Detail_URL + mapToQuery(params);
        getRequest(url,null, getBearerHeaders(), callBack, SubjectDetailModel.class);
    }

    ///
    /// @description 微课视频数据获取
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/17 9:28 AM
    ///
    public static void microCourseFetch(RequestParams params, NormalResponseCallBack callBack) {
        String url =  HttpConstants.Micro_Course_URL + params.urlParams.get("resourceId");
        getRequest(url,null, getBearerHeaders(), callBack, MicroCourseModel.class);
    }

    ///
    /// @description 资源信息获取
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/17 9:28 AM
    ///
    public static void resourceInfoFetch(RequestParams params, NormalResponseCallBack callBack) {
        String url =  HttpConstants.Resource_Info_URL + params.urlParams.get("resourceId");
        getRequest(url,null, getBearerHeaders(), callBack, ResourceInfoModel.class);
    }


    /////////========== 请求参数 请求头处理封装 =========/////////
    ///
    /// @description 获取token
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 11:42 AM
    ///
    public static String getToken() {
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

