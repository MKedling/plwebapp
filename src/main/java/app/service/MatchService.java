package app.service;

import java.util.List;

import app.json.Match;
import app.json.MatchDay;

public interface MatchService {
	
	public List<Match> getAllMatches();
	public List<Match> getAllMatchesToBet(int round);
	public List<Match> getAllMatchesToAddResult();
	
	public MatchDay getMatchDay(int round);
	
	public int getCurrentRound();
	
	public boolean addResult(int matchID, int homeScore, int awayScore);
	public boolean addResult(Match match);
	public Match getMatch(String homeTeam, String awayTeam);
	public Match getMatch(int id);

}
