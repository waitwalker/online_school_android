package com.etiantian.onlineschoolandroid.modules.mycourse.live.adavance_notice;

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
import com.etiantian.onlineschoolandroid.modules.mycourse.live.play_back.PlayBackLiveListAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdvanceNoticeLiveListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdvanceNoticeLiveListFragment extends Fragment {

    private View root;
    private LiveListGridView liveListGridView;
    String gradeId;
    String subjectId;

    public AdvanceNoticeLiveListFragment(String subjectId, String gradeId) {
        this.subjectId = subjectId;
        this.gradeId = gradeId;
    }

    public static AdvanceNoticeLiveListFragment newInstance(String subjectId, String gradeId) {
        return new AdvanceNoticeLiveListFragment(subjectId, gradeId);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_advance_notice_live_list, container, false);
        liveListGridView = root.findViewById(R.id.advance_notice_grid);
        fetchAdvanceNoticeData();
        return root;
    }

    private void fetchAdvanceNoticeData() {
        RequestParams params = new RequestParams();
        params.put("gradeId", gradeId);
        params.put("subjectId", subjectId);
        params.put("typeId", "2");
        NetworkManager.liveListFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.d("1","获取大师直播预告列表数据成功");
                LiveListModel liveListModel = (LiveListModel) responseObj;
                AdvanceNoticeLiveListAdapter advanceNoticeLiveListAdapter = new AdvanceNoticeLiveListAdapter(getContext(), liveListModel.getData().getList());
                liveListGridView.setAdapter(advanceNoticeLiveListAdapter);
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","获取大师直播预告列表数据失败");
            }
        });
    }

}