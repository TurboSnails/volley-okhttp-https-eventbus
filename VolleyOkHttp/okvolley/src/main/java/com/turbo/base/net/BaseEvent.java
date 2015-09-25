package com.turbo.base.net;


/**
 * 作者：Turbo on 2015/5/11 19:17
 * 邮箱：turboruby5917@163.com
 */
public abstract class BaseEvent {
    private Object mResObj;
    private String mErrorMessage;
    private VolleyManager.ResponseType mResponseType;
    private Class<? extends BaseBean> mBeanClass;
    private String temporary;

    public Object getResObj() {
        return mResObj;
    }

    public void setResObj(Object resObj) {
        mResObj = resObj;
    }

    public VolleyManager.ResponseType getResponseType() {
        return mResponseType;
    }

    public void setResponseType(VolleyManager.ResponseType mResponseType) {
        this.mResponseType = mResponseType;
    }

    public Class<? extends BaseBean> getBeanClass() {
        return mBeanClass;
    }

    public void setBeanClass(Class<? extends BaseBean> mBeanClass) {
        this.mBeanClass = mBeanClass;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String mErrorMessage) {
        this.mErrorMessage = mErrorMessage;
    }

    public String getTemporary() {
        return temporary;
    }

    public void setTemporary(String temporary) {
        this.temporary = temporary;
    }
}
