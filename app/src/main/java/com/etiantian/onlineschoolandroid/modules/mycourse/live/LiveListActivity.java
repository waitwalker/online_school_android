package com.etiantian.onlineschoolandroid.modules.mycourse.live;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.adavance_notice.AdvanceNoticeLiveListFragment;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.current_period.CurrentPeriodLiveListFragment;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.play_back.PlayBackLiveListFragment;
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


public class LiveListActivity extends BaseActivity implements CompoundButton.OnClickListener {

    private ETTViewPager viewPager;
    private List<Fragment> fragmentList;
    private PagerAdapter pagerAdapter;
    private CurrentPeriodLiveListFragment currentPeriodLiveListFragment;
    private AdvanceNoticeLiveListFragment advanceNoticeLiveListFragment;
    private PlayBackLiveListFragment playBackLiveListFragment;

    private static final String[] CHANNELS = new String[]{"当期","预告","回放"};
    private List<String> mDataList = Arrays.asList(CHANNELS);

    private ViewGroup backButton;
    private Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_list);
        initActionBar();
        Intent intent = getIntent();
        if (intent != null) {
            String gradeId = intent.getStringExtra("gradeId");
            String subjectId = intent.getStringExtra("subjectId");
            if (gradeId != null && subjectId != null) {
                initView();
                initData(subjectId, gradeId);
                initIndicator();
            }
        }

    }

    private void initActionBar() {
        hideActionBar();

        backButton = findViewById(R.id.actionbar_back_button_);
        backButton.setOnClickListener(this);
        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
    }

    private void initView() {
        viewPager = findViewById(R.id.live_viewpager);
        pagerAdapter = new LivePageFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    private void initData(String subjectId, String gradeId) {
        currentPeriodLiveListFragment = CurrentPeriodLiveListFragment.newInstance(subjectId, gradeId);
        advanceNoticeLiveListFragment = AdvanceNoticeLiveListFragment.newInstance(subjectId, gradeId);
        playBackLiveListFragment = PlayBackLiveListFragment.newInstance(subjectId, gradeId);

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
                simplePagerTitleView.setText(mDataList.get(index));
                simplePagerTitleView.setTextSize(15);
                simplePagerTitleView.setNormalColor(Color.parseColor("#88000000"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#883399ff"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setColors(Color.parseColor("#40c4ff"));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        titleContainer.setDividerDrawable(new ColorDrawable() {
            @Override
            public int getIntrinsicWidth() {
                return UIUtil.dip2px(LiveListActivity.this, 65);
            }
        });
        ViewPagerHelper.bind(magicIndicator, viewPager);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actionbar_back_button_:
            case R.id.back_button:
                finish();
                break;
        }
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