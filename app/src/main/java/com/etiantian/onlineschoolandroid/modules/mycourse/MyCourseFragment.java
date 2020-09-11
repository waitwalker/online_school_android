package com.etiantian.onlineschoolandroid.modules.mycourse;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.base.BaseFragment;
import com.etiantian.onlineschoolandroid.model.ActivityCourseAlertModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.activity_course.ImageAlertCallBack;
import com.etiantian.onlineschoolandroid.modules.mycourse.activity_course.ImageDialogAlert;
import com.etiantian.onlineschoolandroid.modules.mycourse.recommend.RecommendModel;

import java.util.ArrayList;
import java.util.List;

public class MyCourseFragment extends BaseFragment implements CompoundButton.OnClickListener {

    /// 根布局
    private View root;
    /// 课程表容器
    private ViewGroup course_menu_container;
    private Button course_menu_button;
    
    /// 智领课卡片布局
    private MyCourseGridView zhiLingGridView;
    
    /// 智学课卡片布局
    private MyCourseGridView zhiXueGridView;
    
    /// 联通活动课
    private ViewGroup union_relative;

    /// 小升初活动课
    private ViewGroup primary_relative;

    /// 四中名师活动课
    private ViewGroup new_semester_relative;

    /// 普通活动课
    private ViewGroup normal_relative;

    /// 推荐学习AI
    private ViewGroup ai_relative;

    /// 推荐学习智慧学习
    private ViewGroup wisdom_relative;

    /// 推荐学习大师直播
    private ViewGroup live_relative;

    /// 推荐学习中AI时间
    private TextView ai_time_text;

    /// 推荐学习中智慧学习时间
    private TextView wisdom_time_text;
    

    public MyCourseFragment() {
        // Required empty public constructor
    }

    public static MyCourseFragment newInstance() {
        return new MyCourseFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_my_course, container, false);
        course_menu_container = root.findViewById(R.id.course_menu_container);
        course_menu_container.setOnClickListener(this);
        course_menu_button = root.findViewById(R.id.course_button);
        course_menu_button.setOnClickListener(this);
        zhiLingGridView = root.findViewById(R.id.my_course_zhiling_grid);
        zhiXueGridView = root.findViewById(R.id.my_course_zhixue_grid);
        
        union_relative = root.findViewById(R.id.union_activity_relative);
        union_relative.setOnClickListener(this);
        primary_relative = root.findViewById(R.id.primary_activity_relative);
        primary_relative.setOnClickListener(this);
        new_semester_relative = root.findViewById(R.id.new_semester_activity_relative);
        new_semester_relative.setOnClickListener(this);
        normal_relative = root.findViewById(R.id.normal_activity_relative);
        normal_relative.setOnClickListener(this);

        ai_relative = root.findViewById(R.id.recommend_ai_relative);
        wisdom_relative = root.findViewById(R.id.recommend_wisdom_relative);
        live_relative = root.findViewById(R.id.recommend_live_relative);
        ai_relative.setOnClickListener(this);
        wisdom_relative.setOnClickListener(this);
        live_relative.setOnClickListener(this);


        ai_time_text = root.findViewById(R.id.ai_time_text);
        SpannableString spannableString = new SpannableString("每天只需10分钟");
        spannableString.setSpan(new AbsoluteSizeSpan(12, true),
                0, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#4A90E2")),
                0, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),
                4, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan(20, true),
                4, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ai_time_text.setText(spannableString);

        wisdom_time_text = root.findViewById(R.id.wisdom_time_text);
        SpannableString wisdomSpannableString = new SpannableString("15分钟搞定难点");
        wisdomSpannableString.setSpan(new AbsoluteSizeSpan(12, true),
                0, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        wisdomSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#4A90E2")),
                0, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        wisdomSpannableString.setSpan(new StyleSpan(Typeface.BOLD),
                0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        wisdomSpannableString.setSpan(new AbsoluteSizeSpan(20, true),
                0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        wisdom_time_text.setText(wisdomSpannableString);
        
        fetchSubjectData();
        //fetchActivityCourseData();
        fetchRecommendData();
        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.course_menu_container:
            case R.id.course_button:
                showToast("点击了课程按钮,这里应该跳转到课程表");
                break;
            case R.id.union_activity_relative:
                showToast("点击了联通活动课");
                fetchActivityCourseData();
                break;
            case R.id.primary_activity_relative:
                showToast("点击了小升初活动课");
                break;
            case R.id.new_semester_activity_relative:
                showToast("点击了四中名师活动课");
                break;
            case R.id.normal_activity_relative:
                showToast("点击了普通活动课");
                break;
            case R.id.recommend_ai_relative:
                showToast("点击了推荐学习中AI");
                break;
            case R.id.recommend_wisdom_relative:
                showToast("点击了推荐学习中智慧学习");
                break;
            case R.id.recommend_live_relative:
                showToast("点击了推荐学习中大师直播");
                break;
        }
    }

    /// 获取首页学科列表数据
    private void fetchSubjectData() {
        NetworkManager.myCourseSubjectFetch(new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {

                MyCourseSubjectModel courseSubjectModel = (MyCourseSubjectModel) responseObj;
                List<MyCourseSubjectModel.DataBean> zhiLingList = new ArrayList<>();
                List<MyCourseSubjectModel.DataBean> zhiXueList = new ArrayList<>();
                for (int i = 0; i < courseSubjectModel.getData().size(); i++) {
                    MyCourseSubjectModel.DataBean dataBean = courseSubjectModel.getData().get(i);
                    if (dataBean.getSubjectId() == 2 || dataBean.getSubjectId() == 3 || dataBean.getSubjectId() == 4 || dataBean.getSubjectId() == 5) {
                        zhiLingList.add(dataBean);
                    } else {
                        zhiXueList.add(dataBean);
                    }
                }

                MyCourseGridViewAdapter zhiLingAdapter = new MyCourseGridViewAdapter(getContext(), zhiLingList);
                zhiLingGridView.setAdapter(zhiLingAdapter);

                MyCourseGridViewAdapter zhiXueAdapter = new MyCourseGridViewAdapter(getContext(), zhiXueList);
                zhiXueGridView.setAdapter(zhiXueAdapter);
                Log.d("1","获取数据成功");
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","获取数据失败");
            }
        });
    }

    /// 获取活动课数据
    private void fetchRecommendData() {
        NetworkManager.recommendFetch(new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.d("1","响应成功");
                RecommendModel recommendModel = (RecommendModel) responseObj;

            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","响应失败");
            }
        });
    }

    /// 获取活动课数据
    private void fetchActivityCourseData() {
        NetworkManager.activityCourseAlertFetch(new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.d("1","响应成功");
                ActivityCourseAlertModel activityCourseAlertModel = (ActivityCourseAlertModel) responseObj;
                Log.d("1","活动课接口:" + activityCourseAlertModel.getMsg());
                if (activityCourseAlertModel.getCode() == 1 && activityCourseAlertModel.getData() != null) {
                    if (activityCourseAlertModel.getData().getIsOpen() == 1 && activityCourseAlertModel.getData().getPicture() != null) {
                        final ImageDialogAlert dialogAlert = new ImageDialogAlert.Builder(getContext(), new ImageAlertCallBack() {
                            @Override
                            public void imageClickAction() {
                                Log.d("1","点击了图片弹出框");
                            }
                        }).setImage(activityCourseAlertModel.getData().getPicture()).create();
                        dialogAlert.show();
                    }
                }

            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","响应失败");
            }
        });
    }

}