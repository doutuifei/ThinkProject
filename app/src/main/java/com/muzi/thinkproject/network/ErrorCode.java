package com.muzi.thinkproject.network;

/**
 * Created by muzi on 2018/1/30.
 * 727784430@qq.com
 */

public class ErrorCode {

    public final static int SUCCESS = 200;

    public final static int NO_LOGIN=201;
    public final static String NO_LOGIN_MSG="请先登录";

    public final static int EXCEPTION_NETWORK_NOT_CONNECTED = 0x0001000;
    public final static String EXCEPTION_NETWORK_NOT_CONNECTED_MSG = "网络连接异常，请检查您的网络状态";

    public final static int EXCEPTION_NETWORK_ERROR = 0x0001001;
    public final static String EXCEPTION_NETWORK_ERROR_MSG = "网络发生错误，请检查您的网络后重试";

    public final static int EXCEPTION_ACCOUNTS = 0x0001002;
    public final static String EXCEPTION_ACCOUNTS_MSG = "账户异常";

    public final static int EXCEPTION_CONNECT = 0x0001003;
    public final static String EXCEPTION_CONNECT_MSG = "网络连接异常，请检查您的网络后重试";

    public final static int EXCEPTION_SOCKET = 0x0001004;
    public final static String EXCEPTION_SOCKET_MSG = "数据接收异常，请检查您的网络后重试";

    public final static int EXCEPTION_HTTP = 0x0001005;
    public final static String EXCEPTION_HTTP_MSG = "网络连接异常，请检查您的网络后重试";

    public final static int EXCEPTION_UNKNOWN_HOST = 0x0001006;
    public final static String EXCEPTION_UNKNOWN_HOST_MSG = "未知的网址";

    public final static int EXCEPTION_JSON_SYNTAX = 0x0001007;
    public final static String EXCEPTION_JSON_SYNTAX_MSG = "数据格式化异常";

    public final static int EXCEPTION_TIME_OUT = 0x0001008;
    public final static String EXCEPTION_TIME_OUT_MSG = "连接超时";

    public final static int EXCEPTION_CLASS_CAST = 0x0001009;
    public final static String EXCEPTION_CLASS_CAST_MSG = "类异常";

    public final static int EXCEPTION_OTHER_ERROR = 0x0001010;
    public final static String EXCEPTION_OTHER_ERROR_MSG = "未知错误";

}
