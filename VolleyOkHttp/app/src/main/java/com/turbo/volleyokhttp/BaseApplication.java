package com.turbo.volleyokhttp;

import android.app.Application;

import com.turbo.base.net.VolleyHelper;

/**
 * Created by GoogolMo on 12/31/13.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyHelper.getInstance(this);
    }


}
