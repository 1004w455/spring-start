package com.wisebirds.sap.controller;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wisebirds.sap.AppContext;
import com.wisebirds.sap.domain.account.Account;

@RestController
@SessionAttributes("me")
public class RestInsightController extends AbstractRestV1_0Controller {

	@RequestMapping("/{objectId}/insight")
	public Object getHomePage(@PathVariable String objectId, @ModelAttribute("me") Account me) throws URISyntaxException {
		System.out.println(AppContext.GSON.toJson(objectId));
		System.out.println(AppContext.GSON.toJson(me));

		// switch (AppContext.getObjectType(objectId)) {
		// case AppContext.OBJECT_AD_ACCOUNT:
		// return null;//adAccountService.insight(me, insightFormData);
		// default:
		// throw new IllegalArgumentException("처리할 수 없는 인사이트입니다.");
		// }
		return null;
	}

	@RequestMapping("/insight/test")
	public Object test(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Account account = new Account();
		account.setId(1L);
		account.setEmail("tester");
//		account.setName("하잉");
		session.setAttribute("me", account);
		return AppContext.GSON.toJson(true);
	}
	// try {
	// Path wiki_path = Paths.get(RestInsightController.class.getClassLoader().getResource("dummy/ad_insights.json").toURI());
	// Charset charset = Charset.forName("UTF-8");
	// StringBuilder sb = new StringBuilder();
	// Files.readAllLines(wiki_path, charset).forEach(sb::append);
	// AdInsights adInsights = AppContext.GSON.fromJson(sb.toString(), AdInsights.class);
	// return new ModelAndView("insight/data_table", "adInsights", adInsights.getData());
	// } catch (IOException e) {
	// throw new IllegalArgumentException(e);
	// }
}
