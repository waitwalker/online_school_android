package com.etiantian.onlineschoolandroid.modules.personal.error_book;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ErrorBookSubjectListAdapter extends BaseAdapter {

    private ArrayList <ErrorBookSubjectListModel.DataBean> dataBeans;
    private Context context;

    public ErrorBookSubjectListAdapter(ArrayList<ErrorBookSubjectListModel.DataBean> dataBeans, Context context) {
        this.dataBeans = dataBeans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return dataBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
