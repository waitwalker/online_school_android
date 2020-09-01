package com.etiantian.lib_network.response;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.etiantian.lib_network.exception.OkHttpException;
import com.etiantian.lib_network.response_handler.DownloadResponseCallBack;
import com.etiantian.lib_network.response_handler.ResponseHandler;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


///
/// @name CommonFileResponse
/// @description 处理文件响应
/// @author liuca
/// @date 2020/8/13
///
public class CommonFileResponse implements Callback {

    protected final int Network_error = -1;
    protected final int IO_Error = -2;
    protected final String Empty_Message = "";

    private static final int Progress_Message = 0x01;
    private Handler mDeliverHandler;
    private DownloadResponseCallBack mDownloadCallBack;
    private String mFilePath;
    private int mProgress;

    public CommonFileResponse(ResponseHandler handler) {
        this.mDownloadCallBack = (DownloadResponseCallBack) handler.mCallBack;
        this.mFilePath = handler.mSource;
        this.mDeliverHandler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case Progress_Message:
                        mDownloadCallBack.onProgress((int) msg.what);
                        break;
                }
            }
        };
    }

    @Override
    public void onFailure(@NotNull Call call, @NotNull final IOException e) {
        mDeliverHandler.post(new Runnable() {
            @Override
            public void run() {
                mDownloadCallBack.onFailure(new OkHttpException(Network_error, e.getLocalizedMessage()));
            }
        });
    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        final File file = handleResponse(response);
        mDeliverHandler.post(new Runnable() {
            @Override
            public void run() {
                if (file != null) {
                    mDownloadCallBack.onSuccess(file);
                } else {
                    mDownloadCallBack.onFailure(new OkHttpException(IO_Error, Empty_Message));
                }
            }
        });
    }

    private File handleResponse(Response response) {
        if (response == null) {
            return null;
        }

        InputStream inputStream = null;
        File file = null;
        FileOutputStream fos = null;
        // 缓存数组 确定每次写多少
        byte[] buffer = new byte[2048];
        int length;
        int currentLength = 0;
        double sumLength;
        try {
            checkLocalFilePath(mFilePath);
            file = new File(mFilePath);
            fos = new FileOutputStream(file);
            inputStream = response.body().byteStream();
            sumLength = (double) response.body().contentLength();

            // 通过循环先读流
            while ((length = inputStream.read(buffer)) != -1) {
                // 然后写流
                fos.write(buffer, 0, length);
                currentLength += length;
                mProgress = (int) (currentLength / sumLength * 100);
                mDeliverHandler.obtainMessage(mProgress, mProgress).sendToTarget();
            }
            fos.flush();
        } catch (Exception e) {
            file = null;
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (inputStream != null) {

                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    private void checkLocalFilePath(String localFilePath) {
        File path = new File(localFilePath.substring(0,
                localFilePath.lastIndexOf("/") + 1));
        File file = new File(localFilePath);
        if (!path.exists()) {
            path.mkdirs();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
