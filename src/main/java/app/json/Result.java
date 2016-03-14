package app.json;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "goalsHomeTeam", "goalsAwayTeam" })
public class Result {

	@JsonProperty("goalsHomeTeam")
	private Integer homeScore;
	@JsonProperty("goalsAwayTeam")
	private Integer awayScore;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("goalsHomeTeam")
	public Integer getHomeScore() {
		return homeScore;
	}

	@JsonProperty("goalsHomeTeam")
	public void setHomeScore(Integer goalsHomeTeam) {
		this.homeScore = goalsHomeTeam;
	}

	@JsonProperty("goalsAwayTeam")
	public Integer getAwayScore() {
		return awayScore;
	}

	@JsonProperty("goalsAwayTeam")
	public void setAwayScore(Integer goalsAwayTeam) {
		this.awayScore = goalsAwayTeam;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}