package com.turbo.base.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtils {

	private static Gson mGson = new Gson();

	public static <T> T json2Bean(String jsonStr, Class<T> cls) {
		return mGson.fromJson(jsonStr, cls);
	}

	public static <T> T json2List(String jsonStr, TypeToken<T> typeToken) {
		return mGson.fromJson(jsonStr, typeToken.getType());
	}

	public static <T> String toJson(T obj) {
		return mGson.toJson(obj);
	}

}
