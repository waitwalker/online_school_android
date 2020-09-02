package com.etiantian.onlineschoolandroid.modules.welcome;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.entrance.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.login.LoginActivity;
import com.etiantian.onlineschoolandroid.tools.PackageInfoManager;
import com.etiantian.onlineschoolandroid.tools.SharedPreferencesManager;

public class WelcomeActivity extends BaseActivity implements CompoundButton.OnClickListener {

    private Button welcomeToLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeToLoginButton = findViewById(R.id.welcome_to_login_button);
        welcomeToLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.welcome_to_login_button:
                Intent intent = new Intent(this, LoginActivity.class);
                intent.putExtra("back","yes");
                int versionCode = PackageInfoManager.getVersionCode(this);
                SharedPreferencesManager.instance().putInt("versionCode", versionCode);
                startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {

    }
}