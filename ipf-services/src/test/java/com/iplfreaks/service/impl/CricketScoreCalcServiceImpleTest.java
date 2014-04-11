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

import com.iplfreaks.core.BonusEntity;
import com.iplfreaks.dao.impl.CricketLeagueDaoImpl;
import com.iplfreaks.dao.impl.CricketLeagueScoreDaoImpl;
import com.iplfreaks.game.cricket.CricketChallenge;
import com.iplfreaks.game.cricket.CricketCompetition;
import com.iplfreaks.game.cricket.CricketFixture;
import com.iplfreaks.game.cricket.CricketFixtureOutcome;
import com.iplfreaks.game.cricket.CricketLeague;
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
		final CricketLeague league = leagueDaoImpl.fetchLeague("iplfreaks");
		System.out.println(league.getLeagueStartDate());
		System.out.println("Challenger count : " + league.getChallengers().size());
		System.out.println("Pending Challenger count : " + league.getPendingChallengers().size());
	}
	
	@Test
	public void testFetchCricketLeagueScore()
	{
		final CricketLeagueScore leagueScoreDetails = cricketLeagueScoreDaoImpl.fetchCricketLeagueScore("iplfreaks");
		
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
	
	@Test
	public void testCalc()
	{
		final String leagueName = "iplfreaks";
		final CricketLeague league = leagueDaoImpl.fetchLeague(leagueName);
		final CricketLeagueScore cricketLeagueScore = cricketLeagueScoreDaoImpl.fetchCricketLeagueScore(leagueName);
		testCricketScoreCalc(league, cricketLeagueScore);
	}
	
	private void testCricketScoreCalc(final CricketLeague league, final CricketLeagueScore cricketLeagueScore)
	{
		//final Set<Challenger> challengers = league.getChallengers();
		final CricketCompetition competition = league.getCompetition();
		
		final Set<CricketChallenge> cricketChallenges = cricketLeagueScore.getFixturePredictionList();
		for(final CricketChallenge cricketChallenge : cricketChallenges)
		{
			final CricketFixtureOutcome outcome = getCricketFixtureOutcome(competition, cricketChallenge.getFixtureId());
			getScore(outcome, cricketChallenge);
		}
		
	}
	
	private CricketFixtureOutcome getCricketFixtureOutcome(final CricketCompetition competition, final String fixtureId)
	{
		for(final CricketFixture cf : competition.getFixtures())
		{
			if(cf.getFixtureId().equals(fixtureId))
			{
				return cf.getOutcome();
			}
		}
		
		return null;
	}
	
	private int getScore(final CricketFixtureOutcome outcome, final CricketChallenge cricketChallenge )
	{
		for(final CricketPrediction cricketPrediction : cricketChallenge.getPredictions())
		{
			System.out.println(cricketPrediction.getChallenger().getUser().getEmail() + " Prediction score :");
			if(outcome.getBestBatsman().equals(cricketPrediction.getBestBatsman()))
			{
				System.out.println("Batsman prediction : Hit" );
			}
			else{
				System.out.println("Batsman prediction : Miss" );
			}
			
			if(outcome.getBestBowler().equals(cricketPrediction.getBestBowler()))
			{
				System.out.println("Bowler prediction : Hit" );
			}
			else{
				System.out.println("Bowler prediction : Miss" );
			}
			
			if(outcome.getManOfTheMatch().equals(cricketPrediction.getManOfTheMatch()))
			{
				System.out.println("Man of the match prediction : Hit" );
			}
			else{
				System.out.println("Man of the match prediction : Miss" );
			}
			
			if(outcome.getWinner().equals(cricketPrediction.getWinnerTeam()))
			{
				System.out.println("Winner team prediction : Hit" );
			}
			else{
				System.out.println("Winner team prediction : Miss" );
			}
			
			for(final BonusEntity be : cricketPrediction.getBonus())
			{
				if(outcome.getBonus().contains(be))
				{
					System.out.println("Bonus " + be.getBonusQuestion() + " prediction : Hit" );
				}
				else
				{
					System.out.println("Bonus " + be.getBonusQuestion() + " prediction : Miss" );
				}
			}
		}
		
		
		return 0;
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
