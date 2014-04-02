/**
 * 
 */
package com.iplfreaks.dao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iplfreaks.game.cricket.CricketLeagueScore;

/**
 * @author jayeshm3
 *
 */
public interface CricketLeagueScoreRepository extends MongoRepository<CricketLeagueScore, String> {
	
	public List<CricketLeagueScore> findByleagueName(final String leagueName);
	
	public List<CricketLeagueScore> findByleagueNameAndChallengesFixtureIdAndChallengesPredictionsChallengerUserEmail(final String leagueName, final String fixtureId, final String email);

}
