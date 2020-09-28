package com.etiantian.onlineschoolandroid.modules.mycourse.live.current_period;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.LiveListGridView;
import com.wang.avi.AVLoadingIndicatorView;

public class MaterialPackageActivity extends AppCompatActivity {

    AVLoadingIndicatorView loadingIndicatorView;
    LiveListGridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_package);
        Intent intent = getIntent();
        if (intent != null) {
            String courseIds = intent.getStringExtra("courseIds");
            initView();
            fetchMaterialPackage(courseIds);
            loadingIndicatorView.setVisibility(View.INVISIBLE);
            gridView.setVisibility(View.VISIBLE);
        }
    }

    private void initView() {
        loadingIndicatorView = findViewById(R.id.loading);
        gridView = findViewById(R.id.materil_package_grid);
    }

    private void fetchMaterialPackage(String courseIds) {
        RequestParams params = new RequestParams();
        params.put("courseIds", courseIds);
        NetworkManager.materialPackageFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                MaterialPackageModel packageModel = (MaterialPackageModel) responseObj;
                Log.d("1","资料包数据请求成功");
                MaterialPackageAdapter adapter = new MaterialPackageAdapter(MaterialPackageActivity.this, packageModel.getData());
                gridView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","资料包数据请求失败");
            }
        });
    }
}