package com.etiantian.onlineschoolandroid.modules.personal.my_card_record;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
        return null;
    }

    private class ViewHolder {
        TextView cardTitleTextView;
        TextView timeTextView;
    }
}
