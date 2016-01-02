package se.brightstep.demowebapp.dao.impl;

import java.sql.Timestamp;

public class Bet {
	
	private int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	private int userId;
	private int matchId;
	private int homeScore;
	private int awayScore;
	private Timestamp timeOfBet;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getHomeScore() {
		return homeScore;
	}
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}
	public int getAwayScore() {
		return awayScore;
	}
	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}
	public Timestamp getTimeOfBet() {
		return timeOfBet;
	}
	public void setTimeOfBet(Timestamp timeOfBet) {
		this.timeOfBet = timeOfBet;
	}
	
	

}
