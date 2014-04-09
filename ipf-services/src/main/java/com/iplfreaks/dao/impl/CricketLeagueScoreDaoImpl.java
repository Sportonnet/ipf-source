/**
 * 
 */
package com.iplfreaks.dao.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.iplfreaks.core.LeagueStatistics;
import com.iplfreaks.dao.api.ICricketLeagueScoreDao;
import com.iplfreaks.dao.repository.CricketLeagueScoreRepository;
import com.iplfreaks.game.cricket.CricketChallenge;
import com.iplfreaks.game.cricket.CricketLeagueScore;
import com.iplfreaks.game.cricket.CricketPrediction;
import com.mongodb.WriteResult;

/**
 * @author jayeshm3
 *
 */
public class CricketLeagueScoreDaoImpl implements ICricketLeagueScoreDao {
	
	private MongoTemplate mongoTemplate;

	private CricketLeagueScoreRepository cricketLeagueScoreRepository;
	
	private static final String COLLECTION_CRICKET_LEAGUE_SCORE = "cricketLeagueScore";

	@Override
	public void createNewCricketLeagueScore(String leagueName) {

		final CricketLeagueScore cricketLeagueScore = new CricketLeagueScore(
				leagueName);
		this.mongoTemplate.insert(cricketLeagueScore);
	}

	@Override
	public void createNewCricketLeagueScore(
			CricketLeagueScore cricketLeagueScore) {

		this.mongoTemplate.insert(cricketLeagueScore);
	}

	@Override
	public void createNewCricketLeagueScore(String leagueName,
			Set<CricketChallenge> challenges) {
		
		final CricketLeagueScore cricketLeagueScore = new CricketLeagueScore(
				leagueName);
		cricketLeagueScore.addAllFixturePrediction(challenges);
		this.mongoTemplate.insert(cricketLeagueScore);
	}

	
	/*
	 * db.cricketLeagueScore.aggregate({"$match":{"leagueName":"l1"}},
	 * {"$unwind":"$challenges"},
	 * {"$match":{"challenges.fixtureId":"DD vs MI @ 25-03-2014"}},
	 * {"$project":{"challenges":"$challenges.predictions"}})
	 */
	
	public List<CricketPrediction> fetchPredictions(final String leagueName, final String fixtureId)
	{
		final TypedAggregation<CricketLeagueScore> typedAggregation = newAggregation(CricketLeagueScore.class,
				match(Criteria.where("leagueName").is(leagueName)),
				unwind("challenges"),
				match(Criteria.where("challenges.fixtureId").is(fixtureId)),
				unwind("challenges.predictions")
				//group().push("challenges.predictions").as("challenges")
				//group().push("fixtureScores").as("fixtureScores").first("leagueName").as("leagueName")
				);
		
		System.out.println("Query used for fetching fixture based on id from leaguestatistics is : " + typedAggregation);
		final AggregationResults<CricketPrediction> result = mongoTemplate.aggregate(typedAggregation, COLLECTION_CRICKET_LEAGUE_SCORE, CricketPrediction.class);
		
		return result.getMappedResults();
	}
	
	@Override
	public void addChallengerPrediction(String leagueName, String fixtureId,
			CricketPrediction prediction) {
		
		final List<CricketPrediction> allCricketPredictions = fetchPredictions(leagueName, fixtureId);
		
		final Set<CricketPrediction> updatedCricketPredictions = new HashSet<CricketPrediction>();
		
		updatedCricketPredictions.add(prediction);
		updatedCricketPredictions.addAll(allCricketPredictions);

		final Query query = new Query(Criteria
				.where("leagueName")
				.is(leagueName)
				.andOperator(
						Criteria.where("challenges.fixtureId").is(fixtureId)));
		
		final CricketLeagueScore cricketLeagueScore = fetchCricketLeagueScore(leagueName);
		//final
		
		final Update update = new Update();
		update.set("challenges.$.predictions", updatedCricketPredictions);
		//update.addToSet("challenges.$.predictions", prediction);
		// this.mongoTemplate.upsert(query, update, "leagueScoreDetails");
		final WriteResult writeResult = this.mongoTemplate.updateFirst(query,
				update, COLLECTION_CRICKET_LEAGUE_SCORE);
		System.out.println(writeResult.toString());
		System.out.println(writeResult.getLastError());
	}

	@Override
	public CricketLeagueScore fetchCricketLeagueScore(String leagueName) {
	
		final List<CricketLeagueScore> cricketLeagueScores = getCricketLeagueScoreRepository().findByleagueName(leagueName);

		if (cricketLeagueScores == null || cricketLeagueScores.isEmpty()) {
			return null;
		}

		return cricketLeagueScores.get(0);
	
	}

	@Override
	public CricketLeagueScore fetchUserChallenge(String leagueName,
			String fixtureId, String email) {
		
		final List<CricketLeagueScore> cricketLeagueScores = getCricketLeagueScoreRepository()
				.findByleagueNameAndChallengesFixtureIdAndChallengesPredictionsChallengerUserEmail(
						leagueName, fixtureId, email);

		if (cricketLeagueScores == null || cricketLeagueScores.isEmpty()) {
			return null;
		}

		return cricketLeagueScores.get(0);
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
	 * @return the cricketLeagueScoreRepository
	 */
	public CricketLeagueScoreRepository getCricketLeagueScoreRepository() {
		return cricketLeagueScoreRepository;
	}

	/**
	 * @param cricketLeagueScoreRepository the cricketLeagueScoreRepository to set
	 */
	public void setCricketLeagueScoreRepository(
			CricketLeagueScoreRepository cricketLeagueScoreRepository) {
		this.cricketLeagueScoreRepository = cricketLeagueScoreRepository;
	}

}
