package se.brightstep.demowebapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import se.brightstep.demowebapp.dao.impl.Bet;
import se.brightstep.demowebapp.dao.impl.Match;
import se.brightstep.demowebapp.service.BettingService;
import se.brightstep.demowebapp.service.MatchService;
import se.brightstep.demowebapp.service.ScoreService;
import se.brightstep.demowebapp.service.UserService;
import se.brightstep.demowebapp.session.UserSession;



@Controller
@RequestMapping(value = "/")
public class LoginController extends SuperclassController{
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login()
	{
		return new ModelAndView("loginview");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,
								@RequestParam("password") String password)
	{
		ModelAndView modelAndView;
		if(userService.login(username, password)){
			modelAndView = new ModelAndView("homeview");
			int round = matchService.getCurrentRound();
			userSession.setRound(round);
			addBetsAndMatchesToModel(modelAndView, userSession.getRound());
			return modelAndView;
		}
		
		modelAndView = new ModelAndView("loginview");
		modelAndView.addObject("message", "Användaren med angivet lösenord fanns inte");
		
		
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
		
		ModelAndView modelAndView;
		
		if(createUser(username, password, email)){
			modelAndView = new ModelAndView("homeview");
			addBetsAndMatchesToModel(modelAndView, userSession.getRound());
			return modelAndView;
			
		}
		
		modelAndView = new ModelAndView("registerview");
		modelAndView.addObject("message", "Användaren kunde inte skapas");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/login/update", method = RequestMethod.POST)
	public ModelAndView updateRound(@RequestParam("quantity[101]") int q)
	{
		
		ModelAndView modelAndView;
		modelAndView = new ModelAndView("homeview");
		addBetsAndMatchesToModel(modelAndView, q);
		
		return modelAndView;
		
	}
	
	private boolean createUser(String username, String password, String email){
		
		return userService.createUser(username, password, email);
	}
	
	
	
	
	
}
