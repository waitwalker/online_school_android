package com.etiantian.lib_network.response_handler;

///
/// @name NormalResponseCallBack
/// @description 处理接口返回回调
/// @author liuca
/// @date 2020/8/13
///
public interface NormalResponseCallBack {

    ///
    /// @name onSuccess
    /// @description 成功回调事件处理
    /// @parameters
    /// @return
    /// @author liuca
    /// @date 2020/8/13
    ///
    void onSuccess(Object responseObj);

    ///
    /// @name onFailure
    /// @description 失败回调事件处理
    /// @parameters
    /// @return
    /// @author liuca
    /// @date 2020/8/13
    ///
    void onFailure(Object responseObj);
}
