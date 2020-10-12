package com.etiantian.onlineschoolandroid.modules.mycourse.subject_detail;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.MyCourseSubjectModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.ai_test.AITestListActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.LiveListActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.WisdomListActivity;
import com.google.gson.Gson;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;
import org.angmarch.views.SpinnerTextFormatter;

public class SubjectDetailActivity extends BaseActivity implements CompoundButton.OnClickListener {

    private ImageView backImageView;
    private NiceSpinner niceSpinner;
    private MyCourseSubjectModel.DataBean model;
    private ViewGroup wisdom_relative;
    private ViewGroup ai_relative;
    private ViewGroup live_relative;
    // 年级id
    private String currentGradeId = "";
    // 学科id
    private String currentSubjectId = "";
    // 是否智领
    private boolean isZhiLing = false;

    SubjectDetailModel subjectDetailModel;
    boolean isTapped = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);
        hideActionBar();

        Intent intent = getIntent();
        if (intent != null) {
            String json = intent.getStringExtra("model");
            isZhiLing = (boolean) intent.getBooleanExtra("isZhiLing",false);
            MyCourseSubjectModel.DataBean dataBean = new Gson().fromJson(json,MyCourseSubjectModel.DataBean.class);
            this.model = dataBean;
            currentGradeId = String.valueOf(model.getGrades().get(0).getGradeId());
            currentSubjectId = String.valueOf(this.model.getSubjectId());
            Log.d("1","传递过来的数据:"+ dataBean.getSubjectName());
            initView();
            RequestParams params = new RequestParams();
            params.put("gradeId", String.valueOf(currentGradeId));
            params.put("cardType", String.valueOf(isZhiLing ? 3 : 2));
            params.put("subjectId", String.valueOf(currentSubjectId));
            hud.show();
            fetchSubjectDetail(params);
        }
    }

    private void fetchSubjectDetail(RequestParams params) {
        NetworkManager.subjectDetailFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                subjectDetailModel = (SubjectDetailModel) responseObj;
                Log.d("1","请求学科详情数据成功");
                hud.dismiss();
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","请求学科详情数据失败");
                hud.dismiss();
            }
        });
    }

    private void initView() {
        wisdom_relative = findViewById(R.id.subject_top);
        wisdom_relative.setOnClickListener(this);
        ai_relative = findViewById(R.id.subject_middle);
        ai_relative.setOnClickListener(this);
        live_relative = findViewById(R.id.subject_bottom);
        live_relative.setOnClickListener(this);

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
                currentGradeId = String.valueOf(gradesBean.getGradeId());
                Log.d("1","点击了");
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actionbar_back_image:
                finish();
                break;
            case R.id.subject_top:
                fetchMaterial();
                break;
            case R.id.subject_middle:
                navigateTo(AITestListActivity.class);
                break;
            case R.id.subject_bottom:
                Intent intent = new Intent(this, LiveListActivity.class);
                intent.putExtra("gradeId", currentGradeId);
                intent.putExtra("subjectId", currentSubjectId);
                startActivity(intent);
                break;
        }
    }

    /// 获取教材版本
    private void fetchMaterial() {
        RequestParams params = new RequestParams();
        params.put("subjectId", String.valueOf(model.getSubjectId()));
        params.put("gradeId", currentGradeId);
        params.put("type","2");
        NetworkManager.materialVersionFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                if (!isTapped) {
                    isTapped = true;
                    MaterialModel materialModel = (MaterialModel) responseObj;
                    Intent intent = new Intent(SubjectDetailActivity.this, WisdomListActivity.class);
                    intent.putExtra("subjectDetailModel", new Gson().toJson(model));
                    intent.putExtra("materialVersionModel", new Gson().toJson(materialModel.getData()));
                    intent.putExtra("gradeId", currentGradeId);
                    intent.putExtra("subjectId", currentSubjectId);
                    intent.putExtra("courseId", subjectDetailModel.getData().getCourseId());
                    intent.putExtra("isZhiLing", isZhiLing);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","获取教材版本失败");
            }
        });
    }

    @Override
    protected void onResume() {
        isTapped = false;
        super.onResume();
    }
}