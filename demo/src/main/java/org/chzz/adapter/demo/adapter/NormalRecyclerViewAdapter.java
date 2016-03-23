package org.chzz.adapter.demo.adapter;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;
import android.view.View;

import com.bumptech.glide.Glide;

import org.chzz.adapter.CHZZRecyclerViewAdapter;
import org.chzz.adapter.CHZZViewHolderHelper;
import org.chzz.adapter.demo.R;
import org.chzz.adapter.demo.mode.NormalModel;

/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:15/5/22 16:31
 * 描述:
 */
public class NormalRecyclerViewAdapter extends CHZZRecyclerViewAdapter<NormalModel> {
    private ItemTouchHelper mItemTouchHelper;
    private boolean mIsIgnoreChange = true;

    public NormalRecyclerViewAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.item_normal);
    }

    public void setItemTouchHelper(ItemTouchHelper itemTouchHelper) {
        mItemTouchHelper = itemTouchHelper;
    }

    @Override
    public void setItemChildListener(final CHZZViewHolderHelper viewHolderHelper) {
        viewHolderHelper.setItemChildClickListener(R.id.tv_item_normal_delete);
        viewHolderHelper.setItemChildLongClickListener(R.id.tv_item_normal_delete);
        viewHolderHelper.setItemChildCheckedChangeListener(R.id.cb_item_normal_status);
        viewHolderHelper.getView(R.id.iv_item_normal_avator).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mItemTouchHelper.startDrag(viewHolderHelper.getRecyclerViewHolder());
                }
                return false;
            }
        });
    }

    @Override
    public void fillData(CHZZViewHolderHelper viewHolderHelper, int position, NormalModel model) {
        Glide.with(mContext).load(model.avatorPath).placeholder(R.mipmap.holder).error(R.mipmap.holder).into(viewHolderHelper.getImageView(R.id.iv_item_normal_avator));
        viewHolderHelper.setText(R.id.tv_item_normal_title, model.title).setText(R.id.tv_item_normal_detail, model.detail);

        // 在设置值的过程中忽略选中状态变化
        mIsIgnoreChange = true;
        viewHolderHelper.setChecked(R.id.cb_item_normal_status, model.selected);
        mIsIgnoreChange = false;
    }

    public boolean isIgnoreChange() {
        return mIsIgnoreChange;
    }
}