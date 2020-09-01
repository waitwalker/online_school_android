package com.etiantian.lib_network.exception;

///
/// @name OkHttpException
/// @description okhttp 异常封装类
/// @author liuca
/// @date 2020/8/13
///
public class OkHttpException extends Exception {
    private static final long serialVersionUID = 1L;
    /// 错误码
    private int errorCode;

    /// 错误信息
    private Object errorMessage;

    public OkHttpException(int errorCode, Object errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }
}

