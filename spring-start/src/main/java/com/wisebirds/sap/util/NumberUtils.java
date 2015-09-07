package com.wisebirds.sap.util;

import javax.servlet.http.HttpServletRequest;

public class NumberUtils {
	public static long parseLong(HttpServletRequest request, String key) {
		try {
			return Long.parseLong(request.getParameter(key));
		} catch (Exception e) {
			return 0;
		}
	}
}
