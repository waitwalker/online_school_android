package com.etiantian.onlineschoolandroid.modules.personal.error_book;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

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
        Map map = dataSource.get(i);
        if (view == null) {
            view = View.inflate(context, R.layout.error_book_entrance_card_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.card_image);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final String type = (String) map.get("type");
        // type: 1系统, 2上传, 3数校, 4单元质检
        viewHolder.imageView.setImageResource(
                        type.equals("1") ? R.mipmap.errorbook_xitongcuoti :
                        type.equals("2") ? R.mipmap.errorbook_shangchuancuoti :
                        type.equals("3") ? R.mipmap.errorbook_xiaoyuancuoti : R.mipmap.errorbook_unit_test) ;
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type.equals("1")) {
                    Toast.makeText(context, "系统错题", Toast.LENGTH_SHORT).show();
                } else if (type.equals("2")) {
                    Toast.makeText(context, "上传错题", Toast.LENGTH_SHORT).show();
                } else if (type.equals("3")) {
                    Toast.makeText(context, "数校错题", Toast.LENGTH_SHORT).show();
                } else if (type.equals("4")) {
                    Toast.makeText(context, "质检消错错题", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private class ViewHolder {
        ImageView imageView;
    }
}
