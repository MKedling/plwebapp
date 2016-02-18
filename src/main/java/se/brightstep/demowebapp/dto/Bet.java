package se.brightstep.demowebapp.dto;

import java.sql.Timestamp;

public class Bet {
	
	private int matchID;
	private int betID;
	private int userID;
	
	private String homeTeam;
	private String awayTeam;
	
	private int matchHomeScore;
	private int matchAwayScore;
	private int betHomeScore;
	private int betAwayScore;
	
	private int round;
	private Timestamp starttime;
	private Timestamp timeOfBet;
	
	public int getMatchID() {
		return matchID;
	}
	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}
	public int getBetID() {
		return betID;
	}
	public void setBetID(int betID) {
		this.betID = betID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	public int getMatchHomeScore() {
		return matchHomeScore;
	}
	public void setMatchHomeScore(int matchHomeScore) {
		this.matchHomeScore = matchHomeScore;
	}
	public int getMatchAwayScore() {
		return matchAwayScore;
	}
	public void setMatchAwayScore(int matchAwayScore) {
		this.matchAwayScore = matchAwayScore;
	}
	public int getBetHomeScore() {
		return betHomeScore;
	}
	public void setBetHomeScore(int betHomeScore) {
		this.betHomeScore = betHomeScore;
	}
	public int getBetAwayScore() {
		return betAwayScore;
	}
	public void setBetAwayScore(int betAwayScore) {
		this.betAwayScore = betAwayScore;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public Timestamp getTimeOfBet() {
		return timeOfBet;
	}
	public void setTimeOfBet(Timestamp timeOfBet) {
		this.timeOfBet = timeOfBet;
	}
	
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	
	
	

}
