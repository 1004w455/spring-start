package com.wisebirds.sap.util;

import java.util.Locale;

public class LocaleUtils {

	public static Locale getLocale(String strLocale) {
		Locale locale = null;
		switch (strLocale) {
			case "ko_KR":
				locale = Locale.KOREA;
				break;
			case "en_US":
				locale = Locale.US;
				break;
			case "zh_TW":
				locale = Locale.TAIWAN;
				break;
			case "ja_JP":
				locale = Locale.JAPAN;
				break;
			default:
				locale = Locale.KOREA;
				break;
		}
		return locale;
	}

}
