package se.brightstep.demowebapp.dao;

import java.util.ArrayList;
import java.util.List;

import se.brightstep.demowebapp.dao.impl.Match;

public interface MatchDAO{
	
	public List<Match> getAllMatches();
	public List<Match> getAllMatchesToBet();
	public void addNewMatchesToDatabase(ArrayList<Match> matches);
	
	public int getCurrentRound();

}
