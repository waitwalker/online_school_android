package com.etiantian.onlineschoolandroid.modules.mycourse.live;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etiantian.onlineschoolandroid.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayBackLiveListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayBackLiveListFragment extends Fragment {

    public PlayBackLiveListFragment() {
        // Required empty public constructor
    }

    public static PlayBackLiveListFragment newInstance() {
        return new PlayBackLiveListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play_back_live_list, container, false);
    }
}