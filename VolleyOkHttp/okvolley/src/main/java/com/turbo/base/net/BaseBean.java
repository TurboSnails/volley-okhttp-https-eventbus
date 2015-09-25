package com.turbo.base.net;

/**
 * 作者：Turbo on 2015/5/12 14:10
 * 邮箱：turboruby5917@163.com
 */
public abstract class BaseBean {
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
