package com.etiantian.onlineschoolandroid.modules.mycourse.live.current_period;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.etiantian.onlineschoolandroid.R;

import org.w3c.dom.Text;

import java.util.List;

public class MaterialPackageAdapter extends BaseAdapter {
    private Context context;
    private List<MaterialPackageModel.DataBean> dataSource;

    MaterialPackageAdapter(Context context, List<MaterialPackageModel.DataBean> dataSource) {
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

        final MaterialPackageModel.DataBean bean = dataSource.get(i);
        MaterialPackageAdapter.ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new MaterialPackageAdapter.ViewHolder();
            view = View.inflate(context, R.layout.material_package_item_layout, null);
            viewHolder.container_relative = view.findViewById(R.id.container_relative);
            viewHolder.titleView = view.findViewById(R.id.title_view);
            view.setTag(viewHolder);

        } else {
            viewHolder = (MaterialPackageAdapter.ViewHolder) view.getTag();
        }
        viewHolder.titleView.setText(bean.getName());
        viewHolder.container_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
