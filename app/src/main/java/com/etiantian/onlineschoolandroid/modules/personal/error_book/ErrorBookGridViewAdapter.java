package com.etiantian.onlineschoolandroid.modules.personal.error_book;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.etiantian.onlineschoolandroid.R;

import java.util.ArrayList;
import java.util.Map;

public class ErrorBookGridViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Map> dataSource;

    public ErrorBookGridViewAdapter(Context context, ArrayList<Map> dataSource) {
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
            view = View.inflate(context, R.layout.error_book_entrance_card_layout, null);
            viewHolder = new ViewHolder();
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        return view;
    }

    private class ViewHolder {

    }
}
