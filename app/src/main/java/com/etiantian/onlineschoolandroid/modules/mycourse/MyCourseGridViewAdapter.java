package com.etiantian.onlineschoolandroid.modules.mycourse;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.etiantian.onlineschoolandroid.R;

import java.util.ArrayList;
import java.util.List;

///
/// @description 首页我的课程Grid Adapter 这个相当于Controller
/// @author waitwalker
/// @time 2020/9/9 4:29 PM
///
public class MyCourseGridViewAdapter extends BaseAdapter {

    private Context context;
    /// 数据源
    private List<MyCourseSubjectModel.DataBean> dataSource;

    public MyCourseGridViewAdapter(Context context, List<MyCourseSubjectModel.DataBean> dataSource) {
        this.context = context;
        this.dataSource = dataSource;
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
        ViewHolder viewHolder;
        if (view == null) {
            view = View.inflate(context, R.layout.my_course_grid_item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = view.findViewById(R.id.item_text);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        MyCourseSubjectModel.DataBean itemData = dataSource.get(i);
        viewHolder.textView.setText(itemData.getSubjectName());
        return view;
    }

    private class ViewHolder {
        TextView textView;
    }
}
