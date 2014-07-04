package ch.hearc.gotit.controllers;

import javax.validation.Valid;

import ch.hearc.gotit.entities.CourseEntity;
import ch.hearc.gotit.services.CourseService;
import ch.hearc.gotit.services.ModuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/schools/{schoolPk}/modules/{modulePk}/courses")
public class CourseController {

	private static final String START_URI = "standards/schools/modules/courses/";
	
	private static final String LIST_URI = START_URI + "list";
	private static final String VIEW_URI = START_URI + "view";
	private static final String ADD_URI = START_URI + "add";
	private static final String DELETE_URI = START_URI + "delete";
	private static final String EDIT_URI = START_URI + "edit";
	
	private static final int COURSES_PER_PAGE = 10;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getList(
			@PathVariable int modulePk,
			@RequestParam(value = "page", required = false) Integer page,
			Model model) {
		
		if (page == null) {
			page = 1;
		}
		
		int lastPageNumber = 1 + courseService.count() / COURSES_PER_PAGE;
		
		model.addAttribute("currentPageNumber", page);
		model.addAttribute("lastPageNumber", lastPageNumber);
		model.addAttribute("moduleEntity", moduleService.findOne(modulePk));
		model.addAttribute("coursesEntitiesList", courseService.findRangeWithModule(modulePk, (page - 1) * COURSES_PER_PAGE, COURSES_PER_PAGE));
		
		return LIST_URI;
	}
	
	@RequestMapping(value = "/{coursePk}", method = RequestMethod.GET)
	public String getViewById(@PathVariable int coursePk, Model model) {
		model.addAttribute("courseEntity", courseService.findOne(coursePk));
		
		return VIEW_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		model.addAttribute("courseEntity", new CourseEntity());
		
		return ADD_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(@PathVariable int modulePk, @Valid CourseEntity courseEntity, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return ADD_URI;
		}
		
		courseEntity.setModule(moduleService.findOne(modulePk));
		courseService.create(courseEntity);
		
		return "redirect:/schools/" + /* TODO */ 0 + "/modules/" + modulePk + "/courses/" + courseEntity.getCoursePk();
	}
	
	@RequestMapping(value = "/delete/{coursePk}", method = RequestMethod.GET)
	public String getDeleteById(@PathVariable int coursePk, Model model) {
		CourseEntity courseEntity = courseService.findOne(coursePk);
		
		model.addAttribute("courseEntity", courseEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/delete/{coursePk}", method = RequestMethod.POST)
	public String postDeleteById(@PathVariable int coursePk) {
		CourseEntity courseEntity = courseService.findOne(coursePk);
		
		courseService.destroy(courseEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/edit/{coursePk}", method = RequestMethod.GET)
	public String getEditById(@PathVariable int coursePk, Model model) {
		CourseEntity courseEntity = courseService.findOne(coursePk);
		
		model.addAttribute("courseEntity", courseEntity);
		
		return EDIT_URI;
	}
	
	@RequestMapping(value = "/edit/{coursePk}", method = RequestMethod.POST)
	public String postEditById(@PathVariable int coursePk) {
		CourseEntity courseEntity = courseService.findOne(coursePk);
		
		courseService.update(courseEntity);
		
		return EDIT_URI;
	}
}
