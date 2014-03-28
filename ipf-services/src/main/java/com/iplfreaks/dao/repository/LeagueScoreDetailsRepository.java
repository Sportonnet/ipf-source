/**
 * 
 */
package com.iplfreaks.dao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iplfreaks.core.LeagueScoreDetails;

/**
 * @author jayeshm3
 *
 */
public interface LeagueScoreDetailsRepository extends MongoRepository<LeagueScoreDetails, String> {
	
	public List<LeagueScoreDetails> findByleagueName(final String leagueName);
	
	public List<LeagueScoreDetails> findByleagueNameAndChallengesFixtureIdAndChallengesPredictionsChallengerUserEmail(final String leagueName, final String fixtureId, final String email);

}
