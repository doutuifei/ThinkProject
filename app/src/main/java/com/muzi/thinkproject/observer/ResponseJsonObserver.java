package com.muzi.thinkproject.observer;

import android.content.Context;
import android.content.Intent;

import com.neisha.ppzu.network.ErrorCode;
import com.neisha.ppzu.ui.login.LoginActivity;
import com.neisha.ppzu.utils.ToastUtils;
import com.neisha.ppzu.utils.UserInfoUtils;
import com.neisha.ppzu.view.widget.NoNetFrameLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

import okhttp3.ResponseBody;


/**
 * Created by muzi on 2018/3/5.
 * 727784430@qq.com
 */
public abstract class ResponseJsonObserver<T extends ResponseBody> extends ResponseObserver<T> {

    private Context context;

    private int code;
    private String msg;
    private JSONObject jsonObject;

    public ResponseJsonObserver(Context context) {
        super(context);
        this.context = context;
    }

    public ResponseJsonObserver(Context context, boolean showLoadView) {
        super(context, showLoadView);
        this.context = context;
    }

    public ResponseJsonObserver(Context context, NoNetFrameLayout noNetFrameLayout) {
        super(context, noNetFrameLayout);
        this.context = context;
    }

    public ResponseJsonObserver(Context context, boolean showLoadView, NoNetFrameLayout noNetFrameLayout) {
        super(context, showLoadView, noNetFrameLayout);
        this.context = context;
    }

    @Override
    protected void onNext(T t, Date date) {
        super.onNext(t, date);
        try {
            jsonObject = new JSONObject(t.string());
            code = jsonObject.optInt("code");
            msg = jsonObject.optString("msg");
            switch (code) {
                case ErrorCode.SUCCESS:
                    onSuccess(jsonObject, date);
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
                    onOther(jsonObject, date, code);
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void onSuccess(JSONObject jsonObject) {
    }

    protected void onSuccess(JSONObject jsonObject, Date date) {
        this.onSuccess(jsonObject);
    }

    protected void onOther(JSONObject jsonObject) {
    }

    protected void onOther(JSONObject jsonObject, Date date) {
        this.onOther(jsonObject);
    }

    protected void onOther(JSONObject jsonObject, Date date, int code) {
        this.onOther(jsonObject, date);
    }
}
