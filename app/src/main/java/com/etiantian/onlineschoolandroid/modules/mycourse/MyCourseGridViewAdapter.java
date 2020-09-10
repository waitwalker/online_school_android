package com.etiantian.onlineschoolandroid.modules.mycourse;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import com.etiantian.onlineschoolandroid.R;

import java.util.List;

///
/// @description 首页我的课程Grid Adapter 这个相当于Controller
/// @author waitwalker
/// @time 2020/9/9 4:29 PM
///
public class MyCourseGridViewAdapter extends BaseAdapter {

    private Context context;
    /// 数据源
    private List<MyCourseSubjectModel.DataBean> dataSource;

    public MyCourseGridViewAdapter(Context context, List<MyCourseSubjectModel.DataBean> dataSource) {
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
            view = View.inflate(context, R.layout.my_course_grid_item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.relativeLayout = view.findViewById(R.id.item_container);
            viewHolder.textView = view.findViewById(R.id.item_text);
            viewHolder.iconImageView = view.findViewById(R.id.item_image);
            viewHolder.grade_container_relative = view.findViewById(R.id.grade_container_relative);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        MyCourseSubjectModel.DataBean itemData = dataSource.get(i);

        for (int j =0; j < itemData.getGrades().size(); j++) {

        }
        viewHolder.textView.setText(itemData.getSubjectName());
        switch (itemData.getSubjectId()) {
            case 1:
                viewHolder.relativeLayout.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.language_background_shape, null));
                viewHolder.iconImageView.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.language_bitmap, null));
            break;
            case 2:
                viewHolder.relativeLayout.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.math_background_shape, null));
                viewHolder.iconImageView.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.math_bitmap, null));
                break;
            case 3:
                viewHolder.relativeLayout.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.english_background_shape, null));
                viewHolder.iconImageView.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.english_bitmap, null));
                break;
            case 4:
                viewHolder.relativeLayout.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.physics_background_shape, null));
                viewHolder.iconImageView.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.physics_bitmap, null));
                break;
            case 5:
                viewHolder.relativeLayout.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.chemistry_background_shape, null));
                viewHolder.iconImageView.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.chemistry_bitmap, null));
                break;
            case 6:
                viewHolder.relativeLayout.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.history_background_shape, null));
                viewHolder.iconImageView.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.history_bitmap, null));
                break;
            case 7:
                viewHolder.relativeLayout.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.biology_background_shape, null));
                viewHolder.iconImageView.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.biology_bitmap, null));
                break;
            case 8:
                viewHolder.relativeLayout.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.geography_background_shape, null));
                viewHolder.iconImageView.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.geography_bitmap, null));
                break;
            case 9:
                viewHolder.relativeLayout.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.politics_background_shape, null));
                viewHolder.iconImageView.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.politics_bitmap, null));
                break;
            case 10:
                viewHolder.relativeLayout.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.science_background_shape, null));
                viewHolder.iconImageView.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.science_bitmap, null));
                break;
        }
        return view;
    }

    private class ViewHolder {
        TextView textView;
        RelativeLayout relativeLayout;
        ImageView iconImageView;
        RelativeLayout grade_container_relative;
    }
}
