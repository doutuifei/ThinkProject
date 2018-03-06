package com.muzi.thinkproject.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by muzi on 2017/12/29.
 * 727784430@qq.com
 * 专题
 */

public class SpecialEntity extends BaseEntity {

    private List<ItemsBeanX> items;

    public SpecialEntity() {
    }

    public SpecialEntity(List<ItemsBeanX> items) {
        this.items = items;
    }

    public List<ItemsBeanX> getItems() {
        return items;
    }

    public void setItems(List<ItemsBeanX> items) {
        this.items = items;
    }

    public static class ItemsBeanX {
        /**
         * name : 摄影套装专场
         * banner_app : https://img.neisha.cc/2017/12/26/3e2ea637d6ea46a5acfb0f60201ce0ca.jpg
         * desId : 95e569e9361275ce
         * banner_pc : https://img.neisha.cc/2017/12/26/775251e2e4114eaca9d6a5e178866167.jpg
         * items : [{"relet_money":59.99,"address":" ","surplus":0,"limit_day":30,"sale_num":0,"user_name":"官方自营","must_price_month":0,"relieved_money":0,"user_mob":"4000001929","pri_price":70.99,"money":22.55,"freight_money":0,"name":"尼康 16-35mm f4G镜头","month_objective":0,"is_activity":0,"banner_url":"https://img.neisha.cc/2017/12/22/8add4918a687442794ac3182c62b3482.png","id":2713,"desId":"2f7fa37c40fc80bb","pledge_money":7099,"user_photo":"https://img.neisha.cc/default%2Fphoto%2Fphoto-v-1.0.jpg","desc":"尼康 16-35mm f4G镜头"}]
         * desc : 摄影套装：相机、镜头、脚架、闪光灯、稳定器，随心搭配，一步到位
         */

        private String name;
        private String banner_app;
        private String desId;
        private String desc;
        private List<ItemsBean> items;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBanner_app() {
            return banner_app;
        }

        public void setBanner_app(String banner_app) {
            this.banner_app = banner_app;
        }

        public String getDesId() {
            return desId;
        }

        public void setDesId(String desId) {
            this.desId = desId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean implements MultiItemEntity {
            /**
             * relet_money : 59.99
             * address :
             * surplus : 0
             * limit_day : 30
             * sale_num : 0
             * user_name : 官方自营
             * must_price_month : 0
             * relieved_money : 0
             * user_mob : 4000001929
             * pri_price : 70.99
             * money : 22.55
             * freight_money : 0
             * name : 尼康 16-35mm f4G镜头
             * month_objective : 0
             * is_activity : 0
             * banner_url : https://img.neisha.cc/2017/12/22/8add4918a687442794ac3182c62b3482.png
             * id : 2713
             * desId : 2f7fa37c40fc80bb
             * pledge_money : 7099
             * user_photo : https://img.neisha.cc/default%2Fphoto%2Fphoto-v-1.0.jpg
             * desc : 尼康 16-35mm f4G镜头
             */

            private double relet_money;
            private String address;
            private int surplus;
            private int limit_day;
            private int sale_num;
            private String user_name;
            private int must_price_month;
            private int relieved_money;
            private String user_mob;
            private double pri_price;
            private double money;
            private int freight_money;
            private String name;
            private int month_objective;
            private int is_activity;
            private String banner_url;
            private String desId;
            private int pledge_money;
            private String user_photo;
            private String desc;
            private int type = 1;

            public ItemsBean() {
            }

            public ItemsBean(int type, String desId) {
                this.desId = desId;
                this.type = type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public double getRelet_money() {
                return relet_money;
            }

            public void setRelet_money(double relet_money) {
                this.relet_money = relet_money;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getSurplus() {
                return surplus;
            }

            public void setSurplus(int surplus) {
                this.surplus = surplus;
            }

            public int getLimit_day() {
                return limit_day;
            }

            public void setLimit_day(int limit_day) {
                this.limit_day = limit_day;
            }

            public int getSale_num() {
                return sale_num;
            }

            public void setSale_num(int sale_num) {
                this.sale_num = sale_num;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public int getMust_price_month() {
                return must_price_month;
            }

            public void setMust_price_month(int must_price_month) {
                this.must_price_month = must_price_month;
            }

            public int getRelieved_money() {
                return relieved_money;
            }

            public void setRelieved_money(int relieved_money) {
                this.relieved_money = relieved_money;
            }

            public String getUser_mob() {
                return user_mob;
            }

            public void setUser_mob(String user_mob) {
                this.user_mob = user_mob;
            }

            public double getPri_price() {
                return pri_price;
            }

            public void setPri_price(double pri_price) {
                this.pri_price = pri_price;
            }

            public double getMoney() {
                return money;
            }

            public void setMoney(double money) {
                this.money = money;
            }

            public int getFreight_money() {
                return freight_money;
            }

            public void setFreight_money(int freight_money) {
                this.freight_money = freight_money;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getMonth_objective() {
                return month_objective;
            }

            public void setMonth_objective(int month_objective) {
                this.month_objective = month_objective;
            }

            public int getIs_activity() {
                return is_activity;
            }

            public void setIs_activity(int is_activity) {
                this.is_activity = is_activity;
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

            public int getPledge_money() {
                return pledge_money;
            }

            public void setPledge_money(int pledge_money) {
                this.pledge_money = pledge_money;
            }

            public String getUser_photo() {
                return user_photo;
            }

            public void setUser_photo(String user_photo) {
                this.user_photo = user_photo;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            @Override
            public int getItemType() {
                return type;
            }
        }
    }
}
