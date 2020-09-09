package com.etiantian.onlineschoolandroid.modules.mycourse;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseFragment;

public class MyCourseFragment extends BaseFragment implements CompoundButton.OnClickListener {

    private View root;
    private ViewGroup course_menu_container;
    private Button course_menu_button;

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
}