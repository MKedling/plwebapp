package se.brightstep.demowebapp.misc;

import java.util.Comparator;
import se.brightstep.demowebapp.dto.json.Match;


public class MatchStartTimeComparator implements Comparator<Match>{
	
	@Override
	public int compare(Match m1, Match m2) {
		return m1.getStarttime().compareTo(m2.getStarttime());
	}

}
