package org.chzz.adapter.demo.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.GridView;

import org.chzz.adapter.CHZZOnItemChildCheckedChangeListener;
import org.chzz.adapter.CHZZOnItemChildClickListener;
import org.chzz.adapter.CHZZOnItemChildLongClickListener;
import org.chzz.adapter.demo.App;
import org.chzz.adapter.demo.R;
import org.chzz.adapter.demo.adapter.NormalAdapterViewAdapter;
import org.chzz.adapter.demo.engine.ApiEngine;
import org.chzz.adapter.demo.mode.NormalModel;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:15/6/28 下午12:34
 * 描述:
 */
public class GridViewDemoFragment extends BaseFragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, CHZZOnItemChildClickListener, CHZZOnItemChildLongClickListener, CHZZOnItemChildCheckedChangeListener {
    private static final String TAG = GridViewDemoFragment.class.getSimpleName();
    private GridView mDataGv;
    private NormalAdapterViewAdapter mAdapter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_gridview);
        mDataGv = getViewById(R.id.lv_gridview_data);
    }

    @Override
    protected void setListener() {
        mDataGv.setOnItemClickListener(this);
        mDataGv.setOnItemLongClickListener(this);

        mAdapter = new NormalAdapterViewAdapter(mActivity);
        mAdapter.setOnItemChildClickListener(this);
        mAdapter.setOnItemChildLongClickListener(this);
        mAdapter.setOnItemChildCheckedChangeListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mDataGv.setAdapter(mAdapter);
    }

    @Override
    protected void onUserVisible() {
        App.getInstance().getRetrofit().create(ApiEngine.class).getNormalModels().enqueue(new Callback<List<NormalModel>>() {
            @Override
            public void onResponse(Response<List<NormalModel>> response, Retrofit retrofit) {
                mAdapter.setDatas(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                showSnackbar("数据加载失败");
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showSnackbar("点击了条目 " + mAdapter.getItem(position).title);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        showSnackbar("长按了条目 " + mAdapter.getItem(position).title);
        return true;
    }

    @Override
    public void onItemChildClick(ViewGroup parent, View childView, int position) {
        if (childView.getId() == R.id.tv_item_normal_delete) {
            mAdapter.removeItem(position);
        }
    }

    @Override
    public boolean onItemChildLongClick(ViewGroup parent, View childView, int position) {
        if (childView.getId() == R.id.tv_item_normal_delete) {
            showSnackbar("长按了删除 " + mAdapter.getItem(position).title);
            return true;
        }
        return false;
    }

    @Override
    public void onItemChildCheckedChanged(ViewGroup parent, CompoundButton childView, int position, boolean isChecked) {
        // 在填充数据列表时，忽略选中状态变化
        if (!mAdapter.isIgnoreChange()) {
            mAdapter.getItem(position).selected = isChecked;
            if (isChecked) {
                showSnackbar("选中 " + mAdapter.getItem(position).title);
            } else {
                showSnackbar("取消选中 " + mAdapter.getItem(position).title);
            }
        }
    }
}