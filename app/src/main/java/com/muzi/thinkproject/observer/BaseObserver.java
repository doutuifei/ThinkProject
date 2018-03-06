package com.muzi.thinkproject.observer;

import android.accounts.AccountsException;
import android.accounts.NetworkErrorException;
import android.content.Context;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.neisha.ppzu.base.activity.BaseUIActivity;
import com.neisha.ppzu.entity.BaseEntity;
import com.neisha.ppzu.network.ErrorCode;
import com.neisha.ppzu.utils.NetUtils;
import com.neisha.ppzu.view.widget.NoNetFrameLayout;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import retrofit2.HttpException;

/**
 * Created by muzi on 2018/3/2.
 * 727784430@qq.com
 */

public abstract class BaseObserver<T> implements Observer<T> {

    private Disposable s;
    /**
     * Activity上下文
     */
    private Context context;
    private BaseUIActivity baseUIActivity;
    /**
     * 是否显示进度条
     */
    private boolean showLoadView = true;
    /**
     * 404View
     */
    private NoNetFrameLayout noNetFrameLayout;

    /**
     * 错误信息和错误码
     * 默认未知错误
     */
    private int code = ErrorCode.EXCEPTION_OTHER_ERROR;
    private String reason = ErrorCode.EXCEPTION_OTHER_ERROR_MSG;


    public BaseObserver(Context context) {
        this.context = context;
        if (context instanceof BaseUIActivity) {
            this.baseUIActivity = (BaseUIActivity) context;
        }
    }

    public BaseObserver(Context context, boolean showLoadView) {
        this(context);
        this.showLoadView = showLoadView;
    }

    public BaseObserver(Context context, NoNetFrameLayout noNetFrameLayout) {
        this(context);
        this.noNetFrameLayout = noNetFrameLayout;
    }

    public BaseObserver(Context context, boolean showLoadView, NoNetFrameLayout noNetFrameLayout) {
        this(context, showLoadView);
        this.noNetFrameLayout = noNetFrameLayout;
    }

    @Override
    public final void onSubscribe(@NonNull Disposable s) {
        if (EndConsumerHelper.validate(this.s, s, getClass())) {
            this.s = s;
            if (!NetUtils.isNetworkAvailable(context)) {
                onNetAvailable(false);
                onError(new BaseEntity(ErrorCode.EXCEPTION_NETWORK_NOT_CONNECTED_MSG, ErrorCode.EXCEPTION_NETWORK_NOT_CONNECTED));
            } else {
                onStart();
            }
        }
    }

    /**
     * 取消订阅
     */
    protected final void cancel() {
        Disposable s = this.s;
        this.s = DisposableHelper.DISPOSED;
        s.dispose();
    }

    /**
     * 开始
     * 展示进度条
     */
    protected void onStart() {
        if (showLoadView && baseUIActivity != null) {
            baseUIActivity.showLoadingView();
        }
    }

    /**
     * 网络是否可用
     *
     * @param available
     */
    protected void onNetAvailable(boolean available) {
        //显示404view
        if (noNetFrameLayout != null) {
            noNetFrameLayout.set404Visiable(!available);
        }
    }

    /**
     * 错误信息
     *
     * @param t
     */
    protected void onError(@NonNull BaseEntity t) {
        onComplete();
    }

    /**
     * 请求成功
     *
     * @param t
     */
    protected void onSuccess(@NonNull T t) {

    }

    /**
     * 其他情况
     *
     * @param t
     */
    protected void onOther(@NonNull T t) {

    }

    /**
     * 没有登录
     *
     * @return 操作
     * -1：toast提示
     * 0：不做处理
     * 1：打开登录Activity
     */
    protected int onLoginOut() {
        return 0;
    }

    /**
     * 是否显示toast
     *
     * @return
     */
    protected boolean isShowToast() {
        return true;
    }

    /**
     * 请求完成
     */
    @Override
    public void onComplete() {
        cancel();
        //隐藏进度条
        if (showLoadView && baseUIActivity != null) {
            baseUIActivity.hiddenLoadingView();
        }
        //结束刷新
        if (baseUIActivity != null) {
            baseUIActivity.refreshFinish();
        }
    }

    @Override
    public void onNext(T t) {
        onNetAvailable(true);
    }

    /**
     * 默认错误处理方法
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        if (e instanceof NetworkErrorException) {//网络异常--继承于AccountsException
            reason = ErrorCode.EXCEPTION_NETWORK_ERROR_MSG;
            code = ErrorCode.EXCEPTION_NETWORK_ERROR;
        } else if (e instanceof AccountsException) {//账户异常
            reason = ErrorCode.EXCEPTION_ACCOUNTS_MSG;
            code = ErrorCode.EXCEPTION_ACCOUNTS;
        } else if (e instanceof ConnectException) {//连接异常--继承于SocketException
            reason = ErrorCode.EXCEPTION_CONNECT_MSG;
            code = ErrorCode.EXCEPTION_CONNECT;
        } else if (e instanceof SocketException) {//socket异常
            reason = ErrorCode.EXCEPTION_SOCKET_MSG;
            code = ErrorCode.EXCEPTION_SOCKET;
        } else if (e instanceof HttpException) {// http异常
            reason = ErrorCode.EXCEPTION_HTTP_MSG;
            code = ErrorCode.EXCEPTION_HTTP;
        } else if (e instanceof UnknownHostException) {//DNS错误
            reason = ErrorCode.EXCEPTION_UNKNOWN_HOST_MSG;
            code = ErrorCode.EXCEPTION_UNKNOWN_HOST;
        } else if (e instanceof JsonSyntaxException
                || e instanceof JsonIOException
                || e instanceof JsonParseException) {//数据格式化错误
            reason = ErrorCode.EXCEPTION_JSON_SYNTAX_MSG;
            code = ErrorCode.EXCEPTION_JSON_SYNTAX;
        } else if (e instanceof SocketTimeoutException || e instanceof TimeoutException) {//超时
            reason = ErrorCode.EXCEPTION_TIME_OUT_MSG;
            code = ErrorCode.EXCEPTION_TIME_OUT;
        } else if (e instanceof ClassCastException) {//类异常
            reason = ErrorCode.EXCEPTION_CLASS_CAST_MSG;
            code = ErrorCode.EXCEPTION_CLASS_CAST;
        }
        onError(new BaseEntity(reason, code));
    }
}
