package com.etiantian.onlineschoolandroid.modules.personal.my_card_record;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.change_material.ChangeMaterialVersionActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.KnowledgeGuideActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.WisdomListActivity;
import com.jaeger.library.StatusBarUtil;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

public class MyCardRecordActivity extends BaseActivity implements CompoundButton.OnClickListener {

    private ViewGroup backButton;
    private ViewGroup navigationBar;
    private TextView back_button;
    private CommonTitleBar commonTitleBar;
    private Button knowledgeButton;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_card_record);
        initActionBar();
        initView();
        fetchMyCardRecordData();
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
        StatusBarUtil.setColor(MyCardRecordActivity.this, Color.parseColor("#5FACEF"));

        backButton = findViewById(R.id.back_container);
        backButton.setOnClickListener(this);
        back_button = findViewById(R.id.action_bar_title);
        back_button.setText("我的卡记录");
        back_button.setTextColor(Color.WHITE);
        back_button.setOnClickListener(this);

        knowledgeButton = findViewById(R.id.right_button);
        knowledgeButton.setOnClickListener(this);
        knowledgeButton.setVisibility(View.INVISIBLE);
    }

    private void initView() {
        listView = findViewById(R.id.my_card_list_view);
    }

    ///
    /// @description 获取数据
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/11/5 10:42 AM
    ///
    private void fetchMyCardRecordData() {
        NetworkManager.myCardRecordFetch(new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.d("1","获取数据成功");
                MyCardRecordModel myCardRecordModel = (MyCardRecordModel) responseObj;
                MyCardRecordAdapter adapter = new MyCardRecordAdapter(myCardRecordModel.getData(), MyCardRecordActivity.this);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1", "获取我的卡记录数据失败");
            }
        });
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
}