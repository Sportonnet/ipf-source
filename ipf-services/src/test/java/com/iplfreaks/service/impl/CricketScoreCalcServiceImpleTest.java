/**
 * 
 */
package com.iplfreaks.service.impl;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iplfreaks.core.Challenger;
import com.iplfreaks.core.Competition;
import com.iplfreaks.core.League;
import com.iplfreaks.dao.impl.CricketLeagueScoreDaoImpl;
import com.iplfreaks.dao.impl.CricketLeagueDaoImpl;
import com.iplfreaks.game.cricket.CricketChallenge;
import com.iplfreaks.game.cricket.CricketLeagueScore;
import com.iplfreaks.game.cricket.CricketPrediction;

/**
 * @author jayeshm3
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/spring-config-test.xml")
public class CricketScoreCalcServiceImpleTest {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CricketLeagueDaoImpl leagueDaoImpl;
	
	@Autowired
	private CricketLeagueScoreDaoImpl cricketLeagueScoreDaoImpl;
	
	@Test
	public void testFetchLeague() {
		final League league = leagueDaoImpl.fetchLeague("iplfreaks");
		System.out.println(league.getLeagueStartDate());
		System.out.println("Challenger count : " + league.getChallengers().size());
		System.out.println("Pending Challenger count : " + league.getPendingChallengers().size());
	}
	
	@Test
	public void testFetchCricketLeagueScore()
	{
		final CricketLeagueScore leagueScoreDetails = null;
		
		final Set<CricketChallenge> challenges = leagueScoreDetails.getFixturePredictionList();
		System.out.println("Challenges size : " + challenges.size());
		
		for(final CricketChallenge challenge : challenges)
		{
			System.out.println("Fixture : " + challenge.getFixtureId());
			final Set<CricketPrediction> predictions = challenge.getPredictions();
			if(predictions == null || predictions.isEmpty())
			{
				System.out.println("No pred");
				continue;
			}
			
			for(final CricketPrediction cp : predictions)
			{
				System.out.println(cp.getBonus().get(1).getBonusAnswer());
			}
		}
	}
	
	private void testCricketScoreCalc(final League league, final CricketLeagueScore cricketLeagueScore)
	{
		//final Set<Challenger> challengers = league.getChallengers();
		
		
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
	 * @return the cricketLeagueScoreDaoImpl
	 */
	public CricketLeagueScoreDaoImpl getCricketLeagueScoreDaoImpl() {
		return cricketLeagueScoreDaoImpl;
	}

	/**
	 * @param cricketLeagueScoreDaoImpl the cricketLeagueScoreDaoImpl to set
	 */
	public void setCricketLeagueScoreDaoImpl(CricketLeagueScoreDaoImpl cricketLeagueScoreDaoImpl) {
		this.cricketLeagueScoreDaoImpl = cricketLeagueScoreDaoImpl;
	}

}
