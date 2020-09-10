package com.etiantian.onlineschoolandroid.modules.mycourse;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;

import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class MyCourseFragment extends BaseFragment implements CompoundButton.OnClickListener {

    private View root;
    private ViewGroup course_menu_container;
    private Button course_menu_button;
    private MyCourseGridView zhiLingGridView;
    private MyCourseGridView zhiXueGridView;

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
        fetchSubjectData();
        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.course_menu_container:
            case R.id.course_button:
                showToast("点击了课程按钮,这里应该跳转到课程表");
                break;
        }
    }

    /// 获取首页学科列表数据
    private void fetchSubjectData() {
        NetworkManager.myCourseSubjectFetch(new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {

                MyCourseSubjectModel courseSubjectModel = (MyCourseSubjectModel) responseObj;
                zhiLingGridView = root.findViewById(R.id.my_course_zhiling_grid);
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

                MyCourseGridViewAdapter adapter = new MyCourseGridViewAdapter(getContext(), zhiLingList);
                zhiLingGridView.setAdapter(adapter);
                Log.d("1","获取数据成功");
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","获取数据失败");
            }
        });
    }
}