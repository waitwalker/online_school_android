package com.etiantian.onlineschoolandroid.modules.mycourse.live.current_period;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseDelegateMultiAdapter;
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.modules.common_tools.CommonWebViewActivity;
import com.etiantian.onlineschoolandroid.modules.common_tools.VideoPlayActivity;
import com.etiantian.onlineschoolandroid.modules.common_tools.VideoURLModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.LiveListModel;
import com.google.gson.Gson;
import com.ruffian.library.widget.RImageView;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class CurrentPeriodLiveDelegateMultiAdapter extends BaseDelegateMultiAdapter<LiveListModel.DataBean.ListBean, BaseViewHolder> {
    private Context context;
    public CurrentPeriodLiveDelegateMultiAdapter(Context context) {
        super();
        this.context = context;
        // 方式一，使用匿名内部类，进行如下两步：
        // 第一步，设置代理
        setMultiTypeDelegate(new BaseMultiTypeDelegate<LiveListModel.DataBean.ListBean>() {
            @Override
            public int getItemType(@NotNull List<? extends LiveListModel.DataBean.ListBean> data, int position) {
                LiveListModel.DataBean.ListBean currentBean = data.get(position);
                /// 直播结束
                if (currentBean.getStateId() == 2) {
                    if (currentBean.getHdResourceId() > 1) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    return 2;
                }
            }
        });
        // 第二步，绑定 item 类型
        Objects.requireNonNull(getMultiTypeDelegate())
                .addItemType(0, R.layout.current_period_three_item_layout)
                .addItemType(1, R.layout.current_period_two_item_layout)
                .addItemType(2, R.layout.current_period_live_item_layout);

    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, @NotNull final LiveListModel.DataBean.ListBean bean) {
        switch (viewHolder.getItemViewType()) {
            case 0:
                Log.d("1","有网校回放type:" + viewHolder.getItemViewType());
                TextView title_textview = viewHolder.findView(R.id.title_textview);
                title_textview.setText(bean.getCourseName());
                TextView timeTextView = viewHolder.findView(R.id.time_textview);
                timeTextView.setText(bean.getStartTime());
                RImageView imageView = viewHolder.findView(R.id.avatar_imageview);
                Glide.with(context).load(bean.getTeacherPic()).into(imageView);
                ViewGroup download_relative = viewHolder.findView(R.id.download_relative);
                download_relative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fetchVideoURL(bean, true);
                    }
                });

                ViewGroup playback_relative = viewHolder.findView(R.id.playback_relative);
                playback_relative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fetchVideoURL(bean, false);
                    }
                });

                ViewGroup homework_relative = viewHolder.findView(R.id.homework_relative);
                homework_relative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (bean.getWorkStatus() == 1) {
                            String token = "token=" + NetworkManager.getToken();
                            String courseId = "livecourseid=" + bean.getCourseId();
                            String fullUrl = NetworkManager.HttpConstants.Homework_HTML + token + "&"+ "&" + courseId;
                            Intent intent = new Intent(context, CommonWebViewActivity.class);
                            intent.putExtra("url", fullUrl);
                            intent.putExtra("title",bean.getCourseName());
                            context.startActivity(intent);
                        } else if (bean.getWorkStatus() == 2){
                            Toast.makeText(context, "作业未开始",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(context, "没有作业",Toast.LENGTH_LONG).show();
                        }
                    }
                });

                break;
            case 1:
                Log.d("1","没有网校回放type:" + viewHolder.getItemViewType());
                break;
            case 2:
                Log.d("1","直播type:" + viewHolder.getItemViewType());
                break;
            default:
                break;
        }
    }

    private void fetchVideoURL(LiveListModel.DataBean.ListBean bean, final boolean download) {
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
            NetworkManager.videoURLFetch(params, new NormalResponseCallBack() {
                @Override
                public void onSuccess(Object responseObj) {
                    VideoURLModel videoURLModel = (VideoURLModel) responseObj;
                    Log.d("1","获取视频URL成功");
                    if (download) {
                        Toast.makeText(context, "已下载",Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent = new Intent(context, VideoPlayActivity.class);
                        String json = new Gson().toJson(videoURLModel);
                        intent.putExtra("videoURLModel", json);
                        context.startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Object responseObj) {
                    Log.d("1","获取视频URL失败");
                }
            });
        }

    }
}
