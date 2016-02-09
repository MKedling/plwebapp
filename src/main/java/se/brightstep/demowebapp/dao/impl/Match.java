package se.brightstep.demowebapp.dao.impl;

import java.sql.Timestamp;

public class Match {
	
	private int ID;
	private String homeTeam;
	private String awayTeam;
	private int homeScore;
	private int awayScore;
	private Timestamp starttime; // typen skall ändras
	private int round;
	
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp timestamp) {
		this.starttime = timestamp;
	}
	
	public String toString(){
		return "Runda: " + round +  "  Tid: " + starttime + "  Hemmalag: " + homeTeam + " - " + awayTeam; 
	}
	
	

}
