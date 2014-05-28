package ch.hearc.gotit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/admin**")
public class AdminController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getTest() {
		return "You're an admin I hope.";
	}
}
