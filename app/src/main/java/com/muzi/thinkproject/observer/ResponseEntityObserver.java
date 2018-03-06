package com.muzi.thinkproject.observer;

import android.content.Context;
import android.content.Intent;

import com.neisha.ppzu.entity.BaseEntity;
import com.neisha.ppzu.network.ErrorCode;
import com.neisha.ppzu.ui.login.LoginActivity;
import com.neisha.ppzu.utils.ToastUtils;
import com.neisha.ppzu.utils.UserInfoUtils;
import com.neisha.ppzu.view.widget.NoNetFrameLayout;

import java.util.Date;

import io.reactivex.annotations.NonNull;

/**
 * Created by muzi on 2018/3/5.
 * 727784430@qq.com
 */
public class ResponseEntityObserver<T extends BaseEntity> extends ResponseObserver<T> {

    private Context context;

    public ResponseEntityObserver(Context baseUIActivity) {
        super(baseUIActivity);
        this.context = baseUIActivity;
    }

    public ResponseEntityObserver(Context baseUIActivity, boolean showLoadView) {
        super(baseUIActivity, showLoadView);
        this.context = baseUIActivity;
    }

    public ResponseEntityObserver(Context baseUIActivity, boolean showLoadView, NoNetFrameLayout noNetFrameLayout) {
        super(baseUIActivity, showLoadView, noNetFrameLayout);
        this.context = baseUIActivity;
    }

    @Override
    public void onNext(T t, Date date) {
        super.onNext(t, date);
        switch (t.getCode()) {
            case ErrorCode.SUCCESS:
                onSuccess(t, date);
                break;
            case ErrorCode.NO_LOGIN:
                //没有登录
                UserInfoUtils.logOut();
                switch (onLoginOut()) {
                    case -1:
                        ToastUtils.showToast(context, "请先登录");
                        break;
                    case 1:
                        context.startActivity(new Intent(context, LoginActivity.class));
                        break;
                }
                onLoginOut();
                break;
            default:
                onOther(t, date);
                break;
        }
    }

    protected void onSuccess(@NonNull T t) {
    }

    protected void onSuccess(@NonNull T t, Date date) {
        this.onSuccess(t);
    }

    protected void onOther(@NonNull T t) {

    }

    protected void onOther(@NonNull T t, Date date) {
        this.onOther(t);
    }

}
