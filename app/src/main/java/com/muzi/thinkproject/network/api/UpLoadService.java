package com.muzi.thinkproject.network.api;


import com.muzi.thinkproject.entity.UpLoadEntity;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by muzi on 2018/3/1.
 * 727784430@qq.com
 * 上传
 */
public interface UpLoadService {

    /**
     * 上传图片
     *
     * @param parts
     * @return
     */
    @Multipart
    @POST("app/fileupload/uploads?dir=image")
    Observable<UpLoadEntity> updateImage(@Part MultipartBody.Part[] parts);

}
