package com.muzi.thinkproject.entity;

import java.util.List;

/**
 * Created by muzi on 2017/12/28.
 * 727784430@qq.com
 */

public class HomeBannerEntity extends BaseEntity {


    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * video_url :
         * delay : 7
         * img_url : https://img.neisha.cc/2017/11/1/241d3bd365d4406ca70d23f8ddb187c1.jpg
         * action_type : 2
         * type_id : 5
         * btn_name : 3
         * title : 3
         * url : https://www.neisha.cc/app/activity/activityIndex
         * desc : 3
         */

        private String img_url;
        private int action_type;


        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public int getAction_type() {
            return action_type;
        }

        public void setAction_type(int action_type) {
            this.action_type = action_type;
        }

    }
}
