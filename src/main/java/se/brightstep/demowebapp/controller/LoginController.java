package se.brightstep.demowebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import se.brightstep.demowebapp.service.ExampleService;
import se.brightstep.demowebapp.service.UserService;
import se.brightstep.demowebapp.session.UserSession;


@Controller
@RequestMapping(value = "/")
public class LoginController extends SuperclassController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login()
	{
		return new ModelAndView("loginview");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,
								@RequestParam("password") String password)
	{

		if(userService.login(username, password)){
			return new ModelAndView("homeview");
		}
		
		ModelAndView modelAndView = new ModelAndView("loginview");
		modelAndView.addObject("message", "Anv�ndaren med angivet l�senord fanns inte");
		
		
		return modelAndView;
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
		
		if(createUser(username, password, email)){
			return new ModelAndView("homeview");
		}
		
		ModelAndView modelAndView = new ModelAndView("registerview");
		modelAndView.addObject("message", "Anv�ndaren kunde inte skapas");
		
		return modelAndView;
		
	}
	
	private boolean createUser(String username, String password, String email){
		
		return userService.createUser(username, password, email);
	}
	
	
	
}
