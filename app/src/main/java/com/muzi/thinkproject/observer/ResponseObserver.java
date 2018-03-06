package com.muzi.thinkproject.observer;

import android.content.Context;

import com.neisha.ppzu.entity.BaseEntity;
import com.neisha.ppzu.utils.StringUtils;
import com.neisha.ppzu.utils.ToastUtils;
import com.neisha.ppzu.view.widget.NoNetFrameLayout;

import java.util.Date;

import retrofit2.Response;

/**
 * Created by muzi on 2018/3/5.
 * 727784430@qq.com
 */
public abstract class ResponseObserver<T> extends BaseObserver<Response<T>> {

    private Context context;
    private Date date;
    private T t;

    public ResponseObserver(Context context) {
        super(context);
        this.context = context;
    }

    public ResponseObserver(Context context, boolean showLoadView) {
        super(context, showLoadView);
        this.context = context;
    }

    public ResponseObserver(Context context, NoNetFrameLayout noNetFrameLayout) {
        super(context, noNetFrameLayout);
        this.context = context;
    }

    public ResponseObserver(Context context, boolean showLoadView, NoNetFrameLayout noNetFrameLayout) {
        super(context, showLoadView, noNetFrameLayout);
        this.context = context;
    }

    @Override
    public final void onNext(Response<T> tResponse) {
        super.onNext(tResponse);
        onSuccess(tResponse);
        t = tResponse.body();
        date = tResponse.headers().getDate("Date");
        onNext(t, date);
    }

    protected void onNext(T t, Date date) {
    }

    @Override
    protected void onSuccess(Response<T> tResponse) {
        super.onSuccess(tResponse);
    }

    @Override
    protected void onError(BaseEntity t) {
        super.onError(t);
        if (!StringUtils.isEmpty(t.getMsg()) && isShowToast()) {
            ToastUtils.showToast(context, t.getMsg());
        }
    }
}
