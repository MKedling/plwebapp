package app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/")
public class LoginController extends SuperclassController{
	
	static final Logger LOG = LogManager.getLogger(LoginController.class.getName());

	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home()
	{
		
		ModelAndView modelAndView;
		modelAndView = new ModelAndView("homeview");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    userSession.setUser(userService.getUser(auth.getName()));
	
		userSession.setRound(matchService.getCurrentRound());
		addBetsAndMatchesToModel(modelAndView, userSession.getRound());
		
		return modelAndView;
		
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginas()
	{
		System.out.println("LOG: Login controller invoked");
		

		ModelAndView modelAndView;

		modelAndView = new ModelAndView("loginview");
		modelAndView.addObject("message", "Anvandaren med angivet losenord fanns inte");
		
	
		return modelAndView;
	}
	
	//den kors vid login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		System.out.println("LOG: Kor /Login controller");
		
		LOG.debug("This will be printed on debug");
        LOG.info("This will be printed on info");
        LOG.warn("This will be printed on warn");
        LOG.error("This will be printed on error");
        LOG.fatal("This will be printed on fatal");

        LOG.info("Appending string: {}.", "Hello, World");
		
		ModelAndView model = new ModelAndView();
		
		model.setViewName("loginview");

		return model;

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
		
		ModelAndView modelAndView;
		
		password = passwordEncoder.encode(password);
		if(createUser(username, password, email)){
			modelAndView = new ModelAndView("homeview");
			addBetsAndMatchesToModel(modelAndView, userSession.getRound());
			return modelAndView;
			
		}
		
		modelAndView = new ModelAndView("registerview");
		modelAndView.addObject("message", "Anvandaren kunde inte skapas");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView updateRound(@RequestParam("quantity[101]") int q)
	{
		
		ModelAndView modelAndView;
		modelAndView = new ModelAndView("homeview");
		
		int round = matchService.getCurrentRound();
		userSession.setRound(round);
		
		addBetsAndMatchesToModel(modelAndView, q);
		
		return modelAndView;
		
	}
	
	private boolean createUser(String username, String password, String email){
		return userService.createUser(username, password, email);
	}
	
	
	
}
