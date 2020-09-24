package com.etiantian.onlineschoolandroid.modules.mycourse.live;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.widget.ETTViewPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class LiveListActivity extends BaseActivity {

    private ETTViewPager viewPager;
    private List<Fragment> fragmentList;
    private PagerAdapter pagerAdapter;
    private CurrentPeriodLiveListFragment currentPeriodLiveListFragment;
    private AdvanceNoticeLiveListFragment advanceNoticeLiveListFragment;
    private PlayBackLiveListFragment playBackLiveListFragment;

    private static final String[] CHANNELS = new String[]{"当期","预告","回放"};
    private List<String> mDataList = Arrays.asList(CHANNELS);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_list);
        initView();
        initData();
        initIndicator();
    }

    private void initView() {
        viewPager = findViewById(R.id.live_viewpager);
        pagerAdapter = new LivePageFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    private void initData() {
        currentPeriodLiveListFragment = CurrentPeriodLiveListFragment.newInstance();
        advanceNoticeLiveListFragment = AdvanceNoticeLiveListFragment.newInstance();
        playBackLiveListFragment = PlayBackLiveListFragment.newInstance();

        fragmentList = new LinkedList<Fragment>();
        fragmentList.add(currentPeriodLiveListFragment);
        fragmentList.add(advanceNoticeLiveListFragment);
        fragmentList.add(playBackLiveListFragment);
    }

    private void initIndicator() {
        MagicIndicator magicIndicator = findViewById(R.id.magicindicator);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setBackgroundColor(Color.YELLOW);
                simplePagerTitleView.setText(mDataList.get(index));
                simplePagerTitleView.setNormalColor(Color.BLACK);
                simplePagerTitleView.setSelectedColor(Color.parseColor("#883399ff"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setMode(LinePagerIndicator.MODE_MATCH_EDGE);
                linePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
                linePagerIndicator.setEndInterpolator(new DecelerateInterpolator(1.6f));
                linePagerIndicator.setYOffset(UIUtil.dip2px(context, 39));
                linePagerIndicator.setLineHeight(UIUtil.dip2px(context, 1));
                linePagerIndicator.setColors(Color.parseColor("#f57c00"));
                return linePagerIndicator;
            }

            @Override
            public float getTitleWeight(Context context, int index) {
                if (index == 0) {
                    return 2.0f;
                } else if (index == 1) {
                    return 1.2f;
                } else {
                    return 1.0f;
                }
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewPager);
    }

    ///
    /// @description 私有类 adapter
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/9 1:41 PM
    ///
    private class LivePageFragmentAdapter extends FragmentPagerAdapter {

        public LivePageFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public LivePageFragmentAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}