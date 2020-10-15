package com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.modules.common_tools.CommonWebViewActivity;
import com.etiantian.onlineschoolandroid.modules.common_tools.PDFReaderActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.ai_test.AITestListActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.current_period.MaterialPackageAdapter;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.current_period.MaterialPackageModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.subject_detail.ResourceInfoModel;

import java.util.List;

public class KnowledgeGuideAdapter extends BaseAdapter {

    private Context context;
    private List<KnowledgeGuideModel.DataBean> dataSource;

    KnowledgeGuideAdapter(Context context, List<KnowledgeGuideModel.DataBean> dataSource) {
        this.dataSource = dataSource;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return dataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final KnowledgeGuideModel.DataBean bean = dataSource.get(i);
        KnowledgeGuideAdapter.ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new KnowledgeGuideAdapter.ViewHolder();
            view = View.inflate(context, R.layout.material_package_item_layout, null);
            viewHolder.container_relative = view.findViewById(R.id.container_relative);
            viewHolder.titleView = view.findViewById(R.id.title_view);
            view.setTag(viewHolder);

        } else {
            viewHolder = (KnowledgeGuideAdapter.ViewHolder) view.getTag();
        }
        viewHolder.titleView.setText(bean.getResName());
        viewHolder.container_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestParams params = new RequestParams();
                params.put("resourceId", String.valueOf(bean.getResId()));
                fetchResourceInfo(params);
            }
        });
        return view;
    }

    ///
    /// @description 获取资源信息数据
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/10/12 2:14 PM
    ///
    private void fetchResourceInfo(RequestParams params) {
        NetworkManager.resourceInfoFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                ResourceInfoModel resourceInfoModel = (ResourceInfoModel) responseObj;
                Intent intent = new Intent(context, PDFReaderActivity.class);
                String url = resourceInfoModel.getData().getLiteratureDownUrl();
                intent.putExtra("url", url);
                intent.putExtra("title", resourceInfoModel.getData().getResourceName());
                context.startActivity(intent);
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","获取微课视频数据失败");
            }
        });
    }

    /// 缓存卡片布局
    /// 没有回放类型卡片:这个回放用cc
    private static class ViewHolder {
        ViewGroup container_relative;
        TextView titleView;
    }
}
