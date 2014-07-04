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

import ch.hearc.gotit.entities.TrainingEntity;
import ch.hearc.gotit.services.SchoolService;
import ch.hearc.gotit.services.TrainingService;

@Controller
@RequestMapping(value = "/schools/{schoolPk}/trainings")
public class TrainingController {

	private static final String START_URI = "standards/schools/trainings/";
	
	private static final String LIST_URI = START_URI + "list";
	private static final String ADD_URI = START_URI + "add";
	private static final String DELETE_URI = START_URI + "delete";
	private static final String EDIT_URI = START_URI + "edit";
	private static final String VIEW_URI = START_URI + "view";
	
	private static final int TRAININGS_PER_PAGE = 10;
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private TrainingService trainingService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getList(
			@PathVariable int schoolPk,
			@RequestParam(value = "page", required = false) Integer page,
			Model model) {
		
		if (page == null) {
			page = 1;
		}
		
		int lastPageNumber = 1 + trainingService.count() / TRAININGS_PER_PAGE;
		
		model.addAttribute("currentPageNumber", page);
		model.addAttribute("lastPageNumber", lastPageNumber);
		model.addAttribute("schoolEntity", schoolService.findOne(schoolPk));
		model.addAttribute("trainingsEntitiesList", trainingService.findRangeWithSchool(schoolPk, (page - 1) * TRAININGS_PER_PAGE, TRAININGS_PER_PAGE));
		
		return LIST_URI;
	}
	
	@RequestMapping(value = "/{trainingPk}", method = RequestMethod.GET)
	public String getViewById(@PathVariable int trainingPk, Model model) {
		model.addAttribute("trainingEntity", trainingService.findOne(trainingPk));
		
		return VIEW_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		model.addAttribute("trainingEntity", new TrainingEntity());
		
		return ADD_URI;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(@PathVariable int schoolPk, @Valid TrainingEntity trainingEntity, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return ADD_URI;
		}
		
		trainingEntity.setSchool(schoolService.findOne(schoolPk));
		trainingService.create(trainingEntity);
		
		return "redirect:/schools/" + schoolPk + "/trainings/" + trainingEntity.getTrainingPk();
	}
	
	@RequestMapping(value = "/delete/{trainingPk}", method = RequestMethod.GET)
	public String getDeleteById(@PathVariable int trainingPk, Model model) {
		TrainingEntity trainingEntity = trainingService.findOne(trainingPk);
		
		model.addAttribute("trainingEntity", trainingEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/delete/{trainingPk}", method = RequestMethod.POST)
	public String postDeleteById(@PathVariable int trainingPk) {
		TrainingEntity trainingEntity = trainingService.findOne(trainingPk);
		
		trainingService.destroy(trainingEntity);
		
		return DELETE_URI;
	}
	
	@RequestMapping(value = "/edit/{trainingPk}", method = RequestMethod.GET)
	public String getEditById(@PathVariable int trainingPk, Model model) {
		TrainingEntity trainingEntity = trainingService.findOne(trainingPk);
		
		model.addAttribute("trainingEntity", trainingEntity);
		
		return EDIT_URI;
	}
	
	@RequestMapping(value = "/edit/{trainingPk}", method = RequestMethod.POST)
	public String postEditById(@PathVariable int trainingPk) {
		TrainingEntity trainingEntity = trainingService.findOne(trainingPk);
		
		trainingService.update(trainingEntity);
		
		return EDIT_URI;
	}
}
