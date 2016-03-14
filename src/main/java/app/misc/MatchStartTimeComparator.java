package app.misc;

import java.util.Comparator;

import app.json.Match;


public class MatchStartTimeComparator implements Comparator<Match>{
	
	@Override
	public int compare(Match m1, Match m2) {
		return m1.getStarttime().compareTo(m2.getStarttime());
	}

}
