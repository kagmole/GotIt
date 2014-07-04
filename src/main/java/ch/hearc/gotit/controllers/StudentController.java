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

import ch.hearc.gotit.entities.StudentEntity;
import ch.hearc.gotit.services.SchoolService;
import ch.hearc.gotit.services.StudentService;

@Controller
@RequestMapping(value = "/schools/{schoolPk}/students")
public class StudentController {
	
	private static final String START_URI = "standards/schools/students/";
	
	private static final String LIST_URI = START_URI + "list";
	private static final String VIEW_URI = START_URI + "view";
	private static final String ADD_URI = START_URI + "add";
	private static final String DELETE_URI = START_URI + "delete";
	private static final String EDIT_URI = START_URI + "edit";
	
	private static final int STUDENTS_PER_PAGE = 10;
	
	@Autowired
	private StudentService studentService;
	
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
		
		int lastPageNumber = 1 + studentService.count() / STUDENTS_PER_PAGE;
		
		model.addAttribute("currentPageNumber", page);
		model.addAttribute("lastPageNumber", lastPageNumber);
		model.addAttribute("schoolEntity", schoolService.findOne(schoolPk));
		model.addAttribute("studentsEntitiesList", studentService.findRangeWithSchool(schoolPk, (page - 1) * STUDENTS_PER_PAGE, STUDENTS_PER_PAGE));
		
		return LIST_URI;
	}
	
	@RequestMapping(value = "/{studentPk}", method = RequestMethod.GET)
	public String getViewById(@PathVariable int studentPk, Model model) {
		model.addAttribute("studentEntity", studentService.findOne(studentPk));
		
		return VIEW_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		model.addAttribute("studentEntity", new StudentEntity());
		
		return ADD_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(@PathVariable int schoolPk, @Valid StudentEntity studentEntity, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return ADD_URI;
		}
		
		// TODO set school?
		studentService.create(studentEntity);
		
		return "redirect:/schools/" + schoolPk + "/students/" + studentEntity.getStudentPk();
	}
	
	@RequestMapping(value = "/delete/{studentPk}", method = RequestMethod.GET)
	public String getDeleteById(@PathVariable int studentPk, Model model) {
		StudentEntity studentEntity = studentService.findOne(studentPk);
		
		model.addAttribute("studentEntity", studentEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/delete/{studentPk}", method = RequestMethod.POST)
	public String postDeleteById(@PathVariable int studentPk) {
		StudentEntity studentEntity = studentService.findOne(studentPk);
		
		studentService.destroy(studentEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/edit/{studentPk}", method = RequestMethod.GET)
	public String getEditById(@PathVariable int studentPk, Model model) {
		StudentEntity studentEntity = studentService.findOne(studentPk);
		
		model.addAttribute("studentEntity", studentEntity);
		
		return EDIT_URI;
	}
	
	@RequestMapping(value = "/edit/{studentPk}", method = RequestMethod.POST)
	public String postEditById(@PathVariable int studentPk) {
		StudentEntity studentEntity = studentService.findOne(studentPk);
		
		studentService.update(studentEntity);
		
		return EDIT_URI;
	}
}
