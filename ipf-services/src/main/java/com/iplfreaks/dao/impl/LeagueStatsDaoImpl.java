/**
 * 
 */
package com.iplfreaks.dao.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation.ProjectionOperationBuilder;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.expression.spel.ast.Projection;

import com.iplfreaks.core.ChallengerScore;
import com.iplfreaks.core.FixtureScore;
import com.iplfreaks.core.LeagueStatistics;
import com.iplfreaks.dao.api.ILeagueStatsDao;
import com.iplfreaks.dao.repository.LeagueStatisticsRepository;
import com.mongodb.WriteResult;

/**
 * @author jayeshm3
 *
 */
public class LeagueStatsDaoImpl implements ILeagueStatsDao {
	
	private MongoTemplate mongoTemplate;

	private LeagueStatisticsRepository leagueStatisticsRepository;
	
	private final String COLLECTION_LEAGUE_STATS = "leagueStatistics";

	@Override
	public void createLeagueStats(LeagueStatistics leagueStatistics) {
		this.mongoTemplate.insert(leagueStatistics);
	}

	@Override
	public void createLeagueStats(String leagueName) {
		final LeagueStatistics leagueStatistics = new LeagueStatistics();
		leagueStatistics.setLeagueName(leagueName);
		this.mongoTemplate.insert(leagueStatistics);
	}

	@Override
	public void addFixtureScore(String leagueName, FixtureScore fixtureScore) {
		final Query query = new Query(Criteria.where("leagueName").is(leagueName));
		final Update update = new Update();
		update.addToSet("fixtureScores", fixtureScore);
		final WriteResult writeResult = this.mongoTemplate.updateFirst(query,
				update, COLLECTION_LEAGUE_STATS);
		System.out.println(writeResult.toString());
		System.out.println(writeResult.getLastError());
	}

	@Override
	public LeagueStatistics fetchFixtureScore(String leagueName, String fixtureId) {
		
		final TypedAggregation<LeagueStatistics> typedAggregation = newAggregation(LeagueStatistics.class,
				match(Criteria.where("leagueName").is(leagueName)),
				unwind("fixtureScores"),
				match(Criteria.where("fixtureScores.fixtureId").is(fixtureId)),
				group().push("fixtureScores").as("fixtureScores").first("leagueName").as("leagueName")
				);
		
		System.out.println("Query used for fetching fixture based on id from leaguestatistics is : " + typedAggregation);
		final AggregationResults<LeagueStatistics> result = mongoTemplate.aggregate(typedAggregation, COLLECTION_LEAGUE_STATS, LeagueStatistics.class);
		
		return getFirstLeagueStats(result.getMappedResults());
		
	}

	@Override
	public List<ChallengerScore> fetchLeagueScore(String leagueName) {
		
		/*
		 * db.leagueStatistics.aggregate({"$match":{"leagueName":"l1"}},
		 * {"$unwind":"$fixtureScores"},
		 * {"$project":{"scores":"$fixtureScores.challengerScores"}},
		 * {"$unwind":"$scores"},
		 * {"$group":{_id:"$scores.challengerName","totalScore":{"$sum":"$scores.score"}}})
		 * 
		 */
		
		final TypedAggregation<LeagueStatistics> typedAggregation = newAggregation(LeagueStatistics.class,
				match(Criteria.where("leagueName").is(leagueName)),
				unwind("fixtureScores"),
				unwind("fixtureScores.challengerScores"),
				group("fixtureScores.challengerScores.challengerName").first("fixtureScores.challengerScores.challengerName").as("challengerName").sum("fixtureScores.challengerScores.score").as("score")
				//match(Criteria.where("fixtureScores.fixtureId").is(fixtureId)),
				//group().push("fixtureScores").as("fixtureScores").first("leagueName").as("leagueName")
				);
		
		System.out.println("Query used for fetching fixture based on id from leaguestatistics is : " + typedAggregation);
		final AggregationResults<ChallengerScore> result = mongoTemplate.aggregate(typedAggregation, COLLECTION_LEAGUE_STATS, ChallengerScore.class);
		
		System.out.println(result.getMappedResults().size());
		
		return result.getMappedResults();
		
	}
	
	private LeagueStatistics getFirstLeagueStats(final List<LeagueStatistics> leagueStatsList)
	{
		if(leagueStatsList == null || leagueStatsList.isEmpty())
		{
			return null;
		}
		
		return leagueStatsList.get(0);
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
	 * @return the leagueStatisticsRepository
	 */
	public LeagueStatisticsRepository getLeagueStatisticsRepository() {
		return leagueStatisticsRepository;
	}

	/**
	 * @param leagueStatisticsRepository the leagueStatisticsRepository to set
	 */
	public void setLeagueStatisticsRepository(LeagueStatisticsRepository leagueStatisticsRepository) {
		this.leagueStatisticsRepository = leagueStatisticsRepository;
	}

}
