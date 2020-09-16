package com.etiantian.onlineschoolandroid.modules.mycourse.subject_detail;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.MyCourseSubjectModel;
import com.google.gson.Gson;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;
import org.angmarch.views.SpinnerTextFormatter;

public class SubjectDetailActivity extends BaseActivity implements CompoundButton.OnClickListener {

    private ImageView backImageView;
    private NiceSpinner niceSpinner;
    MyCourseSubjectModel.DataBean model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);
        hideActionBar();

        Intent intent = getIntent();
        if (intent != null) {
            String json = intent.getStringExtra("model");
            boolean isZhiLing = (boolean) intent.getBooleanExtra("isZhiLing",false);
            MyCourseSubjectModel.DataBean dataBean = new Gson().fromJson(json,MyCourseSubjectModel.DataBean.class);
            this.model = dataBean;
            Log.d("1","传递过来的数据:"+ dataBean.getSubjectName());
            initView();
        }
    }

    private void initView() {
        backImageView = findViewById(R.id.actionbar_back_image);
        backImageView.setOnClickListener(this);
        niceSpinner = findViewById(R.id.nice_spinner);
        SpinnerTextFormatter textFormatter = new SpinnerTextFormatter<MyCourseSubjectModel.DataBean.GradesBean>() {
            @Override
            public Spannable format(MyCourseSubjectModel.DataBean.GradesBean gradeModel) {
                String gradeName = gradeModel.getGradeName() + model.getSubjectName();
                return new SpannableString(gradeName);
            }
        };

        niceSpinner.setSpinnerTextFormatter(textFormatter);
        niceSpinner.setSelectedTextFormatter(textFormatter);
        niceSpinner.attachDataSource(model.getGrades());
        niceSpinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {

                MyCourseSubjectModel.DataBean.GradesBean gradesBean = (MyCourseSubjectModel.DataBean.GradesBean) niceSpinner.getSelectedItem();
                Log.d("1","点击了");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actionbar_back_image:
                finish();
                break;
        }
    }
}