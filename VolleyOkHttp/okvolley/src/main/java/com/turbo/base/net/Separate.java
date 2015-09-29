package com.turbo.base.net;

import android.content.Context;
import android.text.TextUtils;

import com.turbo.base.utils.ToastUtils;

import im.amomo.volley.R;

/**
 * Created by FanCheYu on 2015/9/25 0025.
 */
public abstract class Separate {

    /**
     * 数据剥离(Logic)
     *
     * @param context 上下文环境
     * @param event   传递事件
     */
    public void dataSeparate(Context context, BaseEvent event) {
        // 各种状态判断
        VolleyManager.ResponseType responseType = event.getResponseType();
        Class<? extends BaseBean> beanClass = event.getBeanClass();
        switch (responseType) {
            case WITHDATA:
                Object resObj = event.getResObj();
                onResSuccess(resObj, beanClass);
                break;
            case EMPTY:
                onResEmpty(context, beanClass);
                break;
            case ERROR:
                String errorMessage = event.getErrorMessage();
                onResError(context, errorMessage, beanClass);
                break;
            case CACHEEMPTY:
                // 提示
                onNoNet(context);
                break;
            case CACHEERROR:
                // 提示
                onNoNet(context);
                break;
        }
    }

    public void onNoNet(Context context) {
        // 提示
        ToastUtils.showLong(context, "No Net And No Data");
    }

    /**
     * 有网络，成功访问网络，返回为空
     *
     * @param clz 数据类型
     */
    public void onResEmpty(Context context, Class<? extends BaseBean> clz) {
        // 提示
        ToastUtils.showLong(context, context.getString(R.string.str_res_empty));
    }

    public void onResError(Context context, String errorMessage, Class<? extends BaseBean> clz) {
        ToastUtils.showLong(context, TextUtils.isEmpty(errorMessage) ? "response error: " : errorMessage + "");
    }

    /**
     * 数据成功返回
     *
     * @param resObj 成功数据
     * @param clz    数据类型
     */
    public abstract void onResSuccess(Object resObj, Class<? extends BaseBean> clz);
}
