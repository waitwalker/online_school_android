package com.etiantian.onlineschoolandroid.modules.mycourse.subject_detail;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.MyCourseSubjectModel;
import com.google.gson.Gson;

public class SubjectDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);

        Intent intent = getIntent();
        if (intent != null) {
            String json = intent.getStringExtra("model");
            boolean isZhiLing = (boolean) intent.getBooleanExtra("isZhiLing",false);
            MyCourseSubjectModel.DataBean dataBean = new Gson().fromJson(json,MyCourseSubjectModel.DataBean.class);
            Log.d("1","传递过来的数据:"+ dataBean.getSubjectName());
        }
    }
}