package com.etiantian.onlineschoolandroid.modules.mycourse.activity_course;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.etiantian.onlineschoolandroid.R;

public class ImageDialogAlert extends Dialog {
    private ImageDialogAlert(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder {

        private Context mContext;
        private View mLayout;

        private ImageView content_image;

        private View.OnClickListener mButtonClickListener;

        private ImageDialogAlert mDialog;
        private ImageAlertCallBack mCallBack;

        public Builder(Context context, ImageAlertCallBack callBack) {
            mContext = context;
            mCallBack = callBack;
            mDialog = new ImageDialogAlert(context, R.style.Theme_AppCompat_Dialog);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //加载布局文件
            mLayout = inflater.inflate(R.layout.image_dialog_layout, null, false);
            //添加布局文件到 Dialog
            mDialog.addContentView(mLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            content_image = mLayout.findViewById(R.id.alert_image);
        }

        /**
         * 通过 ID 设置 Dialog 图片
         */
        public Builder setImage(int resId) {
            content_image.setImageResource(resId);
            return this;
        }

        ///
        /// @description 加载网络图片
        /// @param
        /// @return
        /// @author waitwalker
        /// @time 2020/9/11 1:25 PM
        ///
        public Builder setImage(String imageUrl) {
            Glide.with(mContext).load(imageUrl).placeholder(R.mipmap.logo).error(R.mipmap.ic_launcher).into(content_image);
            return this;
        }

        /**
         * 用 Bitmap 作为 Dialog 图片
         */
        public Builder setImage(Bitmap bitmap) {
            content_image.setImageBitmap(bitmap);
            return this;
        }

        public ImageDialogAlert create() {
            content_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDialog.dismiss();
                    mCallBack.imageClickAction();
                }
            });
            mDialog.setContentView(mLayout);
            mDialog.setCancelable(true);                //用户可以点击后退键关闭 Dialog
            mDialog.setCanceledOnTouchOutside(true);   //用户不可以点击外部来关闭 Dialog
            return mDialog;
        }
    }
}

