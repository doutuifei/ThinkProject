package com.muzi.thinkproject.base.fragment;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.muzi.thinkproject.R;
import com.muzi.thinkproject.ui.main.CartFragment;
import com.muzi.thinkproject.ui.main.ClassFragment;
import com.muzi.thinkproject.ui.main.HomeFragment;
import com.muzi.thinkproject.ui.main.UserFragment;
import com.muzi.thinkproject.utils.OsUtils;
import com.yanzhenjie.sofia.Sofia;

/**
 * Created by muzi on 2018/2/23.
 * 727784430@qq.com
 * 沉浸式状态栏
 */

public abstract class BaseStatusBarFragment extends BaseFragment {

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        if (this instanceof HomeFragment || this instanceof UserFragment) {
            Sofia.with(getActivity())
                    .statusBarLightFont()
                    .navigationBarBackground(Color.BLACK);
        } else if (this instanceof ClassFragment || this instanceof CartFragment) {
            if (OsUtils.isSupportStatusBarDarkFont()) {
                Sofia.with(getActivity())
                        .statusBarDarkFont()
                        .navigationBarBackground(Color.BLACK);
            } else {
                getStatusView().setBackgroundColor(ContextCompat.getColor(context, R.color.defaultTextGrayColor));
            }
        }
    }

    protected View getStatusView() {
        return null;
    }

}
