package com.wisebirds.sap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wisebirds.sap.util.GsonExcludeFields;

public class AppContext {
	public static Gson GSON = new GsonBuilder().create(); // .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
	public static Gson GSON_EXCL = new GsonBuilder().setExclusionStrategies(new GsonExcludeFields()).create();

	public static final String SECRET_KEY = "w!i@s#e$b%i^r&d*s";
	public static final String PARAM_USER_ACCOUNT = "userAccountId";

}
