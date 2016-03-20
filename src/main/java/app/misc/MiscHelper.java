package app.misc;

import java.util.HashMap;

public class MiscHelper {
	
	public static String getTeamShortName(String teamName) {
		
		HashMap<String, String> teamNameMapping = new HashMap<String, String>();
		teamNameMapping.put("Manchester United FC", "Man United");
		teamNameMapping.put("Tottenham Hotspur FC", "Tottenham");
		teamNameMapping.put("Everton FC", "Everton");
		teamNameMapping.put("AFC Bournemouth", "Bournemouth");
		teamNameMapping.put("Aston Villa FC", "Aston Villa");
		teamNameMapping.put("Leicester City FC", "Leicester");
		teamNameMapping.put("Sunderland AFC", "Sunderland");
		teamNameMapping.put("Norwich City FC", "Norwich");
		teamNameMapping.put("Chelsea FC", "Chelsea");
		teamNameMapping.put("Arsenal FC", "Arsenal");
		
		teamNameMapping.put("Swansea City FC", "Swansea");
		teamNameMapping.put("West Ham United FC", "West Ham");
		teamNameMapping.put("Newcastle United FC", "Newcastle");
		teamNameMapping.put("Southampton FC", "Southampton");
		teamNameMapping.put("Stoke City FC", "Stoke");
		teamNameMapping.put("Liverpool FC", "Liverpool");
		teamNameMapping.put("Manchester City FC", "Man City");
		teamNameMapping.put("Crystal Palace FC", "Crystal P");
		teamNameMapping.put("Watford FC", "Watford");
		teamNameMapping.put("West Bromwich Albion FC", "W.B.A");
		
		if(teamNameMapping.containsKey(teamName)){
			return teamNameMapping.get(teamName);
		}
		System.out.println("LOG: Dont have short name for team " + teamName);
		return teamName;
	}

}
