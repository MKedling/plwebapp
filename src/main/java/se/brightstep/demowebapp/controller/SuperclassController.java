package se.brightstep.demowebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ModelAndView;

import se.brightstep.demowebapp.dto.Bet;
import se.brightstep.demowebapp.dto.json.Match;
import se.brightstep.demowebapp.service.BettingService;
import se.brightstep.demowebapp.service.EmailService;
import se.brightstep.demowebapp.service.MatchDayService;
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
	
	@Autowired
	protected EmailService emailService;
	
	@Autowired
	protected MatchDayService matchDayService;
	
	@Autowired
	protected PasswordEncoder passwordEncoder;
	
	
	public void addBetsAndMatchesToModel(ModelAndView modelAndView, int roundToView){
		
		List<Bet> allBets = bettingService.getAllBets(userSession.getUser().getID());
		List<Bet> allBetsRound = bettingService.getAllBetsRound(userSession.getUser().getID(), roundToView);
		List<Bet> allCompletedBets = bettingService.getAllCompletedBets(userSession.getUser().getID());
		List<Bet> allCompletedBetsRound = bettingService.getAllCompletedBetsRound(userSession.getUser().getID(), roundToView);
		
		List<Match> matchesToBet = matchService.getAllMatchesToBet(roundToView);
		
		modelAndView.addObject("bets" , allBets);
		modelAndView.addObject("allBetsRound" , allBetsRound);
		modelAndView.addObject("allCompletedBets" , allCompletedBets);
		modelAndView.addObject("allCompletedBetsRound" , allCompletedBetsRound);
		
		modelAndView.addObject("matchesToBet" , matchesToBet);
		modelAndView.addObject("currentRound" , userSession.getRound());
		modelAndView.addObject("roundToView" , roundToView);
		
		modelAndView.addObject("scoreRound" , scoreService.getRoundScore(userSession.getUser().getID(), roundToView));
		modelAndView.addObject("scoreTotal" , scoreService.getTotalScore(userSession.getUser().getID()));
		
		modelAndView.addObject("totalHighscore" , scoreService.getTotalHighscore());
		modelAndView.addObject("roundHighscore" , scoreService.getRoundHighscore(roundToView));

		modelAndView.addObject("roundHighscore" , scoreService.getRoundHighscore(roundToView));
		
		
		
	}
	

}
