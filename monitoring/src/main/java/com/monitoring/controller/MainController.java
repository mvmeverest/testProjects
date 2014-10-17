package com.monitoring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	public static final String CONTROLLER_NAME = "main";

	@RequestMapping(value = "/" + CONTROLLER_NAME + "/index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		return CONTROLLER_NAME + "/index";
	}
}
