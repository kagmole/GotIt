package ch.hearc.gotit.controllers;

import ch.hearc.gotit.entities.EmployeeEntity;
import ch.hearc.gotit.entities.EventEntity;
import ch.hearc.gotit.entities.ModuleEntity;
import ch.hearc.gotit.entities.StudentEntity;
import ch.hearc.gotit.entities.TrainingEntity;
import ch.hearc.gotit.services.EmployeeService;
import ch.hearc.gotit.services.EventService;
import ch.hearc.gotit.services.ModuleService;
import ch.hearc.gotit.services.StudentService;
import ch.hearc.gotit.services.TrainingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ajax")
public class AjaxController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TrainingService trainingService;
	
	@RequestMapping(value = "/schools/{schoolPk}/employees")
	public List<EmployeeEntity> getEmployeesEntitiesListWithSchoolEntity(
			@PathVariable int schoolPk,
			@RequestParam(required = false) int offset,
			@RequestParam(required = false) int limit) {
		
		return employeeService.findRangeWithSchool(schoolPk, offset, limit);
	}
	
	@RequestMapping(value = "/schools/{schoolPk}/events")
	public List<EventEntity> getEventsEntitiesListWithSchoolEntity(
			@PathVariable int schoolPk,
			@RequestParam(required = false) int offset,
			@RequestParam(required = false) int limit) {
		
		return eventService.findRangeWithSchool(schoolPk, offset, limit);
	}
	
	@RequestMapping(value = "/schools/{schoolPk}/modules")
	public List<ModuleEntity> getModulesEntitiesListWithSchoolEntity(
			@PathVariable int schoolPk,
			@RequestParam(required = false) int offset,
			@RequestParam(required = false) int limit) {
		
		return moduleService.findRangeWithSchool(schoolPk, offset, limit);
	}
	
	@RequestMapping(value = "/schools/{schoolPk}/students")
	public List<StudentEntity> getStudentsEntitiesListWithSchoolEntity(
			@PathVariable int schoolPk,
			@RequestParam(required = false) int offset,
			@RequestParam(required = false) int limit) {
		
		return studentService.findRangeWithSchool(schoolPk, offset, limit);
	}
	
	@RequestMapping(value = "/schools/{schoolPk}/trainings")
	public List<TrainingEntity> getTrainingsEntitiesListWithSchoolEntity(
			@PathVariable int schoolPk,
			@RequestParam(required = false) int offset,
			@RequestParam(required = false) int limit) {
		
		return trainingService.findRangeWithSchool(schoolPk, offset, limit);
	}
}
