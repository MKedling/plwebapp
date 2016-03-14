package app.service;

import java.util.List;

import app.json.Match;
import app.json.MatchDay;

public interface MatchDayService {
	
	public List<Match> getAllMatchesFromMatchDay(int matchDay);
	public MatchDay getMatchDay(int matchDay);
	public boolean isMatchDayFinished(int matchDay);
	public List<Integer> getMatchDaysToAddResult();

}
