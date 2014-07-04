package ch.hearc.gotit.controllers;

import ch.hearc.gotit.entities.UserEntity;
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
@RequestMapping(value = "/users")
public class UserController {
	
	private static final String START_URI = "standards/users/";
	
	private static final String LIST_URI = START_URI + "list";
	private static final String VIEW_URI = START_URI + "view";
	private static final String EDIT_URI = START_URI + "edit";
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getList(Model model) {
		model.addAttribute("usersEntitiesList", userService.findAll());
		
		return LIST_URI;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getViewById(@PathVariable int id) {
		return VIEW_URI;
	}
	
	@RequestMapping(value = "/edit/{userPk}", method = RequestMethod.GET)
	public String getEditById(@PathVariable int userPk, Model model) {
		UserEntity userEntity = userService.findOne(userPk);
		
		if (userEntity == null) {
			return "redirect:/users";
		}
		
		model.addAttribute("userEntity", userEntity);
		
		return EDIT_URI;
	}
	
	@RequestMapping(value = "/edit/{userPk}", method = RequestMethod.POST)
	public String postEditById(@PathVariable int userPk, @Valid UserEntity userEntity, BindingResult result) {
		if (result.hasErrors()) {
			return EDIT_URI;
		}
		
		userEntity.setUserPk(userPk);
		userService.update(userEntity);
		
		return "redirect:/users/" + userEntity.getUserPk();
	}
}
