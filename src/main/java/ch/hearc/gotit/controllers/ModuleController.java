package ch.hearc.gotit.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.hearc.gotit.entities.ModuleEntity;
import ch.hearc.gotit.services.ModuleService;
import ch.hearc.gotit.services.SchoolService;

@Controller
@RequestMapping(value = "/schools/{schoolPk}/modules")
public class ModuleController {

	private static final String START_URI = "standards/schools/modules/";
	
	private static final String LIST_URI = START_URI + "list";
	private static final String VIEW_URI = START_URI + "view";
	private static final String ADD_URI = START_URI + "add";
	private static final String DELETE_URI = START_URI + "delete";
	private static final String EDIT_URI = START_URI + "edit";
	
	private static final int MODULES_PER_PAGE = 10;
	
	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private SchoolService schoolService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getList(
			@PathVariable int schoolPk,
			@RequestParam(value = "page", required = false) Integer page,
			Model model) {
		
		if (page == null) {
			page = 1;
		}
		
		int lastPageNumber = 1 + moduleService.count() / MODULES_PER_PAGE;
		
		model.addAttribute("currentPageNumber", page);
		model.addAttribute("lastPageNumber", lastPageNumber);
		model.addAttribute("schoolEntity", schoolService.findOne(schoolPk));
		model.addAttribute("modulesEntitiesList", moduleService.findRangeWithSchool(schoolPk, (page - 1) * MODULES_PER_PAGE, MODULES_PER_PAGE));
		
		return LIST_URI;
	}
	
	@RequestMapping(value = "/{modulePk}", method = RequestMethod.GET)
	public String getViewById(@PathVariable int modulePk, Model model) {
		model.addAttribute("moduleEntity", moduleService.findOne(modulePk));
		
		return VIEW_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		model.addAttribute("moduleEntity", new ModuleEntity());
		
		return ADD_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(@PathVariable int schoolPk, @Valid ModuleEntity moduleEntity, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return ADD_URI;
		}
		
		// TODO ALTER TABLE
		//moduleEntity.setSchool(schoolService.findOne(schoolPk));
		moduleService.create(moduleEntity);
		
		return "redirect:/schools/" + schoolPk + "/modules/" + moduleEntity.getModulePk();
	}
	
	@RequestMapping(value = "/delete/{modulePk}", method = RequestMethod.GET)
	public String getDeleteById(@PathVariable int modulePk, Model model) {
		ModuleEntity moduleEntity = moduleService.findOne(modulePk);
		
		model.addAttribute("moduleEntity", moduleEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/delete/{modulePk}", method = RequestMethod.POST)
	public String postDeleteById(@PathVariable int modulePk) {
		ModuleEntity moduleEntity = moduleService.findOne(modulePk);
		
		moduleService.destroy(moduleEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/edit/{modulePk}", method = RequestMethod.GET)
	public String getEditById(@PathVariable int modulePk, Model model) {
		ModuleEntity moduleEntity = moduleService.findOne(modulePk);
		
		model.addAttribute("moduleEntity", moduleEntity);
		
		return EDIT_URI;
	}
	
	@RequestMapping(value = "/edit/{modulePk}", method = RequestMethod.POST)
	public String postEditById(@PathVariable int modulePk) {
		ModuleEntity moduleEntity = moduleService.findOne(modulePk);
		
		moduleService.update(moduleEntity);
		
		return EDIT_URI;
	}
}
