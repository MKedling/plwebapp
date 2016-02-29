package se.brightstep.demowebapp.service;

import java.util.ArrayList;

import se.brightstep.demowebapp.dto.json.Match;

public interface AdminMatchService {

	public ArrayList<Match> readMatchesFromFile(String fileName);
	
	public void addNewMatchesToDatabase(ArrayList<Match> matches);
	
	
}
