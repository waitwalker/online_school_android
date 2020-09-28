package com.etiantian.onlineschoolandroid.modules.common_tools;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

///
/// @description 权限请求
/// @author waitwalker
/// @time 2020/9/28 1:54 PM
///
public class PermissionUtils {
    private Context context;
    private HavePermission listener;

    /**
     * 拍照系列权限
     */
    private static final String[] permissionsCamera = {
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    /**
     * 读写权限
     */
    private static final String[] permissionsStorage = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    /**
     * 拨打电话权限
     */
    private static final String[] permissionsCallPhone = {
            Manifest.permission.CALL_PHONE
    };

    public PermissionUtils(Context context, HavePermission listener) {
        this.context = context;
        this.listener = listener;
    }

    /**
     * @param
     * @time
     * @description 请求拍照等相关，权限，拍照，读写文件操作
     */
    public void requestPerssionCamera(int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 检查该权限是否已经获取
            //拍照权限
            int camera = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA);
            //写入文件
            int write = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            //读文件
            int read = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (camera != PackageManager.PERMISSION_GRANTED || write != PackageManager.PERMISSION_GRANTED || read != PackageManager.PERMISSION_GRANTED) {
                // 如果没有授予该权限，就去提示用户请求
                showDialogTipUserRequestPermissionCamera();
            } else {//获取权限之后 要进行的操作
                listener.havePermission(resId);//有权限之后的操作

            }
        }
    }

    /**
     * @param
     * @time
     * @description 请求读写文件操作权限
     */
    public void requestPerssionStorage(int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 检查该权限是否已经获取
            int write = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);//写入文件
            int read = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);//读文件
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (write != PackageManager.PERMISSION_GRANTED || read != PackageManager.PERMISSION_GRANTED) {
                // 如果没有授予该权限，就去提示用户请求
                showDialogTipUserRequestPermissionStorage();
            } else {//获取权限之后 要进行的操作
                listener.havePermission(resId);//有权限之后的操作

            }
        }
    }

    /**
     *@time
     *@param
     *@description 请求拍照等相关，权限，拍照，读写文件操作
     */
    public void requestPerssionCallPhone( int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 检查该权限是否已经获取
            int i = ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE);//拨打电话的权限
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (i != PackageManager.PERMISSION_GRANTED) {
                // 如果没有授予该权限，就去提示用户请求
                showDialogTipUserRequestPermissionCallPhone();
            } else {//获取权限之后 要进行的操作

                listener.havePermission(resId);//有权限之后的操作

            }
        }
    }

    // 提示用户该请求权限的弹出框
    private void showDialogTipUserRequestPermissionCamera() {
        new AlertDialog.Builder(context)
                .setTitle("相机权限、读写权限")
                .setMessage("由于需要摄像，需要开启相机权限\n" +
                        "存储文件，需要开启读写权限\n" +
                        "否则无法正常使用")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startRequestPermissionCamera();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"请允许权限开启",Toast.LENGTH_SHORT).show();
                    }
                }).setCancelable(false).show();
    }

    // 提示用户该请求权限的弹出框
    private void showDialogTipUserRequestPermissionStorage() {
        new AlertDialog.Builder(context)
                .setTitle("读写权限")
                .setMessage("由于需要保存到相册" +
                        "存储文件，需要开启读写权限\n" +
                        "否则无法正常使用")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startRequestPermissionStorage();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"请允许权限开启",Toast.LENGTH_SHORT).show();
                    }
                }).setCancelable(false).show();
    }

    // 提示用户该请求权限的弹出框
    private void showDialogTipUserRequestPermissionCallPhone() {
        new AlertDialog.Builder(context)
                .setTitle("拨打电话权限")
                .setMessage("由于需要拨打电话，需要开启拨打电话权限\n" + "否则无法正常使用")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startRequestPermissionCallPhone();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"请允许权限开启",Toast.LENGTH_SHORT).show();

                    }
                }).setCancelable(false).show();
    }



    // 开始提交请求权限
    private void startRequestPermissionCamera() {
        ActivityCompat.requestPermissions((Activity)context, permissionsCamera, 321);
    }

    // 开始提交请求权限
    private void startRequestPermissionStorage() {
        ActivityCompat.requestPermissions((Activity)context, permissionsStorage, 321);
    }

    // 开始提交请求权限
    private void startRequestPermissionCallPhone() {
        ActivityCompat.requestPermissions((Activity)context, permissionsCallPhone, 321);
    }



    /**
     * @param
     * @time
     * @description 对外开放接口 用于灵活处理 resId用来处理，同一个页面有多个按钮点击请求权限的情况
     */
    public interface HavePermission {

        void havePermission(int resId);

    }
}
