package com.avizva.utility;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This utility has methods that helps to convert the Object to Json
 * 
 * @author Campus2017
 *
 */
public class JsonConverter {

	private static final Gson GSON = new Gson();

	public static String toJSON(Object object) {
		return GSON.toJson(object);
	}

	public static List<Integer> convertStringListToIntegerList(String list) {
		Type type = new TypeToken<List<Integer>>() {
		}.getType();
		List<Integer> integers = GSON.fromJson(list, type);
		return integers;
	}

}
