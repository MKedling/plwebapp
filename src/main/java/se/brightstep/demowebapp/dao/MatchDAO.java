package se.brightstep.demowebapp.dao;

import java.util.ArrayList;
import java.util.List;

import se.brightstep.demowebapp.dto.Match;

public interface MatchDAO{
	
	public List<Match> getAllMatches();
	public List<Match> getAllMatchesToBet(int round);
	public void addNewMatchesToDatabase(ArrayList<Match> matches);
	
	public int getCurrentRound();
	public List<Match> getAllMatchesToAddResult();
	public boolean addResult(int matchID, int homeScore, int awayScore);

}
