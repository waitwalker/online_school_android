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
import com.etiantian.onlineschoolandroid.base.BaseFragment;
import com.etiantian.onlineschoolandroid.modules.login.LoginActivity;
import com.etiantian.onlineschoolandroid.modules.personal.setting.SettingActivity;
import com.etiantian.onlineschoolandroid.singleton.RuntimeDataManager;
import com.etiantian.onlineschoolandroid.tools.SharedPreferencesManager;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonalFragment extends BaseFragment implements CompoundButton.OnClickListener {

    private View root;
    private Button logoutButton;
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

        avatarImageView = root.findViewById(R.id.personal_avatar);
        Glide.with(this).load(RuntimeDataManager.instance().getUserInfoModel().getData().getUserPhoto()).into(avatarImageView);

        download_container = root.findViewById(R.id.download_container);
        download_container.setOnClickListener(this);

        download_container = root.findViewById(R.id.download_container);
        download_container.setOnClickListener(this);


        setting_container = root.findViewById(R.id.setting_container);
        setting_container.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.download_container:
                Log.d("1", "点击了我的下载");
                break;
            case R.id.setting_container:
                navigateTo(SettingActivity.class);
                break;
        }
    }
}