package ch.hearc.gotit.controllers;

import ch.hearc.gotit.entities.SchoolEntity;
import ch.hearc.gotit.services.SchoolService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/schools")
public class SchoolController {
	
	private static final String START_URI = "standards/schools/";
	
	private static final String LIST_URI = START_URI + "list";
	private static final String ADD_URI = START_URI + "add";
	private static final String DELETE_URI = START_URI + "delete";
	private static final String EDIT_URI = START_URI + "edit";
	private static final String VIEW_URI = START_URI + "view";
	
	@Autowired
	private SchoolService schoolService;
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String getList(Model model) {
		model.addAttribute("schoolsEntitiesList", schoolService.findAll());
		
		return LIST_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		model.addAttribute("schoolEntity", new SchoolEntity());
		
		return ADD_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(@Valid SchoolEntity schoolEntity, BindingResult result) {
		if (result.hasErrors()) {
			return ADD_URI;
		}
		
		schoolService.create(schoolEntity);
		
		return "redirect:/schools/view/" + schoolEntity.getSchoolPk();
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String getDeleteById(@PathVariable int id, Model model) {
		SchoolEntity schoolEntity = schoolService.find(id);
		
		if (schoolEntity == null) {
			return "redirect:/schools";
		}
		
		model.addAttribute("schoolEntity", schoolEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String postDeleteById(@PathVariable int id) {
		// XXX security is "meh" (correct id?)
		// XXX "yerk" composition: should be able to destroy by id
		schoolService.destroy(schoolService.find(id));
		
		return "redirect:/schools";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEditById(@PathVariable int id, Model model) {
		SchoolEntity schoolEntity = schoolService.find(id);
		
		if (schoolEntity == null) {
			return "redirect:/schools";
		}
		
		model.addAttribute("schoolEntity", schoolEntity);
		
		return EDIT_URI;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String postEditById(@PathVariable int id, @Valid SchoolEntity schoolEntity, BindingResult result) {
		if (schoolEntity == null) {
			return "redirect:/schools/edit/" + id;
		}
		
		if (result.hasErrors()) {
			return EDIT_URI;
		}
		
		// XXX security is "meh" (correct id?)
		schoolEntity.setSchoolPk(id);
		schoolService.update(schoolEntity);
		
		return "redirect:/schools/view/" + schoolEntity.getSchoolPk();
	}
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String getViewById(@PathVariable int id, Model model) {
		SchoolEntity schoolEntity = schoolService.find(id);
		
		if (schoolEntity == null) {
			return "redirect:/schools";
		}
		
		model.addAttribute("schoolEntity", schoolEntity);
		
		return VIEW_URI;
	}
}
