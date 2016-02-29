package se.brightstep.demowebapp.service;

import java.util.List;

import se.brightstep.demowebapp.dto.json.Match;
import se.brightstep.demowebapp.dto.json.MatchDay;

public interface MatchDayService {
	
	public List<Match> getAllMatchesFromMatchDay(int matchDay);
	public MatchDay getMatchDay(int matchDay);
	public boolean isMatchDayFinished(int matchDay);
	public List<Integer> getMatchDaysToAddResult();

}
