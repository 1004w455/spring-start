package com.wisebirds.sap.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Secured("ROLE_USER")
	@RequestMapping(value = {"/test", "/", ""}, method = RequestMethod.GET)
	public String getHomePage() {
		LOGGER.debug("Getting home page");
		return "test";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/main")
	public ModelAndView getMainPage(HttpServletRequest request) {
		LOGGER.debug("Getting main page");
		return new ModelAndView("main", "data", "main");
	}
}
