package org.chzz.adapter.demo.adapter;

import android.content.Context;
import android.view.View;

import org.chzz.adapter.CHZZAdapterViewAdapter;
import org.chzz.adapter.CHZZViewHolderHelper;
import org.chzz.adapter.demo.R;
import org.chzz.adapter.demo.mode.IndexModel;

/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:15/5/21 上午12:39
 * 描述:
 */
public class ListIndexAdapter extends CHZZAdapterViewAdapter<IndexModel> {

    public ListIndexAdapter(Context context) {
        super(context, R.layout.item_indexview);
    }

    @Override
    protected void setItemChildListener(CHZZViewHolderHelper viewHolderHelper) {
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
        for (int i = 0; i < getCount(); i++) {
            String sortStr = mDatas.get(i).topc;
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }
}