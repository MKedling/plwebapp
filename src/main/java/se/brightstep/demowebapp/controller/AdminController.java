package se.brightstep.demowebapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.brightstep.demowebapp.dao.UserDAO;
import se.brightstep.demowebapp.dto.Bet;
import se.brightstep.demowebapp.dto.json.Match;
import se.brightstep.demowebapp.dto.json.MatchDay;
import se.brightstep.demowebapp.service.AdminMatchService;
import se.brightstep.demowebapp.service.BettingService;
import se.brightstep.demowebapp.service.MatchService;
import se.brightstep.demowebapp.service.UserService;
import se.brightstep.demowebapp.session.UserSession;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


@Controller
@RequestMapping(value = "/login")
public class AdminController extends SuperclassController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MatchService matchService;
	
	@Autowired
	private AdminMatchService adminMatchService;
		
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView isAdmin()
	{
		ModelAndView modelAndView = new ModelAndView("adminview");
		List<Match> matchesToAddResult = matchService.getAllMatchesToAddResult();
		
		modelAndView.addObject("matchesToAddResult" , matchesToAddResult);
		
		return modelAndView;
	
		/*
		if(userService.isAdmin(username, password)){
			return new ModelAndView("adminview");
		}
		
		return new ModelAndView("loginview");
		*/
	}
	
	@RequestMapping(value = "/admin/addResult", method = RequestMethod.POST)
	public ModelAndView addResult(@RequestParam("match_id") int matchID,
							@RequestParam("score_home[1]") int homeScore,
							@RequestParam("score_away[1]") int awayScore)
	{
		
		matchService.addResult(matchID, homeScore, awayScore);
		
		ModelAndView modelAndView = new ModelAndView("adminview");
		List<Match> matchesToAddResult = matchService.getAllMatchesToAddResult();
		
		modelAndView.addObject("matchesToAddResult" , matchesToAddResult);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/addNewMatches", method = RequestMethod.POST)
	public ModelAndView addNewMatches(@RequestParam("round") int round)
	{
		for(int i = 1 ; i < 39 ; i ++){
			adminMatchService.addNewMatchesToDatabase(new ArrayList<Match>(matchDayService.getAllMatchesFromMatchDay(i)));
		}
		ModelAndView modelAndView = new ModelAndView("adminview");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/addResultMatchDay", method = RequestMethod.POST)
	public ModelAndView addMatchDayResults(@RequestParam("matchDay") int matchDay)
	{
		
		for(Match match : matchDayService.getAllMatchesFromMatchDay(matchDay)){
			matchService.addResult(match);
		}
		
		System.out.println(matchDayService.getMatchDaysToAddResult());
			
		ModelAndView modelAndView = new ModelAndView("adminview");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/addBets", method = RequestMethod.POST)
	public ModelAndView addBe() throws FileNotFoundException, IOException
	{
		HashMap<String, String> teamName = new HashMap<String, String>();
		teamName.put("Manchester U", "Manchester United FC");
		teamName.put("Tottenham", "Tottenham Hotspur FC");
		teamName.put("Everton", "Everton FC");
		teamName.put("Bournemouth", "AFC Bournemouth");
		teamName.put("Aston Villa", "Aston Villa FC");
		teamName.put("Leicester", "Leicester City FC");
		teamName.put("Sunderland", "Sunderland AFC");
		teamName.put("Norwich", "Norwich City FC");
		teamName.put("Chelsea", "Chelsea FC");
		teamName.put("Arsenal", "Arsenal FC");
		
		teamName.put("Swansea", "Swansea City FC");
		teamName.put("West Ham", "West Ham United FC");
		teamName.put("Newcastle", "Newcastle United FC");
		teamName.put("Southampton", "Southampton FC");
		teamName.put("Stoke", "Stoke City FC");
		teamName.put("Liverpool", "Liverpool FC");
		teamName.put("Manchester C", "Manchester City FC");
		teamName.put("Crystal Palace", "Crystal Palace FC");
		teamName.put("Watford", "Watford FC");
		teamName.put("WBA", "West Bromwich Albion FC");
		
		try (BufferedReader br = new BufferedReader(new FileReader("./resources/input/Premier League-tipp2.csv"))) {
		    String line;
		    
		    int userId = userService.getUserId(br.readLine());
		    while ((line = br.readLine()) != null) {
		    	try{
			    	String[] arr = line.split(";");
			    	String homeTeam = arr[0];
			    	int homeScore = Integer.parseInt(arr[1]);
			    	
			    	line =  br.readLine();
			    	arr = line.split(";");
			    	String awayTeam = arr[0];
			    	int awayScore = Integer.parseInt(arr[1]);
			    	
			    	Match match = matchService.getMatch(teamName.get(homeTeam), teamName.get(awayTeam));
			    	
			    	Bet bet = new Bet();
					bet.setBetHomeScore(homeScore);
					bet.setBetAwayScore(awayScore);
					bet.setMatchID(match.getID());
					bet.setUserID(userId);
					
					bettingService.placeBet(bet);
		    	}catch(Exception e){
		    		System.out.println("LOG: något crashade");
		    	}
		       
		    }
		}
		
			
		ModelAndView modelAndView = new ModelAndView("adminview");
		return modelAndView;
	}
	

}
