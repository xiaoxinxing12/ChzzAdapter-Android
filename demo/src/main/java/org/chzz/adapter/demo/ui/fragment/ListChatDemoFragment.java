package org.chzz.adapter.demo.ui.fragment;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import org.chzz.adapter.demo.R;
import org.chzz.adapter.demo.adapter.ListChatAdapter;
import org.chzz.adapter.demo.engine.DataEngine;
import org.chzz.adapter.demo.mode.ChatModel;

/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:15/5/22 10:06
 * 描述:
 */
public class ListChatDemoFragment extends BaseFragment {
    private static final String TAG = ListChatDemoFragment.class.getSimpleName();
    private List<ChatModel> mDatas;
    private ListView mDataLv;
    private ListChatAdapter mAdapter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_listview);
        mDataLv = getViewById(R.id.lv_listview_data);
    }

    @Override
    protected void setListener() {
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mDataLv.setSelector(android.R.color.transparent);
        mDataLv.setDivider(null);
        mAdapter = new ListChatAdapter(mActivity);
        mDatas = DataEngine.loadChatModelDatas();
        mAdapter.setDatas(mDatas);
        mDataLv.setAdapter(mAdapter);
    }

    @Override
    protected void onUserVisible() {
    }
}