package se.brightstep.demowebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import se.brightstep.demowebapp.service.MatchService;


@Controller
@RequestMapping(value = "/")
public class BetController extends SuperclassController{
	
	@Autowired
	private MatchService matchService;

	
	@RequestMapping(value = "login/bet", method = RequestMethod.POST)
	public ModelAndView bet(@RequestParam("match_id") int matchID,
							@RequestParam("home_team_score") int homeScore,
							@RequestParam("away_team_score") int awayScore)
	{
		System.out.println(matchID + " : " + homeScore + " - " + awayScore);
		
		ModelAndView modelAndView;
		
		modelAndView = new ModelAndView("homeview");
		modelAndView.addObject("matches" , matchService.getAllMatches());
		
		return modelAndView;
	}
	
	
	

}
