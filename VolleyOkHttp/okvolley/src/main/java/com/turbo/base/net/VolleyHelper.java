package com.turbo.base.net;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Hashtable;
import java.util.Map;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import im.amomo.volley.BuildConfig;
import im.amomo.volley.R;

/**
 * Created by FanCheYu on 2015/9/25 0025.
 */
public class VolleyHelper {
    private static VolleyHelper instance;
    private Map<String, SSLSocketFactory> socketFactoryMap;
    private static String mHttpsHost = "kyfw.12306.cn";
    private static int mRes = R.raw.kyfw;
    private static String mPassWord = "asdfqaz";

    /**
     * 在getInstance在Application中，若需要是用https，需要先调用此方法
     * 并且部分参数、方法、协议等可能需要改动
     *
     * @param httpsHost
     * @param res
     * @param password
     */
    public static void prepareHttps(String httpsHost, int res, String password) {
        mHttpsHost = httpsHost;
        mRes = res;
        password = mPassWord;
    }

    public static VolleyHelper getInstance(Context context) {
        if (instance == null) {
            instance = new VolleyHelper(context);
        }
        return instance;
    }

    public RequestQueue mRequestQueue;

    private VolleyHelper(Context context) {
        mRequestQueue = newRequestQueue(context.getApplicationContext(), mHttpsHost, mRes, mPassWord);
    }

    private boolean useClientAuth = false;

    private SSLSocketFactory createSSLSocketFactory(Context context, int res, String password)
            throws CertificateException,
            NoSuchAlgorithmException,
            IOException,
            KeyStoreException,
            KeyManagementException {
        InputStream inputStream = context.getResources().openRawResource(res);
        // 获得信任库
        KeyStore keyStore = KeyStore.getInstance("BKS");
        keyStore.load(inputStream, password.toCharArray());
        // 实例化信任库
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        // 初始化信任库
        tmf.init(keyStore);
        KeyManager[] kms = null;
        if (useClientAuth) {
            try {
                String KEYSTORE_PASSWORD = "pass";
                // 获得密钥库
                KeyStore keyStoreM = KeyStore.getInstance("PKCS12");//JKS
                keyStoreM.load(inputStream, KEYSTORE_PASSWORD.toCharArray());
                // 实例化密钥库
                KeyManagerFactory kmf = KeyManagerFactory
                        .getInstance(KeyManagerFactory.getDefaultAlgorithm());
                // 初始化密钥工厂
                kmf.init(keyStoreM, KEYSTORE_PASSWORD.toCharArray());
                kms = kmf.getKeyManagers();
            } catch (UnrecoverableKeyException e) {
                e.getMessage();
            }
        }
        // 实例化SSL上下文
        SSLContext sslContext = SSLContext.getInstance("TLS");
        // 初始化SSL上下文
        sslContext.init(kms, tmf.getTrustManagers(), new SecureRandom());
        return sslContext.getSocketFactory();
    }

    private RequestQueue newRequestQueue(Context context, String hosts, int res, String password) {
        RequestQueue requestQueue;
        socketFactoryMap = new Hashtable<>();
        SSLSocketFactory sslSocketFactory = null;
        try {
            sslSocketFactory = createSSLSocketFactory(context, res, password);
        } catch (KeyStoreException
                | CertificateException
                | NoSuchAlgorithmException
                | KeyManagementException
                | IOException e) {
            throw new RuntimeException(e);
        }
        socketFactoryMap.put(hosts, sslSocketFactory);
        HurlStack stack = new SelfSignSslOkHttpStack(socketFactoryMap);
        requestQueue = Volley.newRequestQueue(context, stack);
        return requestQueue;
    }

    public void addRequest(Request request, Object tag) {
        if (tag != null) {
            request.setTag(tag);
        }
        // 设置重载策略，10秒再次加载
        request.setRetryPolicy(new DefaultRetryPolicy(10 * 1000, 1, 1.0f));
        mRequestQueue.add(request);
    }

    public void cancelAll(Class<?> clz) {
        mRequestQueue.cancelAll(clz);
    }

    public void accessNet(String url, Class<?> clz, int requestMethod,
                          Response.Listener<String> responListener, Response.ErrorListener errorListener, final Map<String, String> params) {
        StringRequest stringRequest = new StringRequest(
                requestMethod, url, responListener, errorListener) {
            @Override
            protected Map<String, String> getParams() {
                //post参数
                return params;
            }
        };
        addRequest(stringRequest, clz);
    }

}
