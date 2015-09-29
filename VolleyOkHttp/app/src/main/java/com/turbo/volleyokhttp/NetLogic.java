package com.turbo.volleyokhttp;

import android.content.Context;

import com.android.volley.Request;
import com.turbo.base.net.BaseEvent;
import com.turbo.base.net.BaseLogic;
import com.turbo.volleyokhttp.bean.LoginEvent;
import com.turbo.volleyokhttp.bean.LoginRes;
import com.turbo.volleyokhttp.utils.SignatureUtil;

import java.util.Map;

/**
 * Created by FanCheYu on 2015/9/25 0025.
 */
public class NetLogic extends BaseLogic {
    private static NetLogic mNetLogic;

    private NetLogic(Context context) {
        super(context);
    }

    public static NetLogic getInstance(Context context) {
        synchronized (NetLogic.class) {
            if (mNetLogic == null)
                mNetLogic = new NetLogic(context);
        }
        return mNetLogic;
    }

    public void login(Context context, String url, Class clz, Map<String, String> params) {
        SignatureUtil.signature(params);
        mVolleyManager.requestData(context, url, clz, params, Request.Method.POST, true, false, true, new BaseEvent().setBeanClass(LoginRes.class));
    }

}
