package app.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.dao.MatchDAO;
import app.json.Match;
import app.service.AdminMatchService;

public class DefaultAdminMatchService implements AdminMatchService{

	private MatchDAO matchDAO;
	
	public MatchDAO getMatchDAO() {
		return matchDAO;
	}

	public void setMatchDAO(MatchDAO matchDAO) {
		this.matchDAO = matchDAO;
	}

	public ArrayList<Match> readMatchesFromFile(String fileName) {
		
		ArrayList<Match> matches = new ArrayList<Match>();
	
		Pattern patternRound = Pattern.compile("^([A-Za-Z]+) ([0-9]+)");
		Pattern patternMatch = Pattern.compile("^([:\\s-0-9]+)\\s([ A-Za-z]+)\\s-\\s([ A-Za-z]+)");

		Matcher matcherMatch;
		Matcher matcherRound;
		int round = -1;
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    String line;
		    Match tempMatch; 
		    while ((line = br.readLine()) != null) {
		    	matcherMatch = patternMatch.matcher(line);
		    	matcherRound = patternRound.matcher(line);
		    	if(matcherRound.find()){
		    		round = Integer.parseInt(matcherRound.group(2));
		    	}else{
		    		if(matcherMatch.find()){
			    		tempMatch = new Match();
			    		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:mm");
			    		Date date;
						try {
							date = dateFormat.parse(matcherMatch.group(1));
							tempMatch.setStarttime(new Timestamp(date.getTime()));
						} catch (ParseException e) {
							e.printStackTrace();
						}
			    		tempMatch.setRound(round);
			    		tempMatch.setHomeTeam(matcherMatch.group(2));
			    		tempMatch.setAwayTeam(matcherMatch.group(3));
			    		matches.add(tempMatch);
		    		}
		    	}
		    	
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return matches;
		
	}

	@Override
	public void addNewMatchesToDatabase(ArrayList<Match> matches) {
		
		matchDAO.addNewMatchesToDatabase(matches);
		
	}
	
	

}
