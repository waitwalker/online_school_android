package com.etiantian.onlineschoolandroid.modules.personal.error_book;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.modules.common_tools.CommonWebViewActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.WisdomListActivity;

import java.util.ArrayList;
import java.util.List;

public class ErrorBookSubjectListAdapter extends BaseAdapter {

    private List <ErrorBookSubjectListModel.DataBean> dataBeans;
    private Context context;

    public ErrorBookSubjectListAdapter(List<ErrorBookSubjectListModel.DataBean> dataBeans, Context context) {
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
        ViewHolder viewHolder;
        final ErrorBookSubjectListModel.DataBean dataBean = dataBeans.get(i);
        if (view == null) {
            view = View.inflate(context, R.layout.error_book_subject_list_item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.container = view.findViewById(R.id.subject_item_container);
            viewHolder.subjectTitle = view.findViewById(R.id.subject_title);
            viewHolder.subjectCount = view.findViewById(R.id.subject_count);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.subjectTitle.setText(dataBean.getSubjectName());
        viewHolder.subjectCount.setText(String.valueOf(dataBean.getCnt()));
        viewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CommonWebViewActivity.class);
                String url = NetworkManager.HttpConstants.Web_Error_Book_URL + "&subjectid=" + dataBean.getSubjectId();
                intent.putExtra("url", url);
                intent.putExtra("title", dataBean.getSubjectName());
                intent.putExtra("showAnswerCard", false);
                context.startActivity(intent);
            }
        });
        return view;
    }

    private static class ViewHolder {
        ViewGroup container;
        TextView subjectTitle;
        TextView subjectCount;
    }
}
