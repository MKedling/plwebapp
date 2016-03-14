package app.service;

import java.util.ArrayList;

import app.json.Match;

public interface AdminMatchService {

	public ArrayList<Match> readMatchesFromFile(String fileName);
	
	public void addNewMatchesToDatabase(ArrayList<Match> matches);
	
	
}
