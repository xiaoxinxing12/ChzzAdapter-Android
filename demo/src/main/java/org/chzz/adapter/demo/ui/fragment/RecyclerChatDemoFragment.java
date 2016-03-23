package org.chzz.adapter.demo.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.chzz.adapter.demo.R;
import org.chzz.adapter.demo.adapter.RecyclerChatAdapter;
import org.chzz.adapter.demo.engine.DataEngine;
import org.chzz.adapter.demo.mode.ChatModel;

import java.util.List;

/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:15/5/22 10:06
 * 描述:
 */
public class RecyclerChatDemoFragment extends BaseFragment {
    private static final String TAG = RecyclerChatDemoFragment.class.getSimpleName();
    private RecyclerChatAdapter mAdapter;
    private List<ChatModel> mDatas;
    private RecyclerView mDataRv;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_recyclerview);
        mDataRv = getViewById(R.id.rv_recyclerview_data);
    }

    @Override
    protected void setListener() {
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mDataRv.setLayoutManager(layoutManager);

        mAdapter = new RecyclerChatAdapter(mDataRv);

        mDatas = DataEngine.loadChatModelDatas();
        mAdapter.setDatas(mDatas);
        mDataRv.setAdapter(mAdapter);
    }

    @Override
    protected void onUserVisible() {
    }
}