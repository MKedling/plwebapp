package app.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import app.misc.MiscHelperService;
import app.service.MatchService;

public class Bet implements Comparable<Bet>{
	
	@Autowired
	private MatchService matchService;
	
	private int matchID;
	private int betID;
	private int userID;
	
	private String homeTeam;
	private String awayTeam;
	
	private Integer matchHomeScore;
	private Integer matchAwayScore;
	private Integer betHomeScore;
	private Integer betAwayScore;
	
	private Integer round;
	private Timestamp starttime;
	private int betScore; 
	
	public int getBetScore() {
		return betScore;
	}
	public void setBetScore(int betScore) {
		this.betScore = betScore;
	}

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
	public Integer getMatchHomeScore() {
		return matchHomeScore;
	}
	public void setMatchHomeScore(Integer matchHomeScore) {
		this.matchHomeScore = matchHomeScore;
	}
	public Integer getMatchAwayScore() {
		return matchAwayScore;
	}
	public void setMatchAwayScore(Integer matchAwayScore) {
		this.matchAwayScore = matchAwayScore;
	}
	public Integer getBetHomeScore() {
		return betHomeScore;
	}
	public void setBetHomeScore(Integer betHomeScore) {
		this.betHomeScore = betHomeScore;
	}
	public Integer getBetAwayScore() {
		return betAwayScore;
	}
	public void setBetAwayScore(Integer betAwayScore) {
		this.betAwayScore = betAwayScore;
	}
	public Integer getRound() {
		return round;
	}
	public void setRound(Integer round) {
		this.round = round;
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
	
	public String toString(){
		return "Round:" + round + "  matchid: "+ matchID + " uid: " + userID + "  "  + getHomeTeam() + " - " + getAwayTeam() + "  predicted:" + getBetHomeScore() + "-" + getBetAwayScore() + "  actual: " + getMatchHomeScore()+ "-" + getMatchAwayScore() + "  betid" + betID;
	}
	
	public String getStarttimeFormatted(){
		return new SimpleDateFormat("dd/MM-yy HH:mm").format(starttime);
	}
	
	public String getHomeTeamShortName(){
		return MiscHelperService.getTeamShortName(homeTeam);
	}
	
	public String getAwayTeamShortName(){
		return MiscHelperService.getTeamShortName(awayTeam);
	}
	
	@Override
	public int compareTo(Bet bet) {
		return this.getStarttime().compareTo(bet.getStarttime());
	}
	


}
