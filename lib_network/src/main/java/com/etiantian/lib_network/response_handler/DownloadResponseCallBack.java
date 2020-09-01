package com.etiantian.lib_network.response_handler;

///
/// @name DownloadResponseCallBack
/// @description 处理进度
/// @author liuca
/// @date 2020/8/13
///
public interface DownloadResponseCallBack extends NormalResponseCallBack {
    void onProgress(int progress);
}
