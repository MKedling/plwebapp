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
	public ModelAndView handleRequest()
	{
		final ModelAndView mav = new ModelAndView("loginview");//return example.jsp view
	
		
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView handleRequest(@RequestParam String username, 
										@RequestParam String password)
	{
		
		System.out.println(userService.login(username, password));
		
		if(!(username.equals("") || password.equals(""))){
			return new ModelAndView("startview");
		}
		
		
		return new ModelAndView("loginview");
	}
	
	
}
