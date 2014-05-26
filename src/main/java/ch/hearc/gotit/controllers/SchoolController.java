package ch.hearc.gotit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/schools")
public class SchoolController {
	
	private static final String START_URI = "standards/schools/";
	
	private static final String LIST_URI = START_URI + "list";
	private static final String ADD_URI = START_URI + "add";
	private static final String EDIT_URI = START_URI + "edit";
	private static final String VIEW_URI = START_URI + "view";
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String getList() {
		return LIST_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd() {
		return ADD_URI;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEditById(@PathVariable int id) {
		return EDIT_URI;
	}
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String getViewById(@PathVariable int id) {
		return VIEW_URI;
	}
}
