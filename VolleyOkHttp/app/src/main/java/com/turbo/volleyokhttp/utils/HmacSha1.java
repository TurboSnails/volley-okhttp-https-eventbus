package com.turbo.volleyokhttp.utils;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


public class HmacSha1 {
	private static final String HMAC_SHA1 = "HmacSHA1";
	

	public static String getSignature(String data, String key){
		try {
			return getSignature(data.getBytes("UTF-8"),key.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}
	
	public static String getSignature(byte[] data, byte[] key){
        try {
			SecretKeySpec signingKey = new SecretKeySpec(key, HMAC_SHA1);
			Mac mac = Mac.getInstance(HMAC_SHA1);
			mac.init(signingKey);  
			byte[] rawHmac = mac.doFinal(data);  
			return XlmEncryption.MD5(Base64.encode(rawHmac, Base64.NO_WRAP));
		} catch (Exception e) {
		}
        return null;
    }  
}
