package com.wisebirds.sap.config;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import com.wisebirds.sap.util.LocaleUtils;
import com.wisebirds.sap.util.SessionUtils;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private LocaleResolver localeResolver;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		System.out.println("여기처리해야됨!!!!!");
//		Locale locale = LocaleUtils.getLocale(SessionUtils.getLocale(request, authentication));
		Locale locale = LocaleUtils.getLocale("ko_KR");
		localeResolver.setLocale(request, response, locale);
		// request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);

		SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
		System.out.println("여기처리해야됨!!!!!");
//		String defaultUrl = getDefaultUrl(SessionUtils.getRole(request));
		String defaultUrl = getDefaultUrl("ADMIN");

		if (savedRequest == null) {
			response.sendRedirect(defaultUrl);
		} else {
			String redirectUrl = savedRequest.getRedirectUrl();
			if (StringUtils.isEmpty(redirectUrl)) {
				response.sendRedirect(defaultUrl);
			}
			response.sendRedirect(redirectUrl);
		}

	}

	private String getDefaultUrl(String role) {
		String temp = "";
		switch (role) {
			case "ADMIN":
				temp = "/main";
				break;
			case "AGENCY":
				temp = "/ag/dashboard";
				break;
			case "ADVERTISER":
				temp = "/adv/manage/campaign";
				break;
			case "REVIEWER":
				temp = "/main";
				break;
			default:
				temp = "/main";
				break;
		}
		return temp;
	}

}
