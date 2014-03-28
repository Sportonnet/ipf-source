/**
 * 
 */
package com.iplfreaks.dao.api;

import java.util.Set;

import com.iplfreaks.core.Challenge;
import com.iplfreaks.core.LeagueScoreDetails;
import com.iplfreaks.core.Prediction;

/**
 * @author jayeshm3
 *
 */
public interface ILeagueScoreDetailsDao {
	
	public void createNewLeagueScoreDetails(final String leagueName);
	
	public void createNewLeagueScoreDetails(final LeagueScoreDetails leagueScoreDetails);
	
	public void createNewLeagueScoreDetails(String leagueName,
			Set<Challenge> challenges);
	
	public void addChallengerPrediction(final String leagueName, final String fixtureId, final Prediction prediction);
	
	public LeagueScoreDetails fetchLeagueScoreDetails(final String leagueName);
	
	public LeagueScoreDetails fetchUserChallenge(final String leagueName, final String fixtureId, final String email);

}
