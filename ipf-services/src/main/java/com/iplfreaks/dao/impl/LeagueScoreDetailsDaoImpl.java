/**
 * 
 */
package com.iplfreaks.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.iplfreaks.core.FixturePrediction;
import com.iplfreaks.core.LeagueScoreDetails;
import com.iplfreaks.core.Prediction;
import com.iplfreaks.dao.api.ILeagueScoreDetailsDao;
import com.iplfreaks.dao.repository.LeagueScoreDetailsRepository;

/**
 * @author jayeshm3
 *
 */
public class LeagueScoreDetailsDaoImpl implements ILeagueScoreDetailsDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private LeagueScoreDetailsRepository leagueScoreDetailsRepository;

	@Override
	public void createNewLeagueScoreDetails(String leagueName) {
		final LeagueScoreDetails leagueScoreDetails = new LeagueScoreDetails(leagueName);
		this.mongoTemplate.insert(leagueScoreDetails);
	}

	@Override
	public void createNewLeagueScoreDetails(String leagueName,
			Set<FixturePrediction> fixturePredictionSet) {
		
		final LeagueScoreDetails leagueScoreDetails = new LeagueScoreDetails(leagueName);
		leagueScoreDetails.addAllFixturePrediction(fixturePredictionSet);
		this.mongoTemplate.insert(leagueScoreDetails);
	}

	@Override
	public void addChallengerPrediction(String leagueName, String fixtureName,
			Prediction prediction) {
		
	}

	@Override
	public LeagueScoreDetails fetchLeagueScoreDetails(String leagueName) {
		final List<LeagueScoreDetails> leagueScoreDetails = getLeagueScoreDetailsRepository().findByleagueName(leagueName);

		if(leagueScoreDetails == null || leagueScoreDetails.isEmpty())
		{
			return null;
		}
		
		return leagueScoreDetails.get(0);
	}

	/**
	 * @return the mongoTemplate
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * @param mongoTemplate the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	/**
	 * @return the leagueScoreDetailsRepository
	 */
	public LeagueScoreDetailsRepository getLeagueScoreDetailsRepository() {
		return leagueScoreDetailsRepository;
	}

	/**
	 * @param leagueScoreDetailsRepository the leagueScoreDetailsRepository to set
	 */
	public void setLeagueScoreDetailsRepository(
			LeagueScoreDetailsRepository leagueScoreDetailsRepository) {
		this.leagueScoreDetailsRepository = leagueScoreDetailsRepository;
	}

}
