package com.muzi.thinkproject.base.fragment;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;

import com.muzi.thinkproject.R;
import com.muzi.thinkproject.base.activity.BaseUIActivity;


/**
 * Created by muzi on 2017/12/27.
 * 727784430@qq.com
 */

public abstract class BaseUIFragment extends BaseViewFragment {

    private SwipeRefreshLayout refreshLayout;

    /**
     * 初始化刷新
     *
     * @param refreshLayout
     * @param onRefreshListener
     */
    protected void initRefresh(SwipeRefreshLayout refreshLayout, SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        this.refreshLayout = refreshLayout;
        refreshLayout.setColorSchemeColors(ContextCompat.getColor(getActivity(), R.color.themeColor));
        refreshLayout.setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.white));
        refreshLayout.setOnRefreshListener(onRefreshListener);
    }

    /**
     * 取消刷新
     */
    public void refreshFinish() {
        if (refreshLayout != null && refreshLayout.isRefreshing()) {
            refreshLayout.setRefreshing(false);
        }
    }

    /**
     * 显示进度条
     */
    protected void showLoadingView() {
        ((BaseUIActivity) context).showLoadingView();
    }

    /**
     * 隐藏进度条
     */
    protected void hiddenLoadingView() {
        ((BaseUIActivity) context).hiddenLoadingView();
    }
}
