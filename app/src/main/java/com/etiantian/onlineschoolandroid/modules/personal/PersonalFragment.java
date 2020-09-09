package com.etiantian.onlineschoolandroid.modules.personal;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseFragment;
import com.etiantian.onlineschoolandroid.modules.login.LoginActivity;
import com.etiantian.onlineschoolandroid.tools.SharedPreferencesManager;

public class PersonalFragment extends BaseFragment implements CompoundButton.OnClickListener {

    private View root;
    private Button logoutButton;

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
        logoutButton = root.findViewById(R.id.logout_button_id);
        logoutButton.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logout_button_id:
                SharedPreferencesManager.instance().remove("token");
                SharedPreferencesManager.instance().remove("expiration");
                navigateTo(LoginActivity.class);
                break;
        }
    }
}