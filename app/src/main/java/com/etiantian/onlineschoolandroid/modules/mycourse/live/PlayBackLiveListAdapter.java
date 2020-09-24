package com.etiantian.onlineschoolandroid.modules.mycourse.live;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.etiantian.onlineschoolandroid.R;
import com.ruffian.library.widget.RImageView;

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
        if (view == null) {
            viewHolder = new ViewHolder();
            view = View.inflate(context, R.layout.play_back_item_layout, null);
            viewHolder.titleTextView = view.findViewById(R.id.title_textview);
            viewHolder.timeTextView = view.findViewById(R.id.time_textview);
            viewHolder.avatarImageView = view.findViewById(R.id.avatar_imageview);
            viewHolder.teacherTextView = view.findViewById(R.id.teacher_textview);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        LiveListModel.DataBean.ListBean bean = dataSource.get(i);
        viewHolder.titleTextView.setText(bean.getCourseName());
        viewHolder.timeTextView.setText(bean.getStartTime());
        Glide.with(context).load(bean.getTeacherPic()).into(viewHolder.avatarImageView);
        viewHolder.teacherTextView.setText(bean.getTeacherName());
        return view;
    }

    private static class ViewHolder {
        TextView titleTextView;
        TextView timeTextView;
        RImageView avatarImageView;
        TextView teacherTextView;
    }
}
