package com.etiantian.lib_network.client;

import com.etiantian.lib_network.response.CommonFileResponse;
import com.etiantian.lib_network.response.CommonResponse;
import com.etiantian.lib_network.response_handler.ResponseHandler;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

///
/// @description okHttp客户端封装
/// @author waitwalker
/// @time 2020/9/1 1:59 PM
///
public class CommonOkHttpClient {
    private static final int TIME_OUT = 30;
    private static OkHttpClient mOkHttpClient;

    static {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.hostnameVerifier(new HostnameVerifier() {
            // 验证域名
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

        // 添加拦截器
        okHttpClientBuilder.addInterceptor(new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Chain chain) throws IOException {
                // 为所有请求添加请求头
                Request request = chain.request().newBuilder().addHeader("User-Agent", "OnlineSchoolApp").build();
                return chain.proceed(request);
            };
        });

        /// 设置超时时间
        okHttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        /// 允许重定向
        okHttpClientBuilder.followRedirects(true);

        mOkHttpClient = okHttpClientBuilder.build();
    }

    ///
    /// @name get
    /// @description get请求
    /// @author liuca
    /// @date 2020/8/13
    ///
    public static Call get(Request request, ResponseHandler handler) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonResponse(handler));
        return call;
    }

    ///
    /// @name post
    /// @description post请求
    /// @author liuca
    /// @date 2020/8/13
    ///
    public static Call post(Request request, ResponseHandler handler) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonResponse(handler));
        return call;
    }

    ///
    /// @name downloadFile
    /// @description 文件下载请求
    /// @author liuca
    /// @date 2020/8/13
    ///
    public static Call downloadFile(Request request, ResponseHandler handler) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonFileResponse(handler));
        return call;
    }
}
