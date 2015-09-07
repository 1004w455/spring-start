package com.wisebirds.sap.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class GsonExcludeFields implements ExclusionStrategy {

	@Override
	public boolean shouldSkipClass(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		switch (f.getName()) {
			case "id":
			case "objectName":
			case "agList":
			case "advList":
			case "adaccountId":
				return false;
			default:
				return true;
		}
	}

}
