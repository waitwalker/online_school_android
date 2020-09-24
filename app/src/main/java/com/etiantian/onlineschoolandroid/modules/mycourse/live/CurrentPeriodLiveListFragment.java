package com.etiantian.onlineschoolandroid.modules.mycourse.live;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etiantian.onlineschoolandroid.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrentPeriodLiveListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrentPeriodLiveListFragment extends Fragment {


    public CurrentPeriodLiveListFragment() {
        // Required empty public constructor
    }

    public static CurrentPeriodLiveListFragment newInstance() {
        return new CurrentPeriodLiveListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_period_live_list, container, false);
    }
}