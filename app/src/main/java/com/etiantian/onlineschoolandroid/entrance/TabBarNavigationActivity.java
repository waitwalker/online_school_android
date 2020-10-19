package com.etiantian.onlineschoolandroid.entrance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;

import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.model.ActivityCourseAlertModel;
import com.etiantian.onlineschoolandroid.modules.common_tools.CommonToolManager;
import com.etiantian.onlineschoolandroid.modules.login.LoginActivity;
import com.etiantian.onlineschoolandroid.modules.login.UserInfoModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.MyCourseFragment;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.WisdomListActivity;
import com.etiantian.onlineschoolandroid.modules.personal.PersonalFragment;
import com.etiantian.onlineschoolandroid.modules.widget.ETTViewPager;
import com.etiantian.onlineschoolandroid.singleton.RuntimeDataManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jaeger.library.StatusBarUtil;

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
        hideActionBar();
        setContentView(R.layout.activity_tab_bar_navigation);
        fetchUserInfo();
    }

    ///
    /// @description 获取用户信息
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/10/19 9:25 AM
    ///
    private void fetchUserInfo() {
        hud.show();
        NetworkManager.userInfoFetch(new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.d("1","获取用户信息成功");
                UserInfoModel userInfoModel = (UserInfoModel)responseObj;
                RuntimeDataManager.instance().setUserInfoModel(userInfoModel);
                initView();
                hud.dismiss();
                initData();
                initAdapter();
                initEvent();
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","获取用户信息失败");
                hud.dismiss();
            }
        });
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
        StatusBarUtil.setColor(TabBarNavigationActivity.this, Color.parseColor("#5FACEF"));
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
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