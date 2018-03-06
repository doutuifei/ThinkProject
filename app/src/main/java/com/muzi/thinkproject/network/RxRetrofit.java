package com.muzi.thinkproject.network;


import com.neisha.ppzu.network.api.CartService;
import com.neisha.ppzu.network.api.ClassService;
import com.neisha.ppzu.network.api.ClassificationService;
import com.neisha.ppzu.network.api.ExampleService;
import com.neisha.ppzu.network.api.HomeService;
import com.neisha.ppzu.network.api.LoginService;
import com.neisha.ppzu.network.api.LongRentService;
import com.neisha.ppzu.network.api.OrderService;
import com.neisha.ppzu.network.api.SearchService;
import com.neisha.ppzu.network.api.SpecialService;
import com.neisha.ppzu.network.api.UpLoadService;
import com.neisha.ppzu.network.api.UserService;

/**
 * Created by muzi on 2017/10/20.
 * 727784430@qq.com
 */

public class RxRetrofit extends RetrofitHelper {

    public static ExampleService getExampleApi() {
        return createApi(ExampleService.class);
    }

    public static HomeService getHomeApi() {
        return createApi(HomeService.class);
    }

    public static ClassService getClassApi() {
        return createApi(ClassService.class);
    }

    public static LoginService getLoginApi() {
        return createApi(LoginService.class);
    }

    public static OrderService getOrderApi() {
        return createApi(OrderService.class);
    }

    public static UserService getUserApi() {
        return createApi(UserService.class);
    }

    public static CartService getCartApi() {
        return createApi(CartService.class);
    }

    public static LongRentService getLongRentApi() {
        return createApi(LongRentService.class);
    }

    public static SpecialService getSpecialApi() {
        return createApi(SpecialService.class);
    }

    public static ClassificationService getClassificationApi() {
        return createApi(ClassificationService.class);
    }

    public static SearchService getSearchApi() {
        return createApi(SearchService.class);
    }

    public static UpLoadService uploadApi() {
        return createApi(UpLoadService.class);
    }
}
