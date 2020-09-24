package com.etiantian.onlineschoolandroid.modules.mycourse.live;
import android.os.Bundle;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.widget.ETTViewPager;


public class LiveListActivity extends BaseActivity {

    ETTViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_list);
    }

    private void initView() {

    }
}