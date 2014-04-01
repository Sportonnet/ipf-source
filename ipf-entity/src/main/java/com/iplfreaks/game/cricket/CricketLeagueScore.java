/**
 * 
 */
package com.iplfreaks.game.cricket;

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
@TypeAlias(value="cricketLeagueScore")
public class CricketLeagueScore {
	
	@Indexed(unique=true, sparse=true)
	private String leagueName;
	
	private final Set<CricketChallenge> challenges = new HashSet<CricketChallenge>();
	
	public CricketLeagueScore() {
	}
	
	public CricketLeagueScore(final String leagueName)
	{
		this.leagueName = leagueName;
	}
	
	public void addFixturePrediction(final CricketChallenge challenge){
		getFixturePredictionList().add(challenge);
	}
	
	public void addAllFixturePrediction(final Set<CricketChallenge> challenges)
	{
		getFixturePredictionList().addAll(challenges);
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
	public Set<CricketChallenge> getFixturePredictionList() {
		return challenges;
	}

}
