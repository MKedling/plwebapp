package se.brightstep.demowebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import se.brightstep.demowebapp.dao.impl.Bet;
import se.brightstep.demowebapp.dao.impl.Match;
import se.brightstep.demowebapp.service.BettingService;
import se.brightstep.demowebapp.service.MatchService;
import se.brightstep.demowebapp.service.ScoreService;
import se.brightstep.demowebapp.service.UserService;
import se.brightstep.demowebapp.session.UserSession;

public abstract class SuperclassController {
	
	@Autowired
	protected UserSession userSession;
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected BettingService bettingService;
	
	@Autowired
	protected MatchService matchService;
	
	@Autowired
	protected ScoreService scoreService;
	
	
	public void addBetsAndMatchesToModel(ModelAndView modelAndView){
		
		List<Bet> allBets = bettingService.getAllBets();
		List<Match> matchesToBet = matchService.getAllMatchesToBet();
		
		modelAndView.addObject("bets" , allBets);
		modelAndView.addObject("matchesToBet" , matchesToBet);
		modelAndView.addObject("round" , userSession.getRound());
		
		modelAndView.addObject("score" , scoreService.getScore());
	}
	

}
