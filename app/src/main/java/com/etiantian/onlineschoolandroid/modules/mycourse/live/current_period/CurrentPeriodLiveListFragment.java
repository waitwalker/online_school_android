package com.etiantian.onlineschoolandroid.modules.mycourse.live.current_period;

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
import com.etiantian.onlineschoolandroid.modules.mycourse.live.LiveListGridView;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.LiveListModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrentPeriodLiveListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrentPeriodLiveListFragment extends Fragment {

    private View root;
    private LiveListGridView liveListGridView;

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
        root = inflater.inflate(R.layout.fragment_current_period_live_list, container, false);
        liveListGridView = root.findViewById(R.id.current_period_grid);
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
        params.put("typeId", "0");
        NetworkManager.liveListFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {

                LiveListModel liveListModel = (LiveListModel)responseObj;
                Log.d("1","直播回放列表请求成功");
                CurrentPeriodLiveListAdapter currentPeriodLiveListAdapter = new CurrentPeriodLiveListAdapter(getContext(), liveListModel.getData().getList());
                liveListGridView.setAdapter(currentPeriodLiveListAdapter);
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","直播回放列表请求失败");
            }
        });
    }
}