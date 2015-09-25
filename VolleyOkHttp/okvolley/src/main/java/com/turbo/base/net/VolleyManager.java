package com.turbo.base.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.turbo.base.ui.wedgit.NetProgressDialog;
import com.turbo.base.utils.BusProvider;
import com.turbo.base.utils.JsonUtils;
import com.turbo.base.utils.NetStateUtils;
import com.turbo.base.utils.SharedPreferencesUtils;

import java.util.Map;

/**
 * Created by FanCheYu on 2015/9/25 0025.
 */
public class VolleyManager {
    private static String TAG = VolleyManager.class.getSimpleName();
    private static VolleyManager mVolleyManager;
    private VolleyHelper mVolleyHelper;
    // 无网络无数据默认值
    private static String mDefValueNoStr = "NO_NET_NO_DATA";

    private VolleyManager(Context context) {
        mVolleyHelper = VolleyHelper.getInstance(context);
    }

    public static VolleyManager getInstance(Context context) {
        synchronized (VolleyManager.class) {
            if (mVolleyManager == null) {
                mVolleyManager = new VolleyManager(context);
            }
        }
        return mVolleyManager;
    }

    /**
     * 数据访问统一入口
     * 1.可设置loading
     * 2.otto解耦
     * 3.是否可双击
     * 4.无网络数据缓存
     *
     * @param context            上下文环境
     * @param url                请求地址
     * @param clz                请求所在的页面
     * @param params             请求参数
     * @param requestMethod      请求方法
     * @param withProgressDialog 进度条
     * @param canDouble          是否可以多次点击
     * @param noNetNeedData      是否无数据进行缓存
     * @param baseEvent          otto事件
     */
    public void requestData(final Context context, final String url, final Class<?> clz, Map<String, String> params, int requestMethod, boolean withProgressDialog, boolean canDouble, final boolean noNetNeedData, final BaseEvent baseEvent) {
        if (hasNet(context)) {// 有网络访问网络
            commonRequestWithNet(context, url, clz, params, requestMethod, withProgressDialog, canDouble, noNetNeedData, baseEvent);
        } else {
            commonRequestNoNet(context, url, noNetNeedData, baseEvent);
        }
    }

    private void commonRequestNoNet(Context context, String url, boolean noNetNeedData, BaseEvent baseEvent) {
        // 无网络访问缓存（是否允许访问缓存）
        if (noNetNeedData) {//允许访问缓存
            String spCache = getSPCache(context, url);
            if (spCache.equals(mDefValueNoStr)) {// 缓存为空，读取失败
                baseEvent.setResponseType(ResponseType.CACHEEMPTY);
                baseEvent.setErrorMessage(mDefValueNoStr);
            } else {
                Object resObj = JsonUtils.json2Bean(spCache, baseEvent.getBeanClass());
                baseEvent.setResObj(resObj);
                baseEvent.setResponseType(ResponseType.WITHDATA);
            }
        } else {
            baseEvent.setResponseType(ResponseType.CACHEERROR);
        }
        BusProvider.getInstance().post(baseEvent);
    }

    private NetProgressDialog mNetDialog;
    private boolean mRequestEnd = false;// 访问网络是否结束
    private String mBbeforeUrl = "";
    private Class<?> mBeforeRequestControllClz;


    private void commonRequestWithNet(final Context context, final String url, final Class<?> clz, Map<String, String> params, int requestMethod, boolean withProgressDialog, boolean canDouble, final boolean noNetNeedData, final BaseEvent baseEvent) {
        // 只能防止多次连续点击（如何为多次：允许、相同请求方法、相同请求参数、相同页面）
        // 不能防止间隔连续点击，需要做结束判断(将请求抽象为行为动作，将这些请求队列的动作加入到集合中，进行监听判断)
        if (mBbeforeUrl.equals(url) && !canDouble && mBeforeRequestControllClz == clz && mNetDialog != null && mNetDialog.isShowing()) {
            return;
        }
        mRequestEnd = false;
        initLoading(context, withProgressDialog);
        mVolleyHelper.accessNet(url, clz, requestMethod, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (TextUtils.isEmpty(response)) {// 没有数据
                    baseEvent.setResponseType(ResponseType.EMPTY);
                } else {// 有数据
                    if (noNetNeedData) {
                        putSPCache(context, url, response);// 数据持久化
                    }
                    Log.i(TAG, "response..." + response);
                    Object resObj = JsonUtils.json2Bean(response, baseEvent.getBeanClass());
                    baseEvent.setResObj(resObj);
                    baseEvent.setResponseType(ResponseType.WITHDATA);
                }
                onEnd(clz, url);
                BusProvider.getInstance().post(baseEvent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                baseEvent.setResponseType(ResponseType.ERROR);
                baseEvent.setErrorMessage(error.getMessage());
                Log.e(TAG, error.getMessage() + " ");
                onEnd(clz, url);
                BusProvider.getInstance().post(baseEvent);
            }
        }, params);
    }

    /**
     * loading 结束操作
     */
    public void onEnd(Class<?> clz, String url) {
        mRequestEnd = true;
        if (mNetDialog != null) {
            mNetDialog.dismiss();
        }
        mNetDialog = null;
        mBeforeRequestControllClz = clz;
        mBbeforeUrl = url;
    }

    /**
     * loading 初始化
     */
    private void initLoading(Context context, boolean withProgressDialog) {
        // 初始化loading
        if (mNetDialog == null && withProgressDialog) {
            mNetDialog = NetProgressDialog.createDialog(context);
        }
        // loading show
        if (mNetDialog != null && !mNetDialog.isShowing() && withProgressDialog) {
            mNetDialog.show();
        }
    }

    /**
     * 检查网络
     *
     * @return
     */
    private boolean hasNet(Context context) {
        return NetStateUtils.isNetworkAvalible(context);
    }

    private String getSPCache(Context context, String url) {
        return SharedPreferencesUtils.getString(context, String.valueOf(url.hashCode()), mDefValueNoStr);
    }

    /**
     * 数据持久化
     *
     * @param context
     * @param url
     * @param value
     * @return
     */
    private void putSPCache(Context context, String url, String value) {
        SharedPreferencesUtils.putString(context, String.valueOf(url.hashCode()), value);
    }

    /**
     * 在页面pause的时候调用此方法，来取消未完成的网络请求
     *
     * @param clz
     */
    public void cancelOnUIPause(Class<?> clz) {
        mVolleyHelper.cancelAll(clz);
    }

    /**
     * 返回状态
     */
    public enum ResponseType {
        NONET,// 无网络
        WITHDATA,// 成功返回数据
        EMPTY,// 返回数据为空
        ERROR, // 返回失败
        CACHEEMPTY,// 缓存为空
        CACHEERROR // 无网络不让缓存
    }

}
