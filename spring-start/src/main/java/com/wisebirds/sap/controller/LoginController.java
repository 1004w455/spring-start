package com.wisebirds.sap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
		ModelAndView mav = new ModelAndView("login");
		if (error != null) {
			mav.addObject("error", "Invalid username and password!");
			LOGGER.debug("Getting login page, error={}", error);
		}
		if (logout != null) {
			mav.addObject("logout", "You've been logged out successfully.");
			LOGGER.debug("Getting logout page logout={}", logout);
		}
		return mav;
	}
}
