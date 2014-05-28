package ch.hearc.gotit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/errors")
public class ErrorController {

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String get403() {
		return "standards/errors/403";
	}
	
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String get404() {
		return "standards/errors/404";
	}
}
