package se.brightstep.demowebapp.service.impl;

import java.util.ArrayList;

import se.brightstep.demowebapp.dao.BettingDAO;
import se.brightstep.demowebapp.dao.MatchDAO;
import se.brightstep.demowebapp.dao.impl.Bet;
import se.brightstep.demowebapp.service.ScoreService;

public class DefaultScoreService implements ScoreService{

	private MatchDAO matchDAO;
	private BettingDAO bettingDAO;
	
	public enum Result1X2{
		HOMEWIN, DRAW, AWAYWIN
	}
	
	
	public MatchDAO getMatchDAO() {
		return matchDAO;
	}

	public void setMatchDAO(MatchDAO matchDAO) {
		this.matchDAO = matchDAO;
	}

	public BettingDAO getBettingDAO() {
		return bettingDAO;
	}

	public void setBettingDAO(BettingDAO bettingDAO) {
		this.bettingDAO = bettingDAO;
	}

	public int getTotalScore() {
		
		ArrayList<Bet> allBets = new ArrayList<Bet>(bettingDAO.getAllBets());
		int totalScore = 0;
		
		for(Bet bet : allBets){
			totalScore += calculateScore(bet);
		}
		
		return totalScore;
	}
	
	public int getRoundScore() {
		
		ArrayList<Bet> allBets = new ArrayList<Bet>(bettingDAO.getAllBetsRound());
		int totalScore = 0;
		
		for(Bet bet : allBets){
			totalScore += calculateScore(bet);
		}
		
		return totalScore;
	}
	
	private int calculateScore(Bet bet){
		
		if(bet.getMatchHomeScore() == bet.getBetHomeScore() && 
			bet.getMatchAwayScore() == bet.getBetAwayScore()){
			return 2;
		}else if(getResult(bet.getBetHomeScore(), bet.getBetAwayScore()) ==  
			getResult(bet.getMatchHomeScore(), bet.getMatchAwayScore())){
			return 1;
		}else{
			return 0;
		}	 
	}
	
	private Result1X2 getResult(int homescore, int awayscore){
		
		if(homescore == awayscore){
			return Result1X2.DRAW;
		}else if(homescore > awayscore){
			return Result1X2.HOMEWIN;
		}else{
			return Result1X2.AWAYWIN;
		}
		
	}
	
	

}
