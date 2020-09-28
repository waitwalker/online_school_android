package com.etiantian.onlineschoolandroid.modules.common_tools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.Date;

public class SaveImgTools {

    /**
     *@time
     *@param
     *@description 保存图片到相册
     */
    public static void SaveImageToSysAlbum(Context context, ImageView imageView) {

        BitmapDrawable bmpDrawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = bmpDrawable.getBitmap();
        if (bitmap==null){
            return;
        }
        MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "HaiGouShareCode", "");
        String fileName = new Date().getTime() + ".png";
        File mPhotoFile = new File(fileName);
        Intent mediaScanIntent = new Intent(
                Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri contentUri = Uri.fromFile(mPhotoFile);
        mediaScanIntent.setData(contentUri);
        context.sendBroadcast(mediaScanIntent);
        Toast.makeText(context,"已保存到相册",Toast.LENGTH_SHORT).show();
    }

    public interface HavePressSaveImgDialogSure {
        void havePressSure(int resId);
    }
}