package com.wisebirds.sap.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;

import com.wisebirds.sap.AppContext;
import com.wisebirds.sap.domain.account.Account;
import com.wisebirds.sap.domain.account.CustomUserDetails;

public class SessionUtils {
	public static final String LOGINED_ACCOUNT = "loginedAccount";
	public static final String SESSION_ACCOUNT_ID = "sAccountId";
	public static final String SESSION_ACCOUNT_LOGIN_ID = "sLoginId";
	public static final String SESSION_ACCOUNT_NAME = "sName";
	public static final String SESSION_AD_ACCOUNT_ID = "sAdAccountId";
	public static final String SESSION_ROLE = "sRole";
	public static final String SESSION_ROLE_URL = "sRoleUrl";
	public static final String SESSION_LOCALE = "sLocale";

	/**
	 * session에 로그인한 정보를 저장(업데이트는 안함) 후 Account반환 한다
	 * 
	 * @param request
	 * @param authentication
	 * @return Account
	 */
	public static Account getAccount(HttpServletRequest request, Authentication authentication) {
		return SessionUtils.getLoginedAccount(request, authentication);
	}

	/**
	 * session에 로그인한 정보를 저장(업데이트는 안함) 후 Account반환 한다
	 * 
	 * @param request
	 * @return Account
	 */
	public static Account getAccount(HttpServletRequest request) {
		Authentication auth = (Authentication) request.getUserPrincipal();
		return getAccount(request, auth);
	}

	/**
	 * session에 로그인한 정보를 저장(업데이트는 안함) 후 accountId반환 한다
	 * 
	 * @param request
	 * @return accountId
	 */
	public static long getAccountId(HttpServletRequest request) {
		return getAccount(request).getId();
	}

	/**
	 * session에 로그인한 정보를 저장(업데이트는 안함) 후 adAccountId반환 한다
	 * 
	 * @param request
	 * @return adAccountId
	 */
//	public static long getAdAccountId(HttpServletRequest request) {
//		// return getAccount(request).getAdAccountList().get(0).getAdAccountId();
//		return getAccount(request).getAgList().get(0).getAdvList().get(0).getAdaccountId();
//	}

	/**
	 * session에 로그인한 정보를 저장(업데이트는 안함) 후 locale을 반환 한다
	 * 
	 * @param request
	 * @return locale
	 */
	public static String getLocale(HttpServletRequest request) {
		return getAccount(request).getLocale();
	}

	/**
	 * session에 로그인한 정보를 저장(업데이트는 안함) 후 locale을 반환 한다
	 * 
	 * @param request
	 * @param authentication
	 * @return locale
	 */
	public static String getLocale(HttpServletRequest request, Authentication authentication) {
		return getAccount(request, authentication).getLocale();
	}

	/**
	 * session에 로그인한 정보를 저장(업데이트는 안함) 후 role을 반환 한다
	 * 
	 * @param request
	 * @return role
	 */
	public static String getRole(HttpServletRequest request) {
		return getAccount(request).getRole();
	}

	/**
	 * session에 로그인한 정보를 저장(업데이트는 안함) 후 roleUrl을 반환 한다
	 * 
	 * @param request
	 * @return sa, ag, adv, rev
	 */
	public static String getRoleUrl(HttpServletRequest request) {
		return getRoleUrl(getAccount(request).getRole());
	}

	public static String getRoleUrl(String role) {
		String temp = "";
		switch (role) {
			case "ADMIN":
				temp = "sa";
				break;
			case "AGENCY":
				temp = "ag";
				break;
			case "ADVERTISER":
				temp = "adv";
				break;
			case "REVIEWER":
				temp = "rev";
				break;
		}
		return temp;
	}


	private static void setSessionInfo(HttpServletRequest request, Account loginedAccount) {
		HttpSession session = request.getSession();
		session.setAttribute(SessionUtils.LOGINED_ACCOUNT, loginedAccount);

		String role = loginedAccount.getRole();

		session.setAttribute(SESSION_ROLE, role);
		session.setAttribute(SESSION_ROLE_URL, getRoleUrl(role));
		session.setAttribute(SESSION_LOCALE, loginedAccount.getLocale());
		session.setAttribute(SESSION_ACCOUNT_ID, loginedAccount.getId());
		session.setAttribute(SESSION_ACCOUNT_LOGIN_ID, loginedAccount.getLoginId());
		session.setAttribute(SESSION_ACCOUNT_NAME, loginedAccount.getManagerName());
		// if (!loginedAccount.getAdAccountList().isEmpty()) {
		// session.setAttribute(SESSION_AD_ACCOUNT_ID, loginedAccount.getAdAccountList().get(0).getAdAccountId());
		// }
	}

	private static void putLoginedAccountInfo(HttpServletRequest request, Authentication authentication) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		Account loginedAccount = userDetails.getWittAccount();
		setSessionInfo(request, loginedAccount);
	}

	public static Account getLoginedAccount(HttpServletRequest request, Authentication authentication) {
		HttpSession session = request.getSession();
		if (session == null) {
			return null;
		}
		Account loginedAccount = (Account) session.getAttribute(SessionUtils.LOGINED_ACCOUNT);
		if (loginedAccount == null) {
			putLoginedAccountInfo(request, authentication);
			loginedAccount = (Account) session.getAttribute(SessionUtils.LOGINED_ACCOUNT);
		}
		System.out.println(AppContext.GSON.toJson(loginedAccount));
		return loginedAccount;
	}

	public static void updateLoginedAccount(HttpServletRequest request, Account loginedAccount) {
		setSessionInfo(request, loginedAccount);
	}

}
