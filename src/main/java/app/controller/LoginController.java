package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import app.dao.UserDAO;
import app.dto.Bet;
import app.json.Match;
import app.service.BettingService;
import app.service.MatchService;
import app.service.ScoreService;
import app.service.UserService;
import app.session.UserSession;



@Controller
@RequestMapping(value = "/")
public class LoginController extends SuperclassController{
	/*
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login()
	{
		return new ModelAndView("loginview");
	}
*/


	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginas(@RequestParam("username") String username,
								@RequestParam("password") String password)
	{
		System.out.println("LOG: Login controller invoked");
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
	*/

	
	
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
		modelAndView.addObject("message", "Användaren med angivet lösenord fanns inte");
		
	
		return modelAndView;
	}
	
	
	//den körs vid login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		System.out.println("LOG: Kör /Login controller");
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
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
		
		//password = new BCryptPasswordEncoder().encode(password);
		password = passwordEncoder.encode(password);
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
		
		int round = matchService.getCurrentRound();
		userSession.setRound(round);
		
		addBetsAndMatchesToModel(modelAndView, q);
		
		return modelAndView;
		
	}
	
	
	
	private boolean createUser(String username, String password, String email){
		
		return userService.createUser(username, password, email);
	}
	
	
	
	
	
}
