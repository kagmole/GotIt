package ch.hearc.gotit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/desktop")
//TODO remove: destkop will be at "/schools/{id}/desktop" -> SchoolController (or forwarding... ?)
public class DesktopController {
	
	private static final String START_URI = "desktops/bases/";
	
	private static final String DEFAULT_URI = START_URI + "default";
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getDefault() {
		return DEFAULT_URI;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getTest() {
		return "desktops/applications/test";
	}
}