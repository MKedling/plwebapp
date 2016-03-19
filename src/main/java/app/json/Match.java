package app.json;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import app.dto.HighscoreEntry;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "_links", "date", "status", "matchday", "homeTeamName", "awayTeamName", "result" })
public class Match implements Comparable<Match>{

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	
	private int ID;

	@JsonProperty("date")
	private Timestamp starttime;
	@JsonProperty("status")
	private String status;
	@JsonProperty("matchday")
	private Integer round;
	@JsonProperty("homeTeamName")
	private String homeTeam;
	@JsonProperty("awayTeamName")
	private String awayTeam;
	@JsonProperty("result")
	private Result result;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	@JsonProperty("date")
	public Timestamp getStarttime() {
		return starttime;
	}

	@JsonProperty("date")
	public void setStarttime(String starttime) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:mm");
		Date date;
		try {
			date = dateFormat.parse(starttime.replaceAll("[A-Öa-Ö]", " "));
			this.starttime = new Timestamp(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("matchday")
	public Integer getRound() {
		return round;
	}

	@JsonProperty("matchday")
	public void setRound(Integer matchday) {
		this.round = matchday;
	}

	@JsonProperty("homeTeamName")
	public String getHomeTeam() {
		return homeTeam;
	}

	@JsonProperty("homeTeamName")
	public void setHomeTeam(String homeTeamName) {
		this.homeTeam = homeTeamName;
	}

	@JsonProperty("awayTeamName")
	public String getAwayTeam() {
		return awayTeam;
	}

	@JsonProperty("awayTeamName")
	public void setAwayTeam(String awayTeamName) {
		this.awayTeam = awayTeamName;
	}

	@JsonProperty("result")
	public Result getResult() {
		return result;
	}

	@JsonProperty("result")
	public void setResult(Result result) {
		this.result = result;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	
	public String toString(){
		return round + "  " + starttime + " : " + status + " :  " + homeTeam + " vs " + awayTeam + "  " + result.getHomeScore()  + " - " +result.getAwayScore();
	}
	
	public String getStarttimeFormatted(){
		return new SimpleDateFormat("dd/MM-yy HH:mm").format(starttime);
	}
	
	@Override
	public int compareTo(Match match){
		return this.starttime.compareTo(match.starttime);
	}
	

}