package org.perscholas.budgeting.controller;

import java.util.List;
import java.util.Map;

import org.perscholas.budgeting.entity.User;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/*IndexController class controls the flow of data for main business page, a part of MVC pattern*/
@Controller
@SessionAttributes("user")
public class IndexController {
	@Autowired UserService userService;

	@RequestMapping("/")
	public ModelAndView home()
	{
	    ModelAndView mav = new ModelAndView("index");
	    return mav;
	}

}
