package org.perscholas.budgeting.controller;

import java.util.Map;

import javax.validation.Valid;

import org.perscholas.budgeting.entity.User;
import org.perscholas.budgeting.exception.UserAlreadyExistException;
import org.perscholas.budgeting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/*RegistrationController class controls the flow of data for user registration, a part of MVC pattern*/
@Controller
@SessionAttributes({"command"})
@RequestMapping("/register")
public class RegistrationController {
	
	 @Autowired
	    private UserService userService;

	    @RequestMapping("/")
		public String registrationForm(Map<String, Object> model) {
	    	User user = new User();
	    	model.put("command", user);
	    	return "register";
		}
		@PostMapping(value = "/save")
		public String registerUser(@ModelAttribute("command") @Valid User user, BindingResult errors, Model model) {
			if(errors.hasErrors())
			{
				return "register";
			}
			try
			{
				userService.register(user);
			}
			catch(UserAlreadyExistException e) {
				errors.rejectValue("email", "user.email","An account for this email already exists.");
				return "register";
			}
		    return "redirect:/account/";
		}
		
		@RequestMapping("/login")
		public String loginRedirect()
		{
			return "redirect:/login/";
		}
	   
		@RequestMapping("main-page")
		public String mainPage()
		{
			return "redirect:/";
		}
}
