package com.muzi.thinkproject.network.api;


import com.muzi.thinkproject.entity.HomeBannerEntity;
import com.muzi.thinkproject.entity.HotGoodEntity;
import com.muzi.thinkproject.entity.SecClassEntity;
import com.muzi.thinkproject.entity.SpecialEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by muzi on 2017/12/28.
 * 727784430@qq.com
 */

public interface HomeService {

    @FormUrlEncoded
    @POST("api/slider/list")
    Observable<HomeBannerEntity> getBanner(@Field("type") int type);

    @GET("api/pro/getTemplate")
    Observable<SecClassEntity> getSecData();

    @GET("api/topic/getTopic")
    Observable<SpecialEntity> getSpecialList(@Query("page") int page, @Query("size") int size);

    @GET("api/pro/hotpro")
    Observable<HotGoodEntity> getHotData(@Query("page") int page);

}
