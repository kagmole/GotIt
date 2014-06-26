package ch.hearc.gotit.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.hearc.gotit.entities.UserEntity;
import ch.hearc.gotit.services.UserService;

@Controller
@RequestMapping(value = "")
public class StaticController {
	
	private static final String START_URI = "standards/statics/";
	
	private static final String HOME_URI = START_URI + "home";
	private static final String ABOUT_URI = START_URI + "about";
	private static final String CONTACT_URI = START_URI + "contact";
	private static final String SIGN_IN_URI = START_URI + "sign_in";
	private static final String SIGN_UP_URI = START_URI + "sign_up";
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome() {
		return HOME_URI;
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String getAbout() {
		return ABOUT_URI;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String getContact() {
		return CONTACT_URI;
	}
	
	@RequestMapping(value = "/sign-in", method = RequestMethod.GET)
	public String getSignIn(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("errorMessage", "Wrong username or password");
		}
		
		return SIGN_IN_URI;
	}
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String getSignUp(Model model) {
		model.addAttribute("userEntity", new UserEntity());
		
		return SIGN_UP_URI;
	}
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public String postSignUp(@Valid UserEntity userEntity, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errorMessage", "One or more fields are not filled correctly");
			
			return SIGN_UP_URI;
		}
		
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		userEntity.setConfirmPassword(userEntity.getPassword());
		userService.create(userEntity);
		
		return "redirect:/users/" + userEntity.getUserPk();
	}
}
