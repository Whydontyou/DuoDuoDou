package com.feidu.duoduodou.bean;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by wangjian on 2017/8/29.
 */

public class TabNewEntity implements CustomTabEntity {
    public String title;

    @Override
    public String getTabTitle() {
        return title;
    }
    public TabNewEntity(String title) {
        this.title = title;


    }
    @Override
    public int getTabSelectedIcon() {
        return 0;
    }

    @Override
    public int getTabUnselectedIcon() {
        return 0;
    }
}
