package org.chzz.adapter.demo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.chzz.adapter.CHZZRecyclerViewAdapter;
import org.chzz.adapter.CHZZViewHolderHelper;
import org.chzz.adapter.demo.R;
import org.chzz.adapter.demo.mode.IndexModel;

/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:15/5/22 16:31
 * 描述:
 */
public class RecyclerIndexAdapter extends CHZZRecyclerViewAdapter<IndexModel> {
    public RecyclerIndexAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.item_indexview);
    }

    @Override
    public void setItemChildListener(CHZZViewHolderHelper viewHolderHelper) {
        viewHolderHelper.setItemChildClickListener(R.id.tv_item_indexview_name);
    }

    @Override
    public void fillData(CHZZViewHolderHelper viewHolderHelper, int position, IndexModel model) {
        int section = getSectionForPosition(position);
        if (position == getPositionForSection(section)) {
            viewHolderHelper.setVisibility(R.id.tv_item_indexview_catalog, View.VISIBLE);
            viewHolderHelper.setText(R.id.tv_item_indexview_catalog, model.topc);
        } else {
            viewHolderHelper.setVisibility(R.id.tv_item_indexview_catalog, View.GONE);
        }
        viewHolderHelper.setText(R.id.tv_item_indexview_name, model.name);
    }

    public int getSectionForPosition(int position) {
        return mDatas.get(position).topc.charAt(0);
    }

    public int getPositionForSection(int section) {
        for (int i = 0; i < getItemCount(); i++) {
            String sortStr = mDatas.get(i).topc;
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }
}