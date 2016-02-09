package se.brightstep.demowebapp.service;

import java.util.List;

import se.brightstep.demowebapp.dao.impl.Match;

public interface MatchService {
	
	public List<Match> getAllMatches();
	public List<Match> getAllMatchesToBet();
	public List<Match> getAllMatchesToAddResult();
	
	public int getCurrentRound();
	public boolean addResult(int matchID, int homeScore, int awayScore);

}
