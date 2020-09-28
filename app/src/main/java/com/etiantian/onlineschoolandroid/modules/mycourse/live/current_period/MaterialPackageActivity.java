package com.etiantian.onlineschoolandroid.modules.mycourse.live.current_period;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.LiveListGridView;
import com.wang.avi.AVLoadingIndicatorView;

public class MaterialPackageActivity extends BaseActivity implements CompoundButton.OnClickListener{

    AVLoadingIndicatorView loadingIndicatorView;
    LiveListGridView gridView;
    private ViewGroup backButton;
    private TextView back_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_package);
        initActionBar();
        Intent intent = getIntent();
        if (intent != null) {
            String courseIds = intent.getStringExtra("courseIds");
            initView();
            fetchMaterialPackage(courseIds);
            loadingIndicatorView.setVisibility(View.INVISIBLE);
            gridView.setVisibility(View.VISIBLE);
        }
    }

    private void initActionBar() {
        hideActionBar();

        backButton = findViewById(R.id.back_container);
        backButton.setOnClickListener(this);
        back_button = findViewById(R.id.action_bar_title);
        back_button.setText("资料包");
        back_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_container:
            case R.id.action_bar_title:
                finish();
                break;
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