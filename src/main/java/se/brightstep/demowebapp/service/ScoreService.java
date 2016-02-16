package se.brightstep.demowebapp.service;

import java.util.List;
import java.util.Map;

import se.brightstep.demowebapp.dao.impl.HighscoreEntry;
import se.brightstep.demowebapp.dao.impl.User;
import se.brightstep.demowebapp.dao.impl.UserScore;


public interface ScoreService {
	
	public int getRoundScore(int id, int round);
	public int getTotalScore(int id);
	
	public List<UserScore> getTotalScoreAllUsers();
	public List<UserScore> getRoundScoreAllUsers(int id, int round);

	public List<HighscoreEntry> getTotalHighscore();
	public List<HighscoreEntry> getRoundHighscore(int round);
}
