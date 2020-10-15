package com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.LiveListGridView;
import com.jaeger.library.StatusBarUtil;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

///
/// @description 知识导学列表
/// @author waitwalker
/// @time 2020/10/15 1:46 PM
///
public class KnowledgeGuideActivity extends BaseActivity implements View.OnClickListener {

    private ViewGroup backButton;
    private ViewGroup navigationBar;
    private TextView back_button;
    private CommonTitleBar commonTitleBar;
    private Button knowledgeButton;
    LiveListGridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_guide);
        initActionBar();
        Intent intent = getIntent();
        initView();
        if (intent != null) {
            String subjectId = intent.getStringExtra("subjectId");
            String gradeId = intent.getStringExtra("gradeId");
            RequestParams requestParams = new RequestParams();
            requestParams.put("subjectId", subjectId);
            requestParams.put("gradeId", gradeId);
            fetchKnowledgeGuide(requestParams);
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
        StatusBarUtil.setColor(KnowledgeGuideActivity.this, Color.parseColor("#5FACEF"));

        backButton = findViewById(R.id.back_container);
        backButton.setOnClickListener(this);
        back_button = findViewById(R.id.action_bar_title);

        back_button.setTextColor(Color.WHITE);
        back_button.setText("知识导学");
        back_button.setOnClickListener(this);

        knowledgeButton = findViewById(R.id.right_button);
        knowledgeButton.setOnClickListener(this);
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
        gridView = findViewById(R.id.knowledge_grid);
    }

    private void fetchKnowledgeGuide(RequestParams params) {
        NetworkManager.knowledgeGuideFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                KnowledgeGuideModel packageModel = (KnowledgeGuideModel) responseObj;
                Log.d("1","知识导学数据请求成功");
                KnowledgeGuideAdapter adapter = new KnowledgeGuideAdapter(KnowledgeGuideActivity.this, packageModel.getData());
                gridView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","资料包数据请求失败");
            }
        });
    }
}