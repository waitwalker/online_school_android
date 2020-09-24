package com.etiantian.onlineschoolandroid.modules.mycourse.live;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.etiantian.onlineschoolandroid.R;

import java.util.List;

public class PlayBackLiveListAdapter extends BaseAdapter {

    private Context context;
    private List<LiveListModel.DataBean.ListBean> dataSource;

    PlayBackLiveListAdapter(Context context, List<LiveListModel.DataBean.ListBean> dataSource) {
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
        ViewHolder viewHolder;
        return View.inflate(context, R.layout.play_back_item_layout, null);
    }

    private static class ViewHolder {

    }
}
