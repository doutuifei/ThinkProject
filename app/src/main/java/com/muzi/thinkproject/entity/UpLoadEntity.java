package com.muzi.thinkproject.entity;

import java.util.List;

/**
 * Created by muzi on 2018/3/1.
 * 727784430@qq.com
 */
public class UpLoadEntity extends BaseEntity {

    /**
     * msg : ok
     * code : 200
     * items : ["https://img.neisha.cc/2017/12/20/f51ab98614bd473a8a32cc24ba0b61fd.png"]
     */

    private List<String> items;

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

}
