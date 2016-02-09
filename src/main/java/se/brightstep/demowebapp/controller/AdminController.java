package se.brightstep.demowebapp.controller;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import se.brightstep.demowebapp.dao.impl.Match;
import se.brightstep.demowebapp.service.AdminMatchService;
import se.brightstep.demowebapp.service.BettingService;
import se.brightstep.demowebapp.service.UserService;
import se.brightstep.demowebapp.session.UserSession;


@Controller
@RequestMapping(value = "/login")
public class AdminController extends SuperclassController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserService matchService;
	
	@Autowired
	private AdminMatchService adminMatchService;
		
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
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
	
	
	@RequestMapping(value = "/admin/addMatches", method = RequestMethod.POST)
	public ModelAndView addMatches(@RequestParam("fileName") String fileName)
	{
		ArrayList<Match> allMatches = adminMatchService.readMatchesFromFile("./resources/input/" + fileName);
		
		adminMatchService.addNewMatchesToDatabase(allMatches);
		
		return new ModelAndView("adminview");
	
	}
	
	
	

}
