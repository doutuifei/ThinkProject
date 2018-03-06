package com.muzi.thinkproject;

import android.app.Application;

/**
 * Created by muzi on 2018/3/6.
 * 727784430@qq.com
 */

public class App extends Application {

    public static App mInstance;

    public static App getInstance() {
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
