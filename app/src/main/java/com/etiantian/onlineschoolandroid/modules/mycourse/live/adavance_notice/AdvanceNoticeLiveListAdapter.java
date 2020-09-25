package com.etiantian.onlineschoolandroid.modules.mycourse.live.adavance_notice;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
            view = View.inflate(context, R.layout.play_back_item_layout, null);
            viewHolder.titleTextView = view.findViewById(R.id.title_textview);
            viewHolder.timeTextView = view.findViewById(R.id.time_textview);
            viewHolder.avatarImageView = view.findViewById(R.id.avatar_imageview);
            viewHolder.teacherTextView = view.findViewById(R.id.teacher_textview);
            viewHolder.download_relative = view.findViewById(R.id.download_relative);
            viewHolder.playback_relative = view.findViewById(R.id.playback_relative);
            view.setTag(viewHolder);
        } else {
            viewHolder = (AdvanceNoticeLiveListAdapter.ViewHolder) view.getTag();
        }
        final LiveListModel.DataBean.ListBean bean = dataSource.get(i);
        viewHolder.titleTextView.setText(bean.getCourseName());
        viewHolder.timeTextView.setText(bean.getStartTime());
        Glide.with(context).load(bean.getTeacherPic()).into(viewHolder.avatarImageView);
        viewHolder.teacherTextView.setText(bean.getTeacherName());
        viewHolder.download_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("1","大师直播回放页面中的下载按钮被点击");
            }
        });

        viewHolder.playback_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /// 使用cc网页回放 正常应该 < 1
                if (bean.getHdResourceId() < 1) {
                    String token = "token=" + NetworkManager.getToken();
                    String rcourseid = "rcourseid=" + bean.getLiveCourseId();
                    String ocourseId = "ocourseId=" + bean.getCourseId();
                    String roomid = "roomid=" + bean.getPartnerRoomId();
                    String fullUrl = NetworkManager.HttpConstants.CC_PlayBack_HTML + token + "&"+ rcourseid + "&" + ocourseId + "&" + roomid ;
                    Intent intent = new Intent(context, CommonWebViewActivity.class);
                    intent.putExtra("url", fullUrl);
                    intent.putExtra("title","直播回放");
                    context.startActivity(intent);
                } else {
                    // 使用原生播放器
                    RequestParams params = new RequestParams();
                    params.put("onlineCourseId", String.valueOf(bean.getCourseId()));
                    fetchVideoURL(params);
                }



            }
        });
        return view;
    }

    private static class ViewHolder {
        TextView titleTextView;
        TextView timeTextView;
        RImageView avatarImageView;
        TextView teacherTextView;
        ViewGroup download_relative;
        ViewGroup playback_relative;
    }

    private void fetchVideoURL(RequestParams params) {
        NetworkManager.videoURLFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                VideoURLModel videoURLModel = (VideoURLModel) responseObj;
                Log.d("1","获取视频URL成功");
                Intent intent = new Intent(context, VideoPlayActivity.class);
                String json = new Gson().toJson(videoURLModel);
                intent.putExtra("videoURLModel", json);
                context.startActivity(intent);
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","获取视频URL失败");
            }
        });
    }
}
