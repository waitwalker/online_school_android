package com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.MyCourseSubjectModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.subject_detail.MaterialModel;
import com.google.gson.Gson;

public class WisdomListActivity extends BaseActivity {
    private MyCourseSubjectModel.DataBean subjectDetailModel;
    private MaterialModel.DataBean materialVersionModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisdom_list);
        Intent intent = getIntent();
        if (intent != null) {
            String subjectDetailJson = intent.getStringExtra("subjectDetailModel");
            String materialVersionJson = intent.getStringExtra("materialVersionModel");
            MyCourseSubjectModel.DataBean dataBean = new Gson().fromJson(subjectDetailJson,MyCourseSubjectModel.DataBean.class);
            MaterialModel.DataBean material = new Gson().fromJson(materialVersionJson,MaterialModel.DataBean.class);
            this.subjectDetailModel = dataBean;
            this.materialVersionModel = material;
            Log.d("1","传递过来的数据:"+ dataBean.getSubjectName());
            fetchWisdomList();
        }
    }

    /// 获取智慧学习列表
    private void fetchWisdomList() {
        RequestParams params = new RequestParams();
        params.put("materialId", String.valueOf(materialVersionModel.getDefMaterialId()));
        NetworkManager.wisdomListFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                WisdomModel wisdomModel = (WisdomModel) responseObj;
                Log.d("1","获取智慧学习列表成功");
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","获取智慧学习列表失败");
            }
        });
    }
}