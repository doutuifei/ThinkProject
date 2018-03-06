package com.muzi.thinkproject.base.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.muzi.thinkproject.R;
import com.muzi.thinkproject.ui.WelcomeActivity;
import com.muzi.thinkproject.ui.main.MainActivity;
import com.muzi.thinkproject.utils.OsUtils;
import com.yanzhenjie.sofia.Sofia;

/**
 * Created by muzi on 2018/2/23.
 * 727784430@qq.com
 * 沉浸式状态栏
 * TODO:华为手机虚拟按键BUG
 */

public abstract class BaseStatusBarActivity extends BaseUIActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onStatusBar();
    }

    protected void onStatusBar() {
         if (this instanceof WelcomeActivity) {
            Sofia.with(this)
                    .statusBarDarkFont()
                    .statusBarBackground(ContextCompat.getColor(this, R.color.white))
                    .navigationBarBackground(Color.BLACK);
            return;
        } else if (this instanceof MainActivity) {
            Sofia.with(this)
                    .invasionStatusBar()
                    .navigationBarBackground(Color.BLACK);
            return;
        }

        if (OsUtils.isSupportStatusBarDarkFont()) {
            Sofia.with(this)
                    .statusBarDarkFont()
                    .statusBarBackground(ContextCompat.getColor(this, R.color.white))
                    .navigationBarBackground(Color.BLACK);
        } else {
            Sofia.with(this)
                    .statusBarDarkFont()
                    .statusBarBackground(ContextCompat.getColor(context, R.color.defaultTextGrayColor))
                    .navigationBarBackground(Color.BLACK);
        }

    }
}
