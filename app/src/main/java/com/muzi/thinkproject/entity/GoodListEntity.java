package com.muzi.thinkproject.entity;

/**
 * Created by muzi on 2018/2/26.
 * 727784430@qq.com
 */

public class GoodListEntity {
    /**
     * money : 14.63
     * name : GoPro HERO 5 Black运动摄像机
     * banner_url : https://img.neisha.cc/2017/11/28/b3b9e2928a9d4e2c86f0097d4e68fdb7.png
     * type : 1
     * desId : 57aee2ae4c7dea13
     * user_photo : https://img.neisha.cc/2016/8/30/5252beb56a974bd0add992b19d303c70.png
     * desc : 4K视频 1200万像素照片 便携跟拍 适用于冲浪、滑雪、跳伞、自行车等运动
     */

    private double money;
    private String name;
    /**
     * 短租图片
     */
    private String banner_url;
    /**
     * 短租id
     */
    private String desId;
    /**
     * 长租id
     */
    private String id;
    /**
     * 是否是活动商品
     */
    private int is_activity;

    /**
     * 类型：1-短租  2-长租
     */
    private int type;
    /**
     * 长租图片
     */
    private String url;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    public String getDesId() {
        return desId;
    }

    public void setDesId(String desId) {
        this.desId = desId;
    }

    public int getIs_activity() {
        return is_activity;
    }

    public void setIs_activity(int is_activity) {
        this.is_activity = is_activity;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}