/**
 * 
 */
package com.iplfreaks.dao.api;

import java.util.Set;

import com.iplfreaks.game.cricket.CricketChallenge;
import com.iplfreaks.game.cricket.CricketLeagueScore;
import com.iplfreaks.game.cricket.CricketPrediction;

/**
 * @author jayeshm3
 *
 */
public interface ICricketLeagueScoreDao {
	
	public void createNewCricketLeagueScore(final String leagueName);
	
	public void createNewCricketLeagueScore(final CricketLeagueScore cricketLeagueScore);
	
	public void createNewCricketLeagueScore(String leagueName,
			Set<CricketChallenge> challenges);
	
	public void addChallengerPrediction(final String leagueName, final String fixtureId, final CricketPrediction prediction);
	
	public CricketLeagueScore fetchCricketLeagueScore(final String leagueName);
	
	public CricketLeagueScore fetchUserChallenge(final String leagueName, final String fixtureId, final String email);

}
