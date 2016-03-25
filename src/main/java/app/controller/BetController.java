package app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.dto.Bet;
import app.service.BettingService;
import app.service.MatchService;
import app.service.UserService;


@Controller
@RequestMapping(value = "/home")
public class BetController extends SuperclassController{
	
	@Autowired
	private MatchService matchService;
	
	@Autowired
	private BettingService bettingService;
	

	@RequestMapping(value = "/getStartedBetsRound", method = RequestMethod.GET)
	public ModelAndView correctedBetsRound(@RequestParam("userID") int userID,
											@RequestParam("round") int round)
	{
		
		ModelAndView modelAndView = new ModelAndView("completedMatch");
		//Change name of model attribute
		
		List<Bet> allCompletedBets = bettingService.getAllStartedBetsRound(userID, round);
		modelAndView.addObject("allCompletedBets", scoreService.correctBets(allCompletedBets));
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/getCorrectedBetsAll", method = RequestMethod.GET)
	public ModelAndView allCorrectedBets(@RequestParam("userID") int userID)
	{
		
		ModelAndView modelAndView = new ModelAndView("completedMatch");
		
		List<Bet> allCompletedBets = bettingService.getAllCompletedBets(userID);
		modelAndView.addObject("allCompletedBets", scoreService.correctBets(allCompletedBets));
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/getBetsRound", method = RequestMethod.GET)
	public ModelAndView betsRound(@RequestParam("round") int round)
	{

		ModelAndView modelAndView = new ModelAndView("completedMatch");
		//Change name of model attribute
		
		List<Bet> allCompletedBets = bettingService.getAllBetsRound(userSession.getUser().getID(), round);
		modelAndView.addObject("allCompletedBets", scoreService.correctBets(allCompletedBets));
		
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/ajaxBet", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxBet(@RequestParam("match_id") int matchID,
							@RequestParam("score_home") int homeScore,
							@RequestParam("score_away") int awayScore,
							@RequestParam("round") int round)
	{
		int userID = userSession.getUser().getID();
		
		Bet bet = new Bet();
		bet.setBetHomeScore(homeScore);
		bet.setBetAwayScore(awayScore);
		bet.setMatchID(matchID);
		bet.setUserID(userID);
		
		
		if (bettingService.placeBet(bet)){
			return new ResponseEntity<String>(HttpStatus.OK);
	    }
	    else{
	    	return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	    }
	
	}
	
	
	
	
	

}
