package com.etiantian.onlineschoolandroid.modules.mycourse.change_material;

import android.content.Context;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ChangeMaterialVersionAdapter extends BaseNodeAdapter {

    private Context context;

    public ChangeMaterialVersionAdapter(Context context) {
        this.context = context;
    }

    @Override
    protected int getItemType(@NotNull List<? extends BaseNode> list, int i) {
        return 0;
    }
}
