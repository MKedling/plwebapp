package se.brightstep.demowebapp.service;

import java.util.List;
import java.util.Map;

import se.brightstep.demowebapp.dto.HighscoreEntry;
import se.brightstep.demowebapp.dto.User;
import se.brightstep.demowebapp.dto.UserScore;


public interface ScoreService {
	
	public int getRoundScore(int id, int round);
	public int getTotalScore(int id);

	public List<HighscoreEntry> getTotalHighscore();
	public List<HighscoreEntry> getRoundHighscore(int round);
}
