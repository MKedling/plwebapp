package se.brightstep.demowebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import se.brightstep.demowebapp.service.BettingService;
import se.brightstep.demowebapp.service.UserService;
import se.brightstep.demowebapp.session.UserSession;


@Controller
@RequestMapping(value = "/")
public class AdminController extends SuperclassController{
	
	@Autowired
	private UserService userService;
		
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public ModelAndView isAdmin()
	{
		
		System.out.println(userSession.getUser().getUsername());
		
		return new ModelAndView("adminview");
	
		/*
		if(userService.isAdmin(username, password)){
			return new ModelAndView("adminview");
		}
		
		return new ModelAndView("loginview");
		*/
	}
	

}
