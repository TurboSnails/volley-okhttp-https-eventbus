package com.turbo.volleyokhttp.utils;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;


/**
 * @author bihu
 *         <p>
 *         签名规则示例
 *         appId: mc1000 //APP的ID
 *         kvString: auth=2234&query=+982sss&store=xx@xx&zindex=0
 *         sign:dfd81107d952da0e2d98b3908a9708b4
 *         sign: {appId}:{sign} 如： mc1000:dfd81107d952da0e2d98b3908a9708b4
 */
public class SignatureUtil {

    //public static final String HMAC_SIGNATURE = "signature";
    public static final String HMAC_AUTH_TIMESTAMP = "timestamp";
    public static final String HMAC_NONCE = "nonce";
    private static final long REQUEST_TIMEOUT_MS = 5000; //5sec

    public static String generateSignature(String kvString, String secrectKey) {
        return HmacSha1.getSignature(kvString, secrectKey);
    }

    public static boolean checkRequestTimeout(long requestTimestamp) {
        long current = System.currentTimeMillis();
        if (current > (requestTimestamp + REQUEST_TIMEOUT_MS)) {
            return false;
        } else {
            return true;
        }
    }

    private static String secrectKey = "5c8b551b675c4fd8aafe1724041985bd";
    private static int RandomTotal = 100;

    public static void signature(Map params) {
        params.put("timestamp", String.valueOf(System.currentTimeMillis()));
        params.put("nounce", String.valueOf(new Random().nextInt(RandomTotal)));
        String kvString = buildKVString(params);
        params.put("signature", generateSignature(kvString, secrectKey));
    }

    private static List<String> keyList = new ArrayList<>();
    public static String buildKVString(Map<String, String> params) {
        StringBuilder kvStr = new StringBuilder();
        if (params != null && !params.isEmpty()) {
            Set keySet = params.keySet();
            if (params instanceof TreeMap) {
                int index = 0;
                for (Iterator<String> it = keySet.iterator(); it.hasNext(); ) {
                    String key = it.next();
                    appendUrl(params, kvStr, index, key);
                    index++;
                }
            } else {
                keyList.clear();
                keyList.addAll(keySet);
                Collections.sort(keyList);
                for (int i = 0; i < keyList.size(); i++) {
                    String key = keyList.get(i);
                    appendUrl(params, kvStr, i, key);
                }
            }
        }

        String kvStringE = "";
        try {
            kvStringE = URLEncoder.encode(kvStr.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        //kvStringE = kvStringE.replace("*", "%2A").replace("+", "%20");
        return kvStringE;
    }

    private static void appendUrl(Map<String, String> params, StringBuilder kvStr, int index, String key) {
        String value = params.get(key);
        if (index == (params.size() - 1)) {
            kvStr.append(key).append("=").append(value);
        } else {
            kvStr.append(key).append("=").append(value).append("&");
        }

    }


}
