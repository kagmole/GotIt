package ch.hearc.gotit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/errors")
public class ErrorController {
	
	private static final String START_URI = "desktops/bases/";
	
	private static final String ERROR_403_URI = START_URI + "403";
	private static final String ERROR_404_URI = START_URI + "404";

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String getError403() {
		return ERROR_403_URI;
	}
	
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String getError404() {
		return ERROR_404_URI;
	}
}
