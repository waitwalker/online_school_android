package com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.modules.common_tools.PDFReaderActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.current_period.MaterialPackageAdapter;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.current_period.MaterialPackageModel;

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
//                Intent intent = new Intent(context, PDFReaderActivity.class);
//                String url = bean.getFileUrl();
//                intent.putExtra("url", url);
//                intent.putExtra("title", bean.getName());
//                context.startActivity(intent);
            }
        });
        return view;
    }

    /// 缓存卡片布局
    /// 没有回放类型卡片:这个回放用cc
    private static class ViewHolder {
        ViewGroup container_relative;
        TextView titleView;
    }
}
