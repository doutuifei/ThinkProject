package com.muzi.thinkproject.base.activity;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;

import com.muzi.thinkproject.R;
import com.muzi.thinkproject.widget.LoadingDialog;


/**
 * Created by muzi on 2017/12/28.
 * 727784430@qq.com
 */

public abstract class BaseUIActivity extends BaseViewActivity {

    private SwipeRefreshLayout refreshLayout;

    protected LoadingDialog loadingDialog;

    /**
     * 初始化刷新
     *
     * @param refreshLayout
     * @param onRefreshListener
     */
    protected void initRefresh(SwipeRefreshLayout refreshLayout, SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        this.refreshLayout = refreshLayout;
        refreshLayout.setColorSchemeColors(ContextCompat.getColor(this, R.color.themeColor));
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
    public void showLoadingView() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(context);
        }
        loadingDialog.show();
    }

    /**
     * 隐藏进度条
     */
    public void hiddenLoadingView() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

}
