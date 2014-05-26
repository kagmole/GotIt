package ch.hearc.gotit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticController {
	
	private static final String START_URI = "standards/statics/";
	
	private static final String HOME_URI = START_URI + "home";
	private static final String ABOUT_URI = START_URI + "about";
	private static final String CONTACT_URI = START_URI + "contact";
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String getHome() {
		return HOME_URI;
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String getAbout() {
		return ABOUT_URI;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String getContact() {
		return CONTACT_URI;
	}
}
