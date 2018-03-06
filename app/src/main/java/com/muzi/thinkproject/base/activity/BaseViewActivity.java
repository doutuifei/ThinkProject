package com.muzi.thinkproject.base.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.muzi.thinkproject.utils.CommonUtils;
import com.muzi.thinkproject.widget.CustomLoadMoreView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by muzi on 2017/12/26.
 * 727784430@qq.com
 */

public abstract class BaseViewActivity extends RxActivity {

    protected Context context;
    private Unbinder mUnbinder;
    protected int currePage = 1, totalPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        mUnbinder = ButterKnife.bind(this);
        context = this;
        initView(savedInstanceState);
        initRecyclerView();
        requestData();
    }

    /**
     * 绑定layout
     *
     * @return
     */
    protected abstract int bindLayout();

    /**
     * 初始化UI
     *
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化RecyclerView
     */
    protected void initRecyclerView() {
    }

    /**
     * 加载更多--分页加载
     */
    protected void initLoadMore(RecyclerView recyclerView, BaseQuickAdapter.RequestLoadMoreListener listener) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof BaseQuickAdapter) {
            BaseQuickAdapter quickAdapter = (BaseQuickAdapter) adapter;
            quickAdapter.setLoadMoreView(new CustomLoadMoreView());
            quickAdapter.setOnLoadMoreListener(() -> {
                if (currePage < totalPage) {
                    currePage++;
                    listener.onLoadMoreRequested();
                } else {
                    quickAdapter.loadMoreEnd();
                }
            }, recyclerView);
        }
    }

    /**
     * 请求数据
     */
    protected void requestData() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        //INPUT leaks
        CommonUtils.fixInputMethodManagerLeak(context);
    }
}
