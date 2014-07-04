package ch.hearc.gotit.controllers;

import javax.validation.Valid;

import ch.hearc.gotit.entities.ClassEntity;
import ch.hearc.gotit.services.ClassService;
import ch.hearc.gotit.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/schools/{schoolPk}/modules/{modulePk}/courses/{coursePk}/classes")
public class ClassController {

	private static final String START_URI = "standards/schools/modules/courses/classes/";
	
	private static final String LIST_URI = START_URI + "list";
	private static final String VIEW_URI = START_URI + "view";
	private static final String ADD_URI = START_URI + "add";
	private static final String DELETE_URI = START_URI + "delete";
	private static final String EDIT_URI = START_URI + "edit";
	
	private static final int CLASSES_PER_PAGE = 10;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getList(
			@PathVariable int coursePk,
			@RequestParam(value = "page", required = false) Integer page,
			Model model) {
		
		if (page == null) {
			page = 1;
		}
		
		int lastPageNumber = 1 + classService.count() / CLASSES_PER_PAGE;
		
		model.addAttribute("currentPageNumber", page);
		model.addAttribute("lastPageNumber", lastPageNumber);
		model.addAttribute("courseEntity", courseService.findOne(coursePk));
		model.addAttribute("classesEntitiesList", classService.findRangeWithCourse(coursePk, (page - 1) * CLASSES_PER_PAGE, CLASSES_PER_PAGE));
		
		return LIST_URI;
	}
	
	@RequestMapping(value = "/{classPk}", method = RequestMethod.GET)
	public String getViewById(@PathVariable int classPk, Model model) {
		model.addAttribute("classEntity", classService.findOne(classPk));
		
		return VIEW_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		model.addAttribute("classEntity", new ClassEntity());
		
		return ADD_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(@PathVariable int coursePk, @Valid ClassEntity classEntity, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return ADD_URI;
		}
		
		classEntity.setCourse(courseService.findOne(coursePk));
		classService.create(classEntity);
		
		return "redirect:/schools/" + /* TODO */ 0 + "/modules/" + /* TODO */ 0 + "/courses/" + coursePk + "/classes/" + classEntity.getClassPk();
	}
	
	@RequestMapping(value = "/delete/{classPk}", method = RequestMethod.GET)
	public String getDeleteById(@PathVariable int classPk, Model model) {
		ClassEntity classEntity = classService.findOne(classPk);
		
		model.addAttribute("classEntity", classEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/delete/{classPk}", method = RequestMethod.POST)
	public String postDeleteById(@PathVariable int classPk) {
		ClassEntity classEntity = classService.findOne(classPk);
		
		classService.destroy(classEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/edit/{classPk}", method = RequestMethod.GET)
	public String getEditById(@PathVariable int classPk, Model model) {
		ClassEntity classEntity = classService.findOne(classPk);
		
		model.addAttribute("classEntity", classEntity);
		
		return EDIT_URI;
	}
	
	@RequestMapping(value = "/edit/{classPk}", method = RequestMethod.POST)
	public String postEditById(@PathVariable int classPk) {
		ClassEntity classEntity = classService.findOne(classPk);
		
		classService.update(classEntity);
		
		return EDIT_URI;
	}
}
