package app.service;

import java.util.List;
import java.util.Map;

import app.dto.Bet;
import app.dto.HighscoreEntry;
import app.dto.User;
import app.dto.UserScore;


public interface ScoreService {
	
	public int getRoundScore(int id, int round);
	public int getTotalScore(int id);

	public List<HighscoreEntry> getTotalHighscore();
	public List<HighscoreEntry> getRoundHighscore(int round);
	
	public List<Bet> correctBets(List<Bet> bets);
}
