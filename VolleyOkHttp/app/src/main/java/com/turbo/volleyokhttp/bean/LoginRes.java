package com.turbo.volleyokhttp.bean;

import com.turbo.base.net.BaseBean;

/**
 * Created by FanCheYu on 2015/9/25 0025.
 */
public class LoginRes extends BaseBean {
    private UserInfo item;

    public UserInfo getItem() {
        return item;
    }

    public void setItem(UserInfo item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "LoginRes{" +
                "item=" + item +
                '}';
    }
}
