package se.brightstep.demowebapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import se.brightstep.demowebapp.dao.impl.Bet;
import se.brightstep.demowebapp.service.BettingService;
import se.brightstep.demowebapp.service.MatchService;
import se.brightstep.demowebapp.service.UserService;


@Controller
@RequestMapping(value = "/")
public class BetController extends SuperclassController{
	
	@Autowired
	private MatchService matchService;
	
	@Autowired
	private BettingService bettingService;
	

	@RequestMapping(value = "login/bet", method = RequestMethod.POST)
	public ModelAndView bet(@RequestParam("match_id") int matchID,
							@RequestParam("home_team_score") int homeScore,
							@RequestParam("away_team_score") int awayScore)
	{
		int userID = userSession.getUser().getID();
		
		System.out.println(matchID + " : " + homeScore + " - " + awayScore + " Userid: " + userID);
		
		Bet bet = new Bet();
		bet.setBetHomeScore(homeScore);
		bet.setBetAwayScore(awayScore);
		bet.setMatchID(matchID);
		bet.setUserID(userID);
		
		bettingService.placeBet(bet);
		
		List<Bet> allBets = bettingService.getAllBets();
		
		/*
		for(Bet tmpbet : allBets){
			System.out.println("BetId: " + tmpbet.getID() + " Home: " + tmpbet.getHomeScore() + "  Away: " + tmpbet.getAwayScore());
		}
		*/
		/*
		ModelAndView modelAndView;
		
		modelAndView = new ModelAndView("homeview");
		modelAndView.addObject("matches" , matchService.getAllMatches());
		modelAndView.addObject("bets" , bettingService.getAllBets());
		*/
		
		return new ModelAndView("homeview");
	}
	
	

}
