package com.muzi.thinkproject.network.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by muzi on 2018/2/26.
 * 727784430@qq.com
 */

public interface ClassificationService {

    @GET("wx/pro/mobListJson/{descId}")
    Observable<Response<ResponseBody>> getClassificationData(@Path("descId") String descId);

}
