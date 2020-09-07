package com.etiantian.lib_network.request;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.File;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

public class CommonRequest {

    ///
    /// @name createPostRequest
    /// @description 构建不带请求头的post 请求对象
    /// @author liuca
    /// @date 2020/8/13
    ///
    public static Request createPostRequest(String url, RequestParams params) {
        return createPostRequest(url, params, null);
    }

    ///
    /// @name createPostRequest
    /// @description 构建post 请求对象
    /// @author liuca
    /// @date 2020/8/13
    ///
    public static Request createPostRequest(String url, RequestParams params, RequestParams headers) {
        // 构建请求体 构建者模式
        FormBody.Builder mFormBodyBuilder = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry: params.urlParams.entrySet()) {
                // 参数遍历
                mFormBodyBuilder.add(entry.getKey(),entry.getValue());
            }
        }

        Log.d("1","post请求完整参数:" + url);

        // 构建请求头
        Headers.Builder mHeadersBuilder = new Headers.Builder();
        if (headers != null) {
            for (Map.Entry<String,String> entry: headers.urlParams.entrySet()) {
                //请求头遍历
                mHeadersBuilder.add(entry.getKey(),entry.getValue());
            }
        }

        Log.d("1","post请求完整请求头:" + mHeadersBuilder.build().toString());

        // 构建Request对象 构建者模式,将请求url,请求头,请全体传进去
        Request request = new Request.Builder()
                .url(url)
                .headers(mHeadersBuilder.build())
                .post(mFormBodyBuilder.build())
                .build();
        return request;
    }

    ///
    /// @name createPostRequest
    /// @description 构建post 请求对象
    /// @author liuca
    /// @date 2020/8/13
    ///
    public static Request createPostRequestWithJsonParameter(String url, RequestParams params, RequestParams headers) {
        String json = new Gson().toJson(params.urlParams);
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(json, mediaType);

        Log.d("1","post请求完整参数:" + url);

        // 构建请求头
        Headers.Builder mHeadersBuilder = new Headers.Builder();
        if (headers != null) {
            for (Map.Entry<String,String> entry: headers.urlParams.entrySet()) {
                //请求头遍历
                mHeadersBuilder.add(entry.getKey(),entry.getValue());
            }
        }

        Log.d("1","post请求完整请求头:" + mHeadersBuilder.build().toString());

        // 构建Request对象 构建者模式,将请求url,请求头,请全体传进去
        Request request = new Request.Builder()
                .url(url)
                .headers(mHeadersBuilder.build())
                .post(body)
                .build();
        return request;
    }

    ///
    /// @name 构建无请求头的Request对象
    /// @description
    /// @author liuca
    /// @date 2020/8/13
    ///
    public static Request createGetRequest(String url, RequestParams params) {
        return createGetRequest(url, params,null);
    }

    ///
    /// @name createGetRequest
    /// @description 构建有请求头的Request对象
    /// @author liuca
    /// @date 2020/8/13
    ///
    public static Request createGetRequest(String url, RequestParams params, RequestParams headers) {

        StringBuilder urlBuilder;
        if (params != null) {
            urlBuilder = new StringBuilder(url).append("?");

            // 构建请求参数
            for (Map.Entry<String,String> entry:params.urlParams.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue());
            }

            Log.d("1","get请求完整链接:" + urlBuilder.toString());
        } else {
            urlBuilder = new StringBuilder(url);
        }

        // 构建请求头
        Headers.Builder mHeadersBuilder = new Headers.Builder();
        if (headers != null) {
            for (Map.Entry<String,String> entry: headers.urlParams.entrySet()) {
                //请求头遍历
                mHeadersBuilder.add(entry.getKey(),entry.getValue());
            }
        }

        Log.d("1", "get请求完整请求头:" + mHeadersBuilder.build().toString());

        Request request = new Request.Builder()
                .url(urlBuilder.toString())
                .headers(mHeadersBuilder.build())
                .get()
                .build();
        return request;
    }

    ///
    /// @name createMultiPostRequest
    /// @description 文件上传请求
    /// @author liuca
    /// @date 2020/8/13
    ///
    public static final MediaType File_TYPE = MediaType.parse("application/octet-stream");
    public static Request createMultiPostRequest(String url, RequestParams params, RequestParams headers) {
        MultipartBody.Builder requestBody = new MultipartBody.Builder();
        // form 表单
        requestBody.setType(MultipartBody.FORM);
        if (params != null) {
            for (Map.Entry<String, Object>entry:params.fileParams.entrySet()) {
                if (entry.getValue() instanceof File) {
                    requestBody.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""),
                            RequestBody.create(File_TYPE,(File) entry.getValue()));
                } else if (entry.getValue() instanceof String) {
                    requestBody.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""),
                            RequestBody.create(null, (String) entry.getValue()));
                }
            }
        }

        return new Request.Builder().url(url).post(requestBody.build()).build();
    }
}
