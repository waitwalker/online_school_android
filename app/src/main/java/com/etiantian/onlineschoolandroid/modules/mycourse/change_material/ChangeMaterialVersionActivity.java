package com.etiantian.onlineschoolandroid.modules.mycourse.change_material;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;

///
/// @description 切换教材版本
/// @author waitwalker
/// @time 2020/9/29 11:06 AM
///
public class ChangeMaterialVersionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_material_verison);
        Intent intent = getIntent();
        if (intent != null) {
            String gradeId = intent.getStringExtra("gradeId");
            String subjectId = intent.getStringExtra("subjectId");
            fetchMaterialData(subjectId, gradeId);
        }
    }

    private void fetchMaterialData(String subjectId, String gradeId) {
        RequestParams params = new RequestParams();
        params.put("gradeId", gradeId);
        params.put("subjectId", subjectId);
        params.put("listType", "2");
        NetworkManager.materialVersionListFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.d("1","获取教材版本列表成功");
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","获取教材版本列表失败");
            }
        });
    }
}