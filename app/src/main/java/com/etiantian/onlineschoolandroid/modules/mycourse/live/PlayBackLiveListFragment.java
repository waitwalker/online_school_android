package com.etiantian.onlineschoolandroid.modules.mycourse.live;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayBackLiveListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayBackLiveListFragment extends Fragment {

    private View root;
    private LiveListGridView liveListGridView;

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
        root = inflater.inflate(R.layout.fragment_play_back_live_list, container, false);
        liveListGridView = root.findViewById(R.id.playback_grid);
        fetchPlayBackData();
        return root;
    }

    ///
    /// @description 获取直播回放列表
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/24 2:24 PM
    ///
    private void fetchPlayBackData() {
        RequestParams params = new RequestParams();
        params.put("gradeId", "6");
        params.put("subjectId", "2");
        params.put("typeId", "2");
        NetworkManager.liveListFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {

                LiveListModel liveListModel = (LiveListModel)responseObj;
                Log.d("1","直播回放列表请求成功");
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","直播回放列表请求失败");
            }
        });
    }
}