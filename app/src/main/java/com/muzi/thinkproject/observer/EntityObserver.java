package com.muzi.thinkproject.observer;

import android.content.Context;
import android.content.Intent;

import com.neisha.ppzu.entity.BaseEntity;
import com.neisha.ppzu.network.ErrorCode;
import com.neisha.ppzu.ui.login.LoginActivity;
import com.neisha.ppzu.utils.StringUtils;
import com.neisha.ppzu.utils.ToastUtils;
import com.neisha.ppzu.utils.UserInfoUtils;
import com.neisha.ppzu.view.widget.NoNetFrameLayout;

/**
 * Created by muzi on 2018/3/2.
 * 727784430@qq.com
 */

public abstract class EntityObserver<T extends BaseEntity> extends BaseObserver<T> {

    private Context context;

    public EntityObserver(Context context) {
        super(context);
        this.context = context;
    }

    public EntityObserver(Context context, boolean showLoadView) {
        super(context, showLoadView);
        this.context = context;
    }

    public EntityObserver(Context context, NoNetFrameLayout noNetFrameLayout) {
        super(context, noNetFrameLayout);
        this.context = context;
    }

    public EntityObserver(Context context, boolean showLoadView, NoNetFrameLayout noNetFrameLayout) {
        super(context, showLoadView, noNetFrameLayout);
        this.context = context;
    }

    @Override
    public final void onNext(T t) {
        super.onNext(t);
        switch (t.getCode()) {
            case ErrorCode.SUCCESS:
                onSuccess(t);
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
                onOther(t);
                break;
        }
    }

    @Override
    protected void onError(BaseEntity t) {
        super.onError(t);
        if (!StringUtils.isEmpty(t.getMsg()) && isShowToast()) {
            ToastUtils.showToast(context, t.getMsg());
        }
    }

}
