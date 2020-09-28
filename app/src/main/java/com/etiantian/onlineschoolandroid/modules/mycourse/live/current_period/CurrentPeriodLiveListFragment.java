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
import android.widget.Button;
import android.widget.Toast;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.modules.mycourse.activity_course.ImageAlertCallBack;
import com.etiantian.onlineschoolandroid.modules.mycourse.activity_course.ImageDialogAlert;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.LiveListModel;
import com.wang.avi.AVLoadingIndicatorView;

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
    CurrentPeriodLiveDelegateMultiAdapter currentPeriodLiveDelegateMultiAdapter;
    ViewGroup current_page;
    AVLoadingIndicatorView loadingIndicatorView;
    String gradeId;
    String subjectId;

    /// 班级二维码
    Button classQRCodeButton;
    /// 资料包
    Button materialButton;

    public CurrentPeriodLiveListFragment(String subjectId, String gradeId) {
        this.subjectId = subjectId;
        this.gradeId = gradeId;
    }

    public static CurrentPeriodLiveListFragment newInstance(String subjectId, String gradeId) {
        return new CurrentPeriodLiveListFragment(subjectId, gradeId);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        currentPeriodLiveDelegateMultiAdapter = new CurrentPeriodLiveDelegateMultiAdapter(getContext());
        root = inflater.inflate(R.layout.fragment_current_period_live_list, container, false);
        current_page = root.findViewById(R.id.current_period_page);
        current_page.setVisibility(View.INVISIBLE);
        loadingIndicatorView = root.findViewById(R.id.loading);
        loadingIndicatorView.setVisibility(View.VISIBLE);
        recyclerView = root.findViewById(R.id.current_period_grid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(currentPeriodLiveDelegateMultiAdapter);
        classQRCodeButton = root.findViewById(R.id.class_qrcode_button);
        materialButton = root.findViewById(R.id.material_button);
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
        params.put("gradeId", gradeId);
        params.put("subjectId", subjectId);
        params.put("typeId", "0");
        NetworkManager.liveListFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {

                final LiveListModel liveListModel = (LiveListModel)responseObj;
                Log.d("1","直播回放列表请求成功");
                currentPeriodLiveDelegateMultiAdapter.setList(liveListModel.getData().getList());
                loadingIndicatorView.setVisibility(View.INVISIBLE);
                current_page.setVisibility(View.VISIBLE);
                classQRCodeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final ImageDialogAlert dialogAlert = new ImageDialogAlert.Builder(getContext(), new ImageAlertCallBack() {
                            @Override
                            public void imageClickAction() {
                                Log.d("1","点击了图片弹出框");
                                Toast.makeText(getContext(), "二维码已保存到相册!", Toast.LENGTH_LONG).show();
                            }
                        }).setImage(liveListModel.getData().getClassCode()).create();
                        dialogAlert.show();
                    }
                });

                materialButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","直播回放列表请求失败");
            }
        });
    }
}