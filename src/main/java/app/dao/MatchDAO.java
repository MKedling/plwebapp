package app.dao;

import java.util.ArrayList;
import java.util.List;

import app.json.Match;
import app.json.MatchDay;

public interface MatchDAO{
	
	public List<Match> getAllMatches();
	public List<Match> getAllMatchesToBet(int round);
	public void addNewMatchesToDatabase(ArrayList<Match> matches);
	
	public int getCurrentRound();
	public List<Match> getAllMatchesToAddResult();
	public boolean addResult(int matchID, int homeScore, int awayScore);
	public MatchDay getMatchDay(int round);
	public boolean addResult(Match match);
	public List<Integer> getMatchDaysToAddResult();
	public Match getMatch(String homeTeam, String awayTeam);
	public Match getMatch(int id);

}
