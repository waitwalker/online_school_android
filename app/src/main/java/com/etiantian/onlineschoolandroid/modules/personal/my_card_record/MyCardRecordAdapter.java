package com.etiantian.onlineschoolandroid.modules.personal.my_card_record;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.etiantian.onlineschoolandroid.R;

import java.util.ArrayList;
import java.util.List;

public class MyCardRecordAdapter extends BaseAdapter {

    private List<MyCardRecordModel.DataBean> dataSources;
    private Context context;

    public MyCardRecordAdapter(List<MyCardRecordModel.DataBean> dataSources, Context context) {
        this.dataSources = dataSources;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataSources.size();
    }

    @Override
    public Object getItem(int i) {
        return dataSources.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        MyCardRecordModel.DataBean dataBean = dataSources.get(i);
        if (view == null) {
            viewHolder = new ViewHolder();
            view = View.inflate(context, R.layout.my_card_record_layout, null);
            viewHolder.cardTitleTextView = view.findViewById(R.id.my_card_title);
            viewHolder.timeTextView = view.findViewById(R.id.my_card_time);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.cardTitleTextView.setText(dataBean.getCourseCardName());
        viewHolder.timeTextView.setText(dataBean.getActivationTime());
        return view;
    }

    private class ViewHolder {
        TextView cardTitleTextView;
        TextView timeTextView;
    }
}
