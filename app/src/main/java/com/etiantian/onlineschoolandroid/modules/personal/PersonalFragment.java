package com.etiantian.onlineschoolandroid.modules.personal;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.base.BaseFragment;
import com.etiantian.onlineschoolandroid.modules.common_tools.CommonWebViewActivity;
import com.etiantian.onlineschoolandroid.modules.login.LoginActivity;
import com.etiantian.onlineschoolandroid.modules.personal.my_card_record.MyCardRecordActivity;
import com.etiantian.onlineschoolandroid.modules.personal.setting.SettingActivity;
import com.etiantian.onlineschoolandroid.singleton.RuntimeDataManager;
import com.etiantian.onlineschoolandroid.tools.SharedPreferencesManager;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonalFragment extends BaseFragment implements CompoundButton.OnClickListener {

    private View root;
    private ViewGroup download_container;
    private ViewGroup report_container;
    private ViewGroup errorBook_container;
    private ViewGroup active_container;

    private ViewGroup my_card_container;
    private ViewGroup eye_protect_container;
    private ViewGroup opinion_container;
    private ViewGroup help_container;
    private ViewGroup setting_container;
    private ViewGroup public_container;
    private ViewGroup record_container;

    private CircleImageView avatarImageView;
    private ImageView messageImageView;

    public PersonalFragment() {
        // Required empty public constructor
    }

    public static PersonalFragment newInstance() {
        return new PersonalFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_personal, container, false);

        // 头像
        avatarImageView = root.findViewById(R.id.personal_avatar);
        Glide.with(this).load(RuntimeDataManager.instance().getUserInfoModel().getData().getUserPhoto()).into(avatarImageView);

        // 我的下载
        download_container = root.findViewById(R.id.download_container);
        download_container.setOnClickListener(this);

        // 学习报告
        report_container = root.findViewById(R.id.report_container);
        report_container.setOnClickListener(this);

        // 错题本
        errorBook_container = root.findViewById(R.id.notebook_container);
        errorBook_container.setOnClickListener(this);

        // 激活课程
        active_container = root.findViewById(R.id.container_2);
        active_container.setOnClickListener(this);

        // 我的卡记录
        my_card_container = root.findViewById(R.id.card_record_container);
        my_card_container.setOnClickListener(this);

        // 护眼提醒
        eye_protect_container = root.findViewById(R.id.save_eye_container);
        eye_protect_container.setOnClickListener(this);

        // 意见反馈
        opinion_container = root.findViewById(R.id.recommend_container);
        opinion_container.setOnClickListener(this);

        // 帮助
        help_container = root.findViewById(R.id.help_container);
        help_container.setOnClickListener(this);

        // 设置
        setting_container = root.findViewById(R.id.setting_container);
        setting_container.setOnClickListener(this);

        // 湖北
        public_container = root.findViewById(R.id.public_container);
        public_container.setOnClickListener(this);

        // 备案内容
        record_container = root.findViewById(R.id.record_container);
        record_container.setOnClickListener(this);

        // 消息
        messageImageView = root.findViewById(R.id.personal_message);
        messageImageView.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.download_container:
                Log.d("1", "点击了我的下载");
                break;
            case R.id.report_container:
                Log.d("1", "点击了学习报告");
                Intent intent3 = new Intent(getContext(), CommonWebViewActivity.class);
                intent3.putExtra("url", NetworkManager.HttpConstants.Study_Report_HTML + "?token=" + NetworkManager.getToken() + "&h=" + RuntimeDataManager.instance().getUserInfoModel().getData().getUserPhoto());
                intent3.putExtra("showRightText",true);
                intent3.putExtra("title","学习报告");
                startActivity(intent3);
                break;
            case R.id.notebook_container:
                Log.d("1", "点击了错题本");
                break;
            case R.id.container_2:
                Log.d("1", "点击了激活课程");
                break;
            case R.id.card_record_container:
                Log.d("1", "点击了我的卡记录");
                navigateTo(MyCardRecordActivity.class);
                break;
            case R.id.save_eye_container:
                Log.d("1", "点击了护眼提醒");
                break;
            case R.id.recommend_container:
                Log.d("1", "点击了意见反馈");
                break;
            case R.id.help_container:
                Log.d("1", "点击了帮助");
                Intent intent2 = new Intent(getContext(), CommonWebViewActivity.class);
                intent2.putExtra("url", NetworkManager.HttpConstants.Help_HTML);
                intent2.putExtra("title","帮助");
                startActivity(intent2);
                break;
            case R.id.setting_container:
                navigateTo(SettingActivity.class);
                break;
            case R.id.public_container:
                Log.d("1", "点击了湖北公益课");
                break;
            case R.id.record_container:
                Log.d("1", "点击了备案内容承诺");
                Intent intent1 = new Intent(getContext(), CommonWebViewActivity.class);
                intent1.putExtra("url", "https://www.etiantian.com/recordm.html");
                intent1.putExtra("title","备案内容承诺");
                startActivity(intent1);
                break;
            case R.id.personal_message:
                Log.d("1", "点击了消息");
                break;
        }
    }
}