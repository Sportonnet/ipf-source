/**
 * 
 */
package com.iplfreaks.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.iplfreaks.core.Challenge;
import com.iplfreaks.core.LeagueScoreDetails;
import com.iplfreaks.core.Prediction;
import com.iplfreaks.dao.api.ILeagueScoreDetailsDao;
import com.iplfreaks.dao.repository.LeagueScoreDetailsRepository;
import com.mongodb.WriteResult;

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
	public void createNewLeagueScoreDetails(LeagueScoreDetails leagueScoreDetails) {
		this.mongoTemplate.insert(leagueScoreDetails);
	}

	@Override
	public void createNewLeagueScoreDetails(String leagueName) {
		final LeagueScoreDetails leagueScoreDetails = new LeagueScoreDetails(leagueName);
		this.mongoTemplate.insert(leagueScoreDetails);
	}

	@Override
	public void createNewLeagueScoreDetails(String leagueName,
			Set<Challenge> challenges) {
		
		final LeagueScoreDetails leagueScoreDetails = new LeagueScoreDetails(leagueName);
		leagueScoreDetails.addAllFixturePrediction(challenges);
		this.mongoTemplate.insert(leagueScoreDetails);
	}
	

	@Override
	public LeagueScoreDetails fetchUserChallenge(String leagueName,
			String fixtureId, String email) {
		final List<LeagueScoreDetails> leagueScoreDetails = getLeagueScoreDetailsRepository().findByleagueNameAndChallengesFixtureIdAndChallengesPredictionsChallengerUserEmail(leagueName, fixtureId, email);

		if(leagueScoreDetails == null || leagueScoreDetails.isEmpty())
		{
			return null;
		}
		
		return leagueScoreDetails.get(0);
	}

	@Override
	public void addChallengerPrediction(String leagueName, String fixtureId,
			Prediction prediction) {
		
		//final LeagueScoreDetails leagueScoreDetails = fetchLeagueScoreDetails(leagueName);
		
		final Query query = new Query(Criteria.where("leagueName").is(leagueName).andOperator(Criteria.where("challenges.fixtureId").is(fixtureId)));
		final Update update = new Update();
		update.addToSet("challenges.$.predictions", prediction);
		//this.mongoTemplate.upsert(query, update, "leagueScoreDetails");
		final WriteResult writeResult = this.mongoTemplate.updateFirst(query, update, "leagueScoreDetails");
		System.out.println(writeResult.toString());
		System.out.println(writeResult.getLastError());
		
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
