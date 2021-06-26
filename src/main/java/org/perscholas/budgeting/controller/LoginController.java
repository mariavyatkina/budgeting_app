package org.perscholas.budgeting.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.perscholas.budgeting.entity.User;
import org.perscholas.budgeting.exception.PasswordDoesNotMatchEmailException;
import org.perscholas.budgeting.exception.UserAlreadyExistException;
import org.perscholas.budgeting.exception.UserDoesNotExistException;
import org.perscholas.budgeting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/*LoginController class controls the flow of data for user login, a part of MVC pattern*/
@Controller
@SessionAttributes({"command"})
@RequestMapping("/login")
public class LoginController {
	@Autowired
	UserService userService;
	@ModelAttribute
	public User command()
	{
		return new User();
	}
	@RequestMapping("/")
	public String loginForm(Map<String, Object> model) {
    	model.put("command", new User());
    	return "login";
	}
	@RequestMapping("register")
	public String registerRedirect()
	{
		return "redirect:/register/";
	}
	
	@PostMapping("/save")
	public String loginUser(@ModelAttribute("command") @Valid User user, BindingResult errors, Model model)  {

		try
		{
			userService.login(user);
		}
		catch(UserDoesNotExistException e) {
			errors.rejectValue("email", "user.email","An account for this email does not exist");
			return "login";
		} catch (PasswordDoesNotMatchEmailException e) {
			errors.rejectValue("password", "user.password","The password is incorrect");
			return "login";
		}

	    return "redirect:/account/";
	}
	@RequestMapping("main-page")
	public String mainPage()
	{
		return "redirect:/";
	}
}
