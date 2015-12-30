package se.brightstep.demowebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import se.brightstep.demowebapp.service.ExampleService;
import se.brightstep.demowebapp.service.UserService;


@Controller
@RequestMapping(value = "/")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login()
	{
		return new ModelAndView("loginview");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam String username, 
										@RequestParam String password)
	{
		
	
		if((username.equals("") || password.equals(""))){
			return new ModelAndView("loginview");
		}
		
		if(userService.login(username, password)){
			return new ModelAndView("homeview");
		}
		
		return new ModelAndView("loginview");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView regiter()
	{
		return new ModelAndView("registerview");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam String username, 
										@RequestParam String password,
										@RequestParam String email)
	{
		
		if((username.equals("") || password.equals("") || email.equals("")) || userService.login(username, password)){
			return new ModelAndView("loginview");
			//Kanske skicka med nån parameter som viasr att registreringen inte blev av
		}
		
		createUser(username, password, email);
		
		return new ModelAndView("startview");
	}
	
	private boolean createUser(String username, String password, String email){
		
		return userService.createUser(username, password, email);
	}
	
	
	
}
