package com.etiantian.onlineschoolandroid.modules.personal.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.login.LoginActivity;
import com.etiantian.onlineschoolandroid.tools.SharedPreferencesManager;

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesManager.instance().remove("token");
                SharedPreferencesManager.instance().remove("expiration");
                navigateTo(LoginActivity.class);
            }
        });
    }
}