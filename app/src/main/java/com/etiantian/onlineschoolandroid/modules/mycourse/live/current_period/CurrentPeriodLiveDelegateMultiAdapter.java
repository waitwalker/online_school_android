package com.etiantian.onlineschoolandroid.modules.mycourse.live.current_period;

import android.content.Context;
import android.util.Log;

import com.chad.library.adapter.base.BaseDelegateMultiAdapter;
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.modules.mycourse.live.LiveListModel;

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
    protected void convert(@NotNull BaseViewHolder viewHolder, @NotNull LiveListModel.DataBean.ListBean bean) {
        switch (viewHolder.getItemViewType()) {
            case 0:
                Log.d("1","有网校回放type:" + viewHolder.getItemViewType());
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
}
