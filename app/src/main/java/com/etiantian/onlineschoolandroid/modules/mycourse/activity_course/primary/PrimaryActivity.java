package com.etiantian.onlineschoolandroid.modules.mycourse.activity_course.primary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;

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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actionbar_back_button:
                finish();
                break;
            case R.id.primary_activity_relative:
                break;
        }
    }
}