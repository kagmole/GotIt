package ch.hearc.gotit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/schools/{id}/trainings")
public class TrainingSchoolController {

	private static final String START_URI = "standards/schools/trainings/";
	
	private static final String LIST_URI = START_URI + "list";
	private static final String ADD_URI = START_URI + "add";
	private static final String DELETE_URI = START_URI + "delete";
	private static final String EDIT_URI = START_URI + "edit";
	private static final String VIEW_URI = START_URI + "view";
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getList(Model model) {
		return LIST_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		return ADD_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(Model model) {
		return ADD_URI;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String getDeleteById(@PathVariable int id, Model model) {		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String postDeleteById(@PathVariable int id) {
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEditById(@PathVariable int id, Model model) {
		return EDIT_URI;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String postEditById(@PathVariable int id) {
		return EDIT_URI;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getViewById(@PathVariable int id) {
		return VIEW_URI;
	}
}
