package com.etiantian.lib_network.response_handler;

///
/// @name ResponseHandler
/// @description 回调处理包装类
/// @author liuca
/// @date 2020/8/13
///
public class ResponseHandler {
    public NormalResponseCallBack mCallBack = null;
    public Class<?> mClass = null;
    public  String mSource = null; //文件保存路径
    public ResponseHandler(NormalResponseCallBack callBack){
        this.mCallBack = callBack;
    }

    public ResponseHandler(NormalResponseCallBack callBack, Class<?> clazz) {
        this.mCallBack = callBack;
        this.mClass = clazz;
    }

    public ResponseHandler(NormalResponseCallBack callBack, String source) {
        this.mCallBack = callBack;
        this.mSource = source;
    }
}
