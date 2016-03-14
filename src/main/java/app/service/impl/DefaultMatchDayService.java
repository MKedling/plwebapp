package app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.dao.MatchDAO;
import app.json.Match;
import app.json.MatchDay;
import app.service.MatchDayService;
import app.service.MatchService;

public class DefaultMatchDayService implements MatchDayService{

	@Autowired
	MatchService matchService;
	
	@Autowired
	MatchDAO matchDAO;
	
	
	@Override
	public List<Match> getAllMatchesFromMatchDay(int matchDay) {
		return matchService.getMatchDay(matchDay).getMatches();
	}

	@Override
	public MatchDay getMatchDay(int matchDay) {
		return matchService.getMatchDay(matchDay);
	}

	@Override
	public boolean isMatchDayFinished(int matchDay) {
		for(Match match : getAllMatchesFromMatchDay(matchDay)){
			if(!match.getStatus().equals("FINISHED")){
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Integer> getMatchDaysToAddResult() {
		return matchDAO.getMatchDaysToAddResult();
	}
	
	

}
