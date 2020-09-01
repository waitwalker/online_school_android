package com.etiantian.lib_network.response;

import android.os.Handler;
import android.os.Looper;

import com.etiantian.lib_network.exception.OkHttpException;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.lib_network.response_handler.ResponseHandler;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

///
/// @name CommonResponse
/// @description 处理Json类型响应
/// @author liuca
/// @date 2020/8/13
///
public class CommonResponse implements Callback {

    protected final String Empty_Message = "";

    /// 网络异常
    protected final int Network_Error = -1;
    /// json异常
    protected final int Json_Error = -2;
    /// 未知异常
    protected final int Other_Error = -3;

    /// 处理回调
    private NormalResponseCallBack mResponseCallBack;

    /// json要转换成的类
    private Class<?> mClass;

    /// 线程之间通信处理
    private Handler mDeliverHandler;

    public CommonResponse(ResponseHandler handler) {
        mResponseCallBack = handler.mCallBack;
        mClass = handler.mClass;
        mDeliverHandler = new Handler(Looper.getMainLooper());
    }


    @Override
    public void onFailure(@NotNull Call call, @NotNull final IOException e) {
        mDeliverHandler.post(new Runnable() {
            @Override
            public void run() {
                mResponseCallBack.onFailure(new OkHttpException(Network_Error, e.getLocalizedMessage()));
            }
        });
    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        final ResponseBody responseBody = response.body();
        if (responseBody != null) {
            final String result = responseBody.string();
            mDeliverHandler.post(new Runnable() {
                @Override
                public void run() {
                    handleResponse(result);
                }
            });
        } else {
            mDeliverHandler.post(new Runnable() {
                @Override
                public void run() {
                    mResponseCallBack.onFailure(new OkHttpException(Network_Error, Empty_Message));
                }
            });
        }
    }

    private void handleResponse(Object responseObj) {
        if (responseObj == null || responseObj.toString().trim().length() == 0) {
            mResponseCallBack.onFailure(new OkHttpException(Network_Error, Empty_Message));
            return;
        }

        try {
            JSONObject jsonObject = new JSONObject(responseObj.toString());
            if (mClass == null) {
                mResponseCallBack.onSuccess(jsonObject);
            } else {
                Object object = new Gson().fromJson(responseObj.toString(), mClass);
                if (object != null) {
                    mResponseCallBack.onSuccess(object);
                } else {
                    mResponseCallBack.onFailure(new OkHttpException(Json_Error, Empty_Message));
                }
            }
        } catch (Exception e) {
            mResponseCallBack.onFailure(new OkHttpException(Other_Error, e.getLocalizedMessage()));
            e.printStackTrace();
        }
    }
}
