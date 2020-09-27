package com.etiantian.onlineschoolandroid.modules.mycourse.live.current_period;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.LiveListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrentPeriodLiveListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrentPeriodLiveListFragment extends Fragment {

    private View root;
    private RecyclerView recyclerView;
    CurrentPeriodLiveDelegateMultiAdapter currentPeriodLiveDelegateMultiAdapter = new CurrentPeriodLiveDelegateMultiAdapter(getContext());

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
        recyclerView = root.findViewById(R.id.current_period_grid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(currentPeriodLiveDelegateMultiAdapter);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fetchPlayBackData();
        super.onViewCreated(view, savedInstanceState);
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
                currentPeriodLiveDelegateMultiAdapter.setList(liveListModel.getData().getList());
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","直播回放列表请求失败");
            }
        });
    }
}