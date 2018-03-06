package com.muzi.thinkproject.entity;

import java.util.List;

/**
 * Created by muzi on 2018/1/2.
 * 727784430@qq.com
 */

public class HotGoodEntity extends BaseEntity {

    /**
     * totalPage : 13
     * items : [{"money":14.63,"user_id":"-1","name":"GoPro HERO 5 Black运动摄像机","user_nickname":" ","banner_url":"https://img.neisha.cc/2017/11/28/b3b9e2928a9d4e2c86f0097d4e68fdb7.png","id":2413,"inventory_num":1,"type":1,"desId":"57aee2ae4c7dea13","user_photo":"https://img.neisha.cc/2016/8/30/5252beb56a974bd0add992b19d303c70.png","desc":"4K视频 1200万像素照片 便携跟拍 适用于冲浪、滑雪、跳伞、自行车等运动","likeNum":22}]
     */

    private int totalPage;
    private List<GoodListEntity> items;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<GoodListEntity> getItems() {
        return items;
    }

    public void setItems(List<GoodListEntity> items) {
        this.items = items;
    }

}
