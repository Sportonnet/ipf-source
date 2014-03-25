/**
 * 
 */
package com.iplfreaks.core;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author jayeshm3
 *
 */
@Document
@TypeAlias(value="leagueScoreDetails")
public class LeagueScoreDetails {
	
	@Indexed(unique=true, sparse=true)
	private String leagueName;
	
	private final Set<FixturePrediction> fixturePredictionList = new HashSet<FixturePrediction>();
	
	public LeagueScoreDetails() {
	}
	
	public LeagueScoreDetails(final String leagueName)
	{
		this.leagueName = leagueName;
	}
	
	public void addFixturePrediction(final FixturePrediction fixturePrediction){
		getFixturePredictionList().add(fixturePrediction);
	}
	
	public void addAllFixturePrediction(final Set<FixturePrediction> fixturePredictions)
	{
		getFixturePredictionList().addAll(fixturePredictions);
	}
	
	/**
	 * @return the leagueName
	 */
	public String getLeagueName() {
		return leagueName;
	}

	/**
	 * @param leagueName the leagueName to set
	 */
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	/**
	 * @return the fixturePredictionList
	 */
	public Set<FixturePrediction> getFixturePredictionList() {
		return fixturePredictionList;
	}
}
