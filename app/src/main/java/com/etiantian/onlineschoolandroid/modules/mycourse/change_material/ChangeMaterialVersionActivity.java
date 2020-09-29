package com.etiantian.onlineschoolandroid.modules.mycourse.change_material;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

///
/// @description 切换教材版本
/// @author waitwalker
/// @time 2020/9/29 11:06 AM
///
public class ChangeMaterialVersionActivity extends BaseActivity implements CompoundButton.OnClickListener {

    private ViewGroup backButton;
    private ViewGroup navigationBar;
    private TextView back_button;
    private CommonTitleBar commonTitleBar;
    private RecyclerView recyclerView;
    private ChangeMaterialVersionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_material_verison);
        initActionBar();
        Intent intent = getIntent();
        if (intent != null) {
            String gradeId = intent.getStringExtra("gradeId");
            String subjectId = intent.getStringExtra("subjectId");
            initView();
            fetchMaterialData(subjectId, gradeId);
        }
    }

    ///
    /// @description actionBar
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/29 9:09 AM
    ///
    private void initActionBar() {
        hideActionBar();
        navigationBar = findViewById(R.id.navigation_bar);
        navigationBar.setBackgroundColor(Color.parseColor("#5FACEF"));
        commonTitleBar = findViewById(R.id.actionbar);
        commonTitleBar.setBackgroundColor(Color.parseColor("#5FACEF"));

        backButton = findViewById(R.id.back_container);
        backButton.setOnClickListener(this);
        back_button = findViewById(R.id.action_bar_title);
        back_button.setText("选择教材版本");
        back_button.setTextColor(Color.WHITE);
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
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new ChangeMaterialVersionAdapter(this);
        recyclerView.setAdapter(adapter);
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