package com.turbo.volleyokhttp.bean;

import com.turbo.base.net.BaseEvent;

/**
 * Created by FanCheYu on 2015/9/25 0025.
 */
public class LoginEvent extends BaseEvent {
    public LoginEvent() {
        setBeanClass(LoginRes.class);
    }
}
