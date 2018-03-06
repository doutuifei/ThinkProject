package com.muzi.thinkproject.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by muzi on 2018/3/2.
 * 727784430@qq.com
 * 添加UA拦截器
 */

public class UserAnentInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request requestWithUserAgent = originalRequest.newBuilder()
                .removeHeader("User-Agent")
                .addHeader("User-Agent", "NeiSha/2.0")
                .build();
        return chain.proceed(requestWithUserAgent);
    }
}
