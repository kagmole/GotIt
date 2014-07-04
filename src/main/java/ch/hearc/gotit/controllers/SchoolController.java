package ch.hearc.gotit.controllers;

import java.security.Principal;

import ch.hearc.gotit.entities.SchoolEntity;
import ch.hearc.gotit.services.EmployeeService;
import ch.hearc.gotit.services.EventService;
import ch.hearc.gotit.services.ModuleService;
import ch.hearc.gotit.services.SchoolService;
import ch.hearc.gotit.services.StudentService;
import ch.hearc.gotit.services.TrainingService;
import ch.hearc.gotit.services.UserService;

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
	private static final String VIEW_URI = START_URI + "view";
	private static final String ADD_URI = START_URI + "add";
	private static final String DELETE_URI = START_URI + "delete";
	private static final String EDIT_URI = START_URI + "edit";
	
	private static final int SCHOOLS_PER_PAGE = 10;
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getList(Model model) {
		model.addAttribute("schoolsEntitiesList", schoolService.findAll());
		
		return LIST_URI;
	}
	
	@RequestMapping(value = "/{schoolPk}", method = RequestMethod.GET)
	public String getViewById(@PathVariable int schoolPk, Model model) {
		SchoolEntity schoolEntity = schoolService.findOne(schoolPk);
		
		if (schoolEntity == null) {
			return "forward:/errors/404";
		}
		
		model.addAttribute("schoolEntity", schoolEntity);
		
		return VIEW_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		model.addAttribute("schoolEntity", new SchoolEntity());
		
		return ADD_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(@Valid SchoolEntity schoolEntity, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			return ADD_URI;
		}
		
		schoolService.createWithUser(schoolEntity, userService.findOneWithUsername(principal.getName()));
		
		return "redirect:/schools/" + schoolEntity.getSchoolPk();
	}
	
	@RequestMapping(value = "/delete/{schoolPk}", method = RequestMethod.GET)
	public String getDeleteById(@PathVariable int schoolPk, Model model, Principal principal) {
		SchoolEntity schoolEntity = schoolService.findOne(schoolPk);
		
		if (schoolEntity == null) {
			return "forward:/errors/404";
		}
		
		if (!schoolService.getFounderOf(schoolEntity).getUsername().equals(principal.getName())) {
			return "forward:/errors/403";
		}
		
		model.addAttribute("schoolEntity", schoolEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/delete/{schoolPk}", method = RequestMethod.POST)
	public String postDeleteById(@PathVariable int schoolPk, Principal principal) {
		SchoolEntity schoolEntity = schoolService.findOne(schoolPk);
		
		if (schoolEntity == null) {
			return "forward:/errors/404";
		}
		
		if (!schoolService.getFounderOf(schoolEntity).getUsername().equals(principal.getName())) {
			return "forward:/errors/403";
		}
		
		schoolService.destroy(schoolEntity);
		
		return "redirect:/schools";
	}
	
	@RequestMapping(value = "/edit/{schoolPk}", method = RequestMethod.GET)
	public String getEditById(@PathVariable int schoolPk, Model model, Principal principal) {
		SchoolEntity schoolEntity = schoolService.findOne(schoolPk);
		
		if (schoolEntity == null) {
			return "forward:/errors/404";
		}
		
		if (!schoolService.getFounderOf(schoolEntity).getUsername().equals(principal.getName())) {
			return "forward:/errors/403";
		}
		
		model.addAttribute("schoolEntity", schoolEntity);
		
		return EDIT_URI;
	}
	
	@RequestMapping(value = "/edit/{schoolPk}", method = RequestMethod.POST)
	public String postEditById(@PathVariable int schoolPk, @Valid SchoolEntity schoolEntity2, BindingResult result, Principal principal) {
		SchoolEntity schoolEntity = schoolService.findOne(schoolPk);
		
		if (schoolEntity == null) {
			return "forward:/errors/404";
		}
		
		if (!schoolService.getFounderOf(schoolEntity).getUsername().equals(principal.getName())) {
			return "forward:/errors/403";
		}
		
		if (result.hasErrors()) {
			return EDIT_URI;
		}
		
		schoolEntity2.setSchoolPk(schoolPk);
		schoolService.update(schoolEntity2);
		
		return "redirect:/schools/" + schoolPk;
	}
}
