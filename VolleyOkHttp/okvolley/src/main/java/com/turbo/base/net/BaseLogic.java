package com.turbo.base.net;

/**
 * Created by yuanyang on 2015/7/1.
 */


import android.content.Context;

/**
 * 作者：Turbo on 2015/5/14 14:14
 * 邮箱：turboruby5917@163.com
 */
public abstract class BaseLogic {
    protected VolleyManager mVolleyManager;

    protected BaseLogic(Context context) {
        mVolleyManager = VolleyManager.getInstance(context);
    }


}






