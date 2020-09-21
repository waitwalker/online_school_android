package com.etiantian.onlineschoolandroid.modules.mycourse.activity_course.new_semester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.common_tools.CommonWebViewActivity;

public class NewSemesterActivity extends BaseActivity implements CompoundButton.OnClickListener{
    private ViewGroup semester_junior_one_math;
    private ViewGroup semester_junior_two_chinese;
    private ViewGroup semester_junior_three_english;

    private ViewGroup semester_senior_one_math;
    private ViewGroup semester_senior_two_physics;
    private ViewGroup primary_subject_english;

    private ViewGroup backButton;
    private Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_semester);

        initView();
    }

    private void initView() {
        hideActionBar();
        backButton = findViewById(R.id.actionbar_back_button_);
        backButton.setOnClickListener(this);
        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(this);

        semester_junior_one_math = findViewById(R.id.semester_junior_one_math);
        semester_junior_one_math.setOnClickListener(this);

        semester_junior_two_chinese = findViewById(R.id.semester_junior_two_chinese);
        semester_junior_two_chinese.setOnClickListener(this);

        semester_junior_three_english = findViewById(R.id.semester_junior_three_english);
        semester_junior_three_english.setOnClickListener(this);

        semester_senior_one_math = findViewById(R.id.semester_senior_one_math);
        semester_senior_one_math.setOnClickListener(this);

        semester_senior_two_physics = findViewById(R.id.semester_senior_two_physics);
        semester_senior_two_physics.setOnClickListener(this);

        primary_subject_english = findViewById(R.id.primary_subject_english);
        primary_subject_english.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actionbar_back_button_:
            case R.id.back_button:
                finish();
                break;
            case R.id.semester_junior_one_math:
                Intent intent1 = new Intent(this, CommonWebViewActivity.class);
                intent1.putExtra("url", NetworkManager.HttpConstants.New_Semester_Activity + "&type=0");
                intent1.putExtra("title","初一数学");
                startActivity(intent1);
                break;
            case R.id.semester_junior_two_chinese:
                Intent intent2 = new Intent(this, CommonWebViewActivity.class);
                intent2.putExtra("url", NetworkManager.HttpConstants.New_Semester_Activity + "&type=1");
                intent2.putExtra("title","初二语文");
                startActivity(intent2);
                break;
            case R.id.semester_junior_three_english:
                Intent intent3 = new Intent(this, CommonWebViewActivity.class);
                intent3.putExtra("url", NetworkManager.HttpConstants.New_Semester_Activity + "&type=2");
                intent3.putExtra("title","初三英语");
                startActivity(intent3);
                break;
            case R.id.semester_senior_one_math:
                Intent intent4 = new Intent(this, CommonWebViewActivity.class);
                intent4.putExtra("url", NetworkManager.HttpConstants.New_Semester_Activity + "&type=3");
                intent4.putExtra("title","高一数学");
                startActivity(intent4);
                break;
            case R.id.semester_senior_two_physics:
                Intent intent5 = new Intent(this, CommonWebViewActivity.class);
                intent5.putExtra("url", NetworkManager.HttpConstants.New_Semester_Activity + "&type=4");
                intent5.putExtra("title","高二物理");
                startActivity(intent5);
                break;
            case R.id.primary_subject_english:
                Intent intent6 = new Intent(this, CommonWebViewActivity.class);
                intent6.putExtra("url", NetworkManager.HttpConstants.New_Semester_Activity + "&type=5");
                intent6.putExtra("title","高三英语");
                startActivity(intent6);
                break;
        }
    }
}