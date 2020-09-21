package com.etiantian.onlineschoolandroid.modules.mycourse.activity_course.primary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.common_tools.CommonWebViewActivity;

public class PrimaryActivity extends BaseActivity implements CompoundButton.OnClickListener {

    private ViewGroup chinese_relative;
    private ViewGroup math_relative;
    private ViewGroup english_relative;

    private ViewGroup backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary);
        initView();
    }

    private void initView() {
        hideActionBar();
        backButton = findViewById(R.id.actionbar_back_button);
        backButton.setOnClickListener(this);
        chinese_relative = findViewById(R.id.primary_subject_chinese);
        chinese_relative.setOnClickListener(this);
        math_relative = findViewById(R.id.primary_subject_math);
        math_relative.setOnClickListener(this);
        english_relative = findViewById(R.id.primary_subject_english);
        english_relative.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actionbar_back_button:
                finish();
                break;
            case R.id.primary_subject_chinese:
                Intent intent1 = new Intent(this, CommonWebViewActivity.class);
                intent1.putExtra("url", NetworkManager.HttpConstants.Primary_Activity_Chinese_URL);
                intent1.putExtra("title","小升初暑期课程--语文");
                startActivity(intent1);
                break;
            case R.id.primary_subject_math:
                Intent intent2 = new Intent(this, CommonWebViewActivity.class);
                intent2.putExtra("url", NetworkManager.HttpConstants.Primary_Activity_Math_URL);
                intent2.putExtra("title","小升初暑期课程--数学");
                startActivity(intent2);
                break;
            case R.id.primary_subject_english:
                Intent intent3 = new Intent(this, CommonWebViewActivity.class);
                intent3.putExtra("url", NetworkManager.HttpConstants.Primary_Activity_English_URL);
                intent3.putExtra("title","小升初暑期课程--英语");
                startActivity(intent3);
                break;
        }
    }
}