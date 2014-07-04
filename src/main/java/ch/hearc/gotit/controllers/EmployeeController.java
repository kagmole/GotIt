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

import ch.hearc.gotit.entities.EmployeeEntity;
import ch.hearc.gotit.services.EmployeeService;
import ch.hearc.gotit.services.SchoolService;

@Controller
@RequestMapping(value = "/schools/{schoolPk}/employees")
public class EmployeeController {
	
	private static final String START_URI = "standards/schools/employees/";
	
	private static final String LIST_URI = START_URI + "list";
	private static final String VIEW_URI = START_URI + "view";
	private static final String ADD_URI = START_URI + "add";
	private static final String DELETE_URI = START_URI + "delete";
	private static final String EDIT_URI = START_URI + "edit";
	
	private static final int EMPLOYEES_PER_PAGE = 10;
	
	@Autowired
	private EmployeeService employeeService;
	
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
		
		int lastPageNumber = 1 + employeeService.count() / EMPLOYEES_PER_PAGE;
		
		model.addAttribute("currentPageNumber", page);
		model.addAttribute("lastPageNumber", lastPageNumber);
		model.addAttribute("schoolEntity", schoolService.findOne(schoolPk));
		model.addAttribute("employeesEntitiesList", employeeService.findRangeWithSchool(schoolPk, (page - 1) * EMPLOYEES_PER_PAGE, EMPLOYEES_PER_PAGE));
		
		return LIST_URI;
	}
	
	@RequestMapping(value = "/{employeePk}", method = RequestMethod.GET)
	public String getViewById(@PathVariable int employeePk, Model model) {
		model.addAttribute("employeeEntity", employeeService.findOne(employeePk));
		
		return VIEW_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		model.addAttribute("employeeEntity", new EmployeeEntity());
		
		return ADD_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(@PathVariable int schoolPk, @Valid EmployeeEntity employeeEntity, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return ADD_URI;
		}
		
		// TODO set school? (impl. forms system)
		employeeService.create(employeeEntity);
		
		return "redirect:/schools/" + schoolPk + "/employees/" + employeeEntity.getEmployeePk();
	}
	
	@RequestMapping(value = "/delete/{employeePk}", method = RequestMethod.GET)
	public String getDeleteById(@PathVariable int employeePk, Model model) {
		EmployeeEntity employeeEntity = employeeService.findOne(employeePk);
		
		model.addAttribute("employeeEntity", employeeEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/delete/{employeePk}", method = RequestMethod.POST)
	public String postDeleteById(@PathVariable int employeePk) {
		EmployeeEntity employeeEntity = employeeService.findOne(employeePk);
		
		employeeService.destroy(employeeEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/edit/{employeePk}", method = RequestMethod.GET)
	public String getEditById(@PathVariable int employeePk, Model model) {
		EmployeeEntity employeeEntity = employeeService.findOne(employeePk);
		
		model.addAttribute("employeeEntity", employeeEntity);
		
		return EDIT_URI;
	}
	
	@RequestMapping(value = "/edit/{employeePk}", method = RequestMethod.POST)
	public String postEditById(@PathVariable int employeePk) {
		EmployeeEntity employeeEntity = employeeService.findOne(employeePk);
		
		employeeService.update(employeeEntity);
		
		return EDIT_URI;
	}
}
