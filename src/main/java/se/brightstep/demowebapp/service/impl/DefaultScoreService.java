package se.brightstep.demowebapp.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.brightstep.demowebapp.dao.BettingDAO;
import se.brightstep.demowebapp.dao.MatchDAO;
import se.brightstep.demowebapp.dao.UserDAO;
import se.brightstep.demowebapp.dao.impl.Bet;
import se.brightstep.demowebapp.dao.impl.HighscoreEntry;
import se.brightstep.demowebapp.dao.impl.User;
import se.brightstep.demowebapp.dao.impl.UserScore;
import se.brightstep.demowebapp.service.ScoreService;
import se.brightstep.demowebapp.service.UserService;

public class DefaultScoreService implements ScoreService{

	private MatchDAO matchDAO;
	private BettingDAO bettingDAO;
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

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

	public int getTotalScore(int userId) {
		
		ArrayList<Bet> allBets = new ArrayList<Bet>(bettingDAO.getAllBets(userId));
		int totalScore = 0;
		
		for(Bet bet : allBets){
			totalScore += calculateScore(bet);
		}
		
		return totalScore;
	}
	
	public int getRoundScore(int userId, int round) {
		
		ArrayList<Bet> allBets = new ArrayList<Bet>(bettingDAO.getAllBetsRound(userId, round));
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


	@Override
	public List<UserScore> getRoundScoreAllUsers(int id, int round) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserScore> getTotalScoreAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HighscoreEntry> getTotalHighscore() {

		List<HighscoreEntry> highscore = new ArrayList<HighscoreEntry>();
		for(User user : userDAO.getAllUsers()){
			highscore.add(new HighscoreEntry(user, getTotalScore(user.getID())));
		}
		Collections.sort(highscore);
		return highscore;
	}

	@Override
	public List<HighscoreEntry> getRoundHighscore(int round) {
		List<HighscoreEntry> highscore = new ArrayList<HighscoreEntry>();
		for(User user : userDAO.getAllUsers()){
			highscore.add(new HighscoreEntry(user, getRoundScore(user.getID(), round)));
		}
		Collections.sort(highscore);
		return highscore;
	}

	

	
	
	

}
