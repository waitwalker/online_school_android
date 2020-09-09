package com.etiantian.onlineschoolandroid.entrance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.model.ActivityCourseAlertModel;
import com.etiantian.onlineschoolandroid.modules.login.LoginActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.MyCourseFragment;
import com.etiantian.onlineschoolandroid.modules.personal.PersonalFragment;
import com.etiantian.onlineschoolandroid.modules.widget.ETTViewPager;
import com.etiantian.onlineschoolandroid.tools.SharedPreferencesManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TabBarNavigationActivity extends BaseActivity implements CompoundButton.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener{

    private BottomNavigationView bottomNavigationView;
    private ETTViewPager viewPager;

    private MyCourseFragment myCourseFragment;
    private PersonalFragment personalFragment;

    private List<Fragment> fragmentList;
    private PagerAdapter pagerAdapter;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_bar_navigation);
        initView();
        initData();
        initAdapter();
        initEvent();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

        }
    }

    ///
    /// @description 物理键返回操作
    /// @param 
    /// @return 
    /// @author waitwalker
    /// @time 2020/9/9 1:43 PM
    ///
    @Override
    public void onBackPressed() {

    }

    /// 初始化view
    private void initView() {
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        int statusBarHeight1 = -1;
        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight1 = getResources().getDimensionPixelSize(resourceId);
        }
        Log.e("WangJ", "状态栏-方法1:" + statusBarHeight1);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        viewPager = findViewById(R.id.viewpager);
        bottomNavigationView.setItemIconTintList(null);
    }

    /// 初始化data
    private void initData() {

        myCourseFragment = MyCourseFragment.newInstance();
        personalFragment = PersonalFragment.newInstance();
        fragmentList = new LinkedList<Fragment>();
        fragmentList.add(myCourseFragment);
        fragmentList.add(personalFragment);

        EventBus.getDefault().register(this);
        testAPI();
    }

    /// 初始化adapter
    private void initAdapter() {
        pagerAdapter = new HomePageFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    /// 监听事件
    private void initEvent() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        viewPager.addOnPageChangeListener(this);
    }


    private void testAPI() {
        NetworkManager.activityCourseAlertFetch(new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.d("1","响应成功");
                ActivityCourseAlertModel activityCourseAlertModel = (ActivityCourseAlertModel) responseObj;
                Log.d("1","活动课接口:" + activityCourseAlertModel.getMsg());
                showToast(activityCourseAlertModel.getData().getDescription());
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","响应失败");
            }
        });
    }

    ///
    /// @description 处理EventBus发来的消息
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/2 2:05 PM
    ///
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleEventBus(Object object){

        Log.d("1","消息:");
        if (object instanceof HashMap) {
            HashMap hashMap = (HashMap) object;
            int errorCode = (int) hashMap.get("errorCode");
            String message = (String) hashMap.get("message");
            String errorMsg;

            Log.d("1","错误码:" + errorCode + "\n" + "错误消息:" + message);

            switch (errorCode) {
                case 401:
                    showToast("授权失败");
                    navigateTo(LoginActivity.class);
                    break;
                case 403:
                    showToast("禁止访问");
                    break;
                case 404:
                    showToast("网络错误404");
                    break;
                case 413:
                    showToast("上传文件太大");
                    break;
                case 500:
                    showToast("服务器错误");
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    ///
    /// @description viewPager 翻页回调
    /// @param 
    /// @return 
    /// @author waitwalker
    /// @time 2020/9/9 1:42 PM
    ///
    @Override
    public void onPageSelected(int position) {
        defaultIcon();
        MenuItem menuItem = bottomNavigationView.getMenu().getItem(position);
        if (menuItem.getItemId() == R.id.menu_item_my_course) {
            menuItem.setIcon(R.mipmap.tab_button_class_selected);
        } else {
            menuItem.setIcon(R.mipmap.tab_button_personal_center_selected);
        }
        menuItem.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    ///
    /// @description item 被选中回调
    /// @param 
    /// @return 
    /// @author waitwalker
    /// @time 2020/9/9 1:41 PM
    ///
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = 0;
        defaultIcon();
        switch (item.getItemId()) {
            case R.id.menu_item_my_course:
                itemId = 0;
                item.setIcon(R.mipmap.tab_button_class_selected);

                break;
            case R.id.menu_item_personal:
                itemId = 1;
                item.setIcon(R.mipmap.tab_button_personal_center_selected);
                break;
        }
        viewPager.setCurrentItem(itemId);
        return true;
    }

    ///
    /// @description 设置未选中状态icon
    /// @param 
    /// @return 
    /// @author waitwalker
    /// @time 2020/9/9 1:41 PM
    ///
    private void defaultIcon() {
        MenuItem myCourseItem = bottomNavigationView.getMenu().findItem(R.id.menu_item_my_course);
        MenuItem personalItem = bottomNavigationView.getMenu().findItem(R.id.menu_item_personal);
        myCourseItem.setIcon(R.mipmap.tab_button_class);
        personalItem.setIcon(R.mipmap.tab_button_personal_center);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    ///
    /// @description 私有类 adapter
    /// @param 
    /// @return 
    /// @author waitwalker
    /// @time 2020/9/9 1:41 PM
    ///
    private class HomePageFragmentAdapter extends FragmentPagerAdapter {

        public HomePageFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public HomePageFragmentAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}