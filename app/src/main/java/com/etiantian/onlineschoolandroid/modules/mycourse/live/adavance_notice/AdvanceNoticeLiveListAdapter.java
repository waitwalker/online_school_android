package com.etiantian.onlineschoolandroid.modules.mycourse.live.adavance_notice;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.modules.common_tools.CommonWebViewActivity;
import com.etiantian.onlineschoolandroid.modules.common_tools.VideoPlayActivity;
import com.etiantian.onlineschoolandroid.modules.common_tools.VideoURLModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.LiveListModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.play_back.PlayBackLiveListAdapter;
import com.google.gson.Gson;
import com.ruffian.library.widget.RImageView;

import java.util.List;

public class AdvanceNoticeLiveListAdapter extends BaseAdapter {
    private Context context;
    private List<LiveListModel.DataBean.ListBean> dataSource;

    AdvanceNoticeLiveListAdapter(Context context, List<LiveListModel.DataBean.ListBean> dataSource) {
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
        AdvanceNoticeLiveListAdapter.ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new AdvanceNoticeLiveListAdapter.ViewHolder();
            view = View.inflate(context, R.layout.advance_notice_layout, null);
            viewHolder.titleTextView = view.findViewById(R.id.title_textview);
            viewHolder.timeTextView = view.findViewById(R.id.time_textview);
            viewHolder.avatarImageView = view.findViewById(R.id.avatar_imageview);
            viewHolder.teacherTextView = view.findViewById(R.id.teacher_textview);
            viewHolder.unstartButton = view.findViewById(R.id.unstart_button);
            viewHolder.container = view.findViewById(R.id.advance_container_relative);
            view.setTag(viewHolder);
        } else {
            viewHolder = (AdvanceNoticeLiveListAdapter.ViewHolder) view.getTag();
        }
        final LiveListModel.DataBean.ListBean bean = dataSource.get(i);
        viewHolder.titleTextView.setText(bean.getCourseName());
        viewHolder.timeTextView.setText(bean.getStartTime());
        Glide.with(context).load(bean.getTeacherPic()).into(viewHolder.avatarImageView);
        viewHolder.teacherTextView.setText(bean.getTeacherName());

        viewHolder.unstartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "精彩马上开始!", Toast.LENGTH_LONG).show();
            }
        });

        viewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "精彩马上开始!", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    private static class ViewHolder {
        TextView titleTextView;
        TextView timeTextView;
        RImageView avatarImageView;
        TextView teacherTextView;
        Button unstartButton;
        ViewGroup container;
    }
}
