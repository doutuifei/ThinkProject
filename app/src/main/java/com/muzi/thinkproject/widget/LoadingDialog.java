package com.muzi.thinkproject.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.muzi.thinkproject.R;


/**
 * Created by muzi on 2017/7/21.
 * 727784430@qq.com
 */

public class LoadingDialog {

    private Dialog dialog;
    private Context context;
    private LottieAnimationView animationView;

    public LoadingDialog(Context context) {
        this.context = context;
        init();
    }

    public void init() {
        dialog = new Dialog(context, R.style.LoadingDialog);
        View view = LayoutInflater.from(context).inflate(R.layout.widget_loading_dialog, null, false);
        animationView = view.findViewById(R.id.lottieAnimationview);
        animationView.setSpeed(1.5f);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setDimAmount(0);
        dialog.setContentView(view);
    }

    public void show() {
        if (!dialog.isShowing()) {
            try {
                //显示对话框
                dialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dismiss() {
        if (dialog != null && dialog.isShowing()) {
            try {
                dialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
