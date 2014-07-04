package ch.hearc.gotit.controllers;

import ch.hearc.gotit.entities.SlideEntity;
import ch.hearc.gotit.services.ClassService;
import ch.hearc.gotit.services.SlideService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/schools/{schoolPk}/modules/{modulePk}/courses/{coursePk}/classes/{classPk}/slides")
public class SlideController {

	private static final String START_URI = "standards/schools/modules/courses/classes/slides/";
	
	private static final String LIST_URI = START_URI + "list";
	private static final String VIEW_URI = START_URI + "view";
	private static final String ADD_URI = START_URI + "add";
	private static final String DELETE_URI = START_URI + "delete";
	private static final String EDIT_URI = START_URI + "edit";
	
	private static final int SLIDES_PER_PAGE = 10;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private SlideService slideService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getList(@PathVariable int classPk, @RequestParam(value = "page", required = false) Integer page, Model model) {
		if (page == null) {
			page = 0;
		}
		
		model.addAttribute("slidesEntitiesList", slideService.findRangeWithClass(classPk, page * SLIDES_PER_PAGE, SLIDES_PER_PAGE));
		
		return LIST_URI;
	}
	
	@RequestMapping(value = "/{slidePk}", method = RequestMethod.GET)
	public String getViewById(@PathVariable int slidePk, Model model) {
		model.addAttribute("slideEntity", slideService.findOne(slidePk));
		
		return VIEW_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		model.addAttribute("slideEntity", new SlideEntity());
		
		return ADD_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(@PathVariable int classPk, @Valid SlideEntity slideEntity, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return ADD_URI;
		}
		
		slideEntity.setClassEntity(classService.findOne(classPk));
		slideService.create(slideEntity);
		
		return "redirect:/schools/" + /* TODO */ 0 + "/modules/" + /* TODO */ 0 + "/courses/" + /* TODO */ 0 + "/classes/" + classPk + "/slides/" + slideEntity.getSlidePk();
	}
	
	@RequestMapping(value = "/delete/{slidePk}", method = RequestMethod.GET)
	public String getDeleteById(@PathVariable int slidePk, Model model) {
		SlideEntity slideEntity = slideService.findOne(slidePk);
		
		model.addAttribute("slideEntity", slideEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/delete/{slidePk}", method = RequestMethod.POST)
	public String postDeleteById(@PathVariable int slidePk) {
		SlideEntity slideEntity = slideService.findOne(slidePk);
		
		slideService.destroy(slideEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/edit/{slidePk}", method = RequestMethod.GET)
	public String getEditById(@PathVariable int slidePk, Model model) {
		SlideEntity slideEntity = slideService.findOne(slidePk);
		
		model.addAttribute("slideEntity", slideEntity);
		
		return EDIT_URI;
	}
	
	@RequestMapping(value = "/edit/{slidePk}", method = RequestMethod.POST)
	public String postEditById(@PathVariable int slidePk) {
		SlideEntity slideEntity = slideService.findOne(slidePk);
		
		slideService.update(slideEntity);
		
		return EDIT_URI;
	}
}
