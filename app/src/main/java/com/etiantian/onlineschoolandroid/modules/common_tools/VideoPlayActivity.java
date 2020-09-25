package com.etiantian.onlineschoolandroid.modules.common_tools;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.google.gson.Gson;

public class VideoPlayActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);

        Intent intent = getIntent();
        if (intent != null) {
            String json = intent.getStringExtra("videoURLModel");
            if (json != null) {
                VideoURLModel videoURLModel = new Gson().fromJson(json, VideoURLModel.class);
                Log.d("1","视频回放页model转换成功");
            }
        }
    }
}