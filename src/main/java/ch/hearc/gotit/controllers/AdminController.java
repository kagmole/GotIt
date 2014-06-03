package ch.hearc.gotit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	private static final String START_URI = "standards/admins/";
	
	private static final String OVERVIEW_URI = START_URI + "overview";

	@RequestMapping(method = RequestMethod.GET)
	public String getOverview() {
		return OVERVIEW_URI;
	}
}
