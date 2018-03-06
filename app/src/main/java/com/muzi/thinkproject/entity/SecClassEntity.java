package com.muzi.thinkproject.entity;

import java.util.List;

/**
 * Created by muzi on 2017/12/29.
 * 727784430@qq.com
 */

public class SecClassEntity extends BaseEntity {

    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * pro_banner_url_two : https://img.neisha.cc/2017/6/5/979493c77e4c4100b69558803ed02fc8.png
         * desId : 5ae9f41a50f8149e
         * pro_icon_url : https://img.neisha.cc/2017/5/13/8205056686a54c89ab49278e24e2e223.jpg
         * pro_desc : X-BOX、PS4、智能投影仪3D打印机 RC车、平衡车
         * pro_name : 智能酷玩
         */

        private String pro_banner_url_two;
        private String desId;
        private String pro_icon_url;
        private String pro_desc;
        private String pro_name;

        public String getPro_banner_url_two() {
            return pro_banner_url_two;
        }

        public void setPro_banner_url_two(String pro_banner_url_two) {
            this.pro_banner_url_two = pro_banner_url_two;
        }


        public String getDesId() {
            return desId;
        }

        public void setDesId(String desId) {
            this.desId = desId;
        }

        public String getPro_icon_url() {
            return pro_icon_url;
        }

        public void setPro_icon_url(String pro_icon_url) {
            this.pro_icon_url = pro_icon_url;
        }

        public String getPro_desc() {
            return pro_desc;
        }

        public void setPro_desc(String pro_desc) {
            this.pro_desc = pro_desc;
        }

        public String getPro_name() {
            return pro_name;
        }

        public void setPro_name(String pro_name) {
            this.pro_name = pro_name;
        }
    }
}
