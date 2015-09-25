package com.turbo.volleyokhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.turbo.base.net.BaseBean;
import com.turbo.base.net.Separate;
import com.turbo.base.net.VolleyHelper;
import com.turbo.base.utils.BusProvider;
import com.turbo.base.utils.ToastUtils;
import com.turbo.volleyokhttp.bean.LoginEvent;
import com.turbo.volleyokhttp.bean.LoginRes;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/25 0025.
 */
public class OkVolleyActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_volley);
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    private void initViews() {
        findViewById(R.id.tv_get).setOnClickListener(this);
        findViewById(R.id.tv_post).setOnClickListener(this);
        findViewById(R.id.tv_https).setOnClickListener(this);
        findViewById(R.id.tv_super_volley).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_get:
                String url = "http://api.douban.com/v2/user/googolmo";
                load(url);
                break;
            case R.id.tv_post:
                Map<String, String> params = new HashMap<>();
                params.put("account", "18251126623");
                params.put("password", "yyajgy66");
                params.put("type", "1");
                params.put("mm_device_id", "346790870");
                params.put("mm_device", "android");
                post(params);
                break;
            case R.id.tv_https:
                String https_url = "https://kyfw.12306.cn/otn/";
                load(https_url);
                break;
            case R.id.tv_super_volley:
                String login_url = "http://mapi.xlingmao.com/v2/index.php/user/login";
                Map<String, String> login_params = new HashMap<>();
                login_params.put("account", "18251126623");
                login_params.put("password", "yyajgy66");
                login_params.put("type", "1");
                login_params.put("mm_device_id", "346790870");
                login_params.put("mm_device", "android");
                NetLogic.getInstance(OkVolleyActivity.this).login(OkVolleyActivity.this, login_url, OkVolleyActivity.class, login_params);
                break;
        }
    }

    public void onEventMainThread(LoginEvent loginEvent) {
        if (loginEvent.getResponseType() == null) {
            return;
        } else {
            new Separate() {
                @Override
                public void onResSuccess(Object resObj, Class<? extends BaseBean> clz) {
                    if (clz == LoginRes.class) {
                        ToastUtils.show(OkVolleyActivity.this, ((LoginRes) resObj).toString(), Toast.LENGTH_LONG);
                    }
                }
            }.dataSeparate(OkVolleyActivity.this, loginEvent);
        }
    }

    private void load(String url) {
        Response.Listener successListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String jsonObject) {
                Log.e("TAG", "output::" + jsonObject);
                Toast.makeText(OkVolleyActivity.this, jsonObject.toString(), Toast.LENGTH_SHORT).show();
                try {
                    Toast.makeText(OkVolleyActivity.this, new JSONObject(jsonObject).optString("name"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(OkVolleyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };
        VolleyHelper.getInstance(this).accessNet(url, OkVolleyActivity.class, Request.Method.GET, successListener, errorListener, null);
    }

    private void post(final Map<String, String> params) {
        String url = "http://mapi.xlingmao.com/v2/index.php/user/login";
        Response.Listener successListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String jsonObject) {
                Toast.makeText(OkVolleyActivity.this, jsonObject.toString(), Toast.LENGTH_SHORT).show();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof ServerError) {
                    Toast.makeText(OkVolleyActivity.this,
                            new String(((ServerError) error).networkResponse.data, Charset.defaultCharset()), Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(OkVolleyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        };
        VolleyHelper.getInstance(this).accessNet(url, OkVolleyActivity.class, Request.Method.POST, successListener, errorListener, params);
    }

    @Override
    protected void onPause() {
        super.onPause();
        VolleyHelper.getInstance(this).cancelAll(this.getClass());
        BusProvider.getInstance().unregister(this);
    }

}
