/**
 * 
 */
package com.iplfreaks.dao.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.List;

import org.joda.time.DateMidnight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;

import com.iplfreaks.dao.api.ICricketCompetitionDao;
import com.iplfreaks.dao.repository.CricketCompetitionRepository;
import com.iplfreaks.game.cricket.CricketCompetition;

/**
 * @author jayeshm3
 *
 */
public class CricketCompetitionDaoImpl implements ICricketCompetitionDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CricketCompetitionRepository competitionRepository;

	@Override
	public CricketCompetition getCompetitionFixtures(final String name, final String sport) {
		
		final List<CricketCompetition> competitions = getCompetitionRepository().findByNameAndSportAndIsActive(name, sport, true);
		
		return getFirstCompetition(competitions);
	}

	@Override
	public List<CricketCompetition> getActiveCompetitions() {
		return getCompetitionRepository().findByIsActive(true);
	}
	
	@Override
	public CricketCompetition getTodaysFixtures(String name, String sport) {
		
		final DateMidnight dateMidnight = new DateMidnight();
		
		final TypedAggregation<CricketCompetition> typedAggregation = newAggregation(CricketCompetition.class,
				match(Criteria.where("name").is(name).andOperator(Criteria.where("sport").is(sport))),
				unwind("fixtures"),
				match(Criteria.where("fixtures.dateTime").lte(dateMidnight.plusDays(1)).andOperator(Criteria.where("fixtures.dateTime").gt(dateMidnight))),
				group().push("fixtures").as("fixtures").first("name").as("name")
				);
		System.out.println("Query used for today's fixture is : " + typedAggregation);
		final AggregationResults<CricketCompetition> result = mongoTemplate.aggregate(typedAggregation, "cricketCompetition", CricketCompetition.class);
		
		return getFirstCompetition(result.getMappedResults());
	}

	@Override
	public CricketCompetition getPastFixtures(String name, String sport) {
		final DateMidnight dateMidnight = new DateMidnight();
		
		final TypedAggregation<CricketCompetition> typedAggregation = newAggregation(CricketCompetition.class,
				match(Criteria.where("name").is(name).andOperator(Criteria.where("sport").is(sport))),
				unwind("fixtures"),
				match(Criteria.where("fixtures.dateTime").lte(dateMidnight)),
				group().push("fixtures").as("fixtures").first("name").as("name")
				);
		System.out.println("Query used for past fixture is : " + typedAggregation);
		final AggregationResults<CricketCompetition> result = mongoTemplate.aggregate(typedAggregation, "cricketCompetition", CricketCompetition.class);
		
		return getFirstCompetition(result.getMappedResults());
	}

	@Override
	public CricketCompetition getFutureFixtures(String name, String sport) {
		
		final DateMidnight dateMidnight = new DateMidnight().plusDays(1);
		
		final TypedAggregation<CricketCompetition> typedAggregation = newAggregation(CricketCompetition.class,
				match(Criteria.where("name").is(name).andOperator(Criteria.where("sport").is(sport))),
				unwind("fixtures"),
				match(Criteria.where("fixtures.dateTime").gte(dateMidnight)),
				group().push("fixtures").as("fixtures").first("name").as("name")
				);
		System.out.println("Query used for future fixture is : " + typedAggregation);
		final AggregationResults<CricketCompetition> result = mongoTemplate.aggregate(typedAggregation, "cricketCompetition", CricketCompetition.class);
		
		return getFirstCompetition(result.getMappedResults());
	}

	@Override
	public CricketCompetition getFixtureBasedOnFixtureId(String fixtureId) {

		final TypedAggregation<CricketCompetition> typedAggregation = newAggregation(CricketCompetition.class,
				unwind("fixtures"),
				match(Criteria.where("fixtures.fixtureId").is(fixtureId)),//is("India vs South Africa")),
				group().push("fixtures").as("fixtures").first("name").as("name")
				);
		
		System.out.println("Query used for fetching fixture based on id is : " + typedAggregation);
		final AggregationResults<CricketCompetition> result = mongoTemplate.aggregate(typedAggregation, "cricketCompetition", CricketCompetition.class);
		
		return getFirstCompetition(result.getMappedResults());
	}

	@Override
	public CricketCompetition getFixtureBasedOnFixtureId(String name,
			String sport, String fixtureId) {
		
		final TypedAggregation<CricketCompetition> typedAggregation = newAggregation(CricketCompetition.class,
				match(Criteria.where("name").is(name).andOperator(Criteria.where("sport").is(sport))),
				unwind("fixtures"),
				match(Criteria.where("fixtures.fixtureId").is(fixtureId)),//is("India vs South Africa")),
				group().push("fixtures").as("fixtures").first("name").as("name")
				);
		
		System.out.println("Query used for fetching fixture based on id is : " + typedAggregation);
		final AggregationResults<CricketCompetition> result = mongoTemplate.aggregate(typedAggregation, "cricketCompetition", CricketCompetition.class);
		
		return getFirstCompetition(result.getMappedResults());
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
	 * @return the competitionRepository
	 */
	public CricketCompetitionRepository getCompetitionRepository() {
		return competitionRepository;
	}

	/**
	 * @param competitionRepository the competitionRepository to set
	 */
	public void setCompetitionRepository(CricketCompetitionRepository competitionRepository) {
		this.competitionRepository = competitionRepository;
	}
	
	private CricketCompetition getFirstCompetition(final List<CricketCompetition> competitions)
	{
		if(competitions == null || competitions.isEmpty())
		{
			return null;
		}
		return competitions.get(0);
	}

}
