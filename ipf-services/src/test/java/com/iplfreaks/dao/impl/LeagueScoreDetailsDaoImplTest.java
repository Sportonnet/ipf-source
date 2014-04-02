/**
 * 
 */
package com.iplfreaks.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.iplfreaks.core.Challenge;
import com.iplfreaks.core.Challenger;
import com.iplfreaks.core.LeagueScoreDetails;
import com.iplfreaks.core.Prediction;
import com.iplfreaks.game.Player;
import com.iplfreaks.game.Team;
import com.iplfreaks.game.cricket.CricketPrediction;
import com.iplfreaks.user.User;

/**
 * @author jayeshm3
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/spring-config-test.xml")
public class LeagueScoreDetailsDaoImplTest {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private LeagueScoreDetailsDaoImpl leagueScoreDetailsDaoImpl;
	
	//@Test
	public void testInsertLeagueScoreDetails()
	{
		this.leagueScoreDetailsDaoImpl.createNewLeagueScoreDetails(createLeagueScoreDetails());
	}
	
	@Test
	public void testFetchUserChallenge()
	{
		final LeagueScoreDetails leagueScoreDetails = this.leagueScoreDetailsDaoImpl.fetchUserChallenge("l1", "DD vs MI @ 25-03-2014", "ch1@gmail.com");
		Assert.notNull(leagueScoreDetails);
		
		final Prediction prediction = leagueScoreDetails.getFixturePredictionList().iterator().next().getPredictions().iterator().next();
		
		final CricketPrediction cp = (CricketPrediction) prediction;
		
		System.out.println(cp.getBestBatsman().getName());
		
	}
	
	@Test
	public void testAddChallengerPrediction()
	{
		final CricketPrediction cricketPrediction = new CricketPrediction();
		
		final Player player = new Player();
		player.setName("Sachin Tendulkar");
		
		final User user = new User();
		user.setEmail("ch1@gmail.com");
		
		final Challenger challenger = new Challenger();
		challenger.setName("ch1");
		challenger.setUser(user);
		
		final Team team = new Team();
		team.setName("MI");
		
		cricketPrediction.setBestBatsman(player);
		cricketPrediction.setBestBowler(player);
		cricketPrediction.setManOfTheMatch(player);
		cricketPrediction.setWinnerTeam(team);
		
		cricketPrediction.setChallenger(challenger);
		
		this.leagueScoreDetailsDaoImpl.addChallengerPrediction("l1", "DD vs MI @ 25-03-2014", cricketPrediction);
		
	}
	
	private LeagueScoreDetails createLeagueScoreDetails()
	{
		final LeagueScoreDetails lsd = new LeagueScoreDetails("l1");
		
		Set<Challenge> challenges = new HashSet<Challenge>();
		
		final Challenge challenge1 = new Challenge();
		challenge1.setFixtureId("MI vs RCB @ 27-03-2014");
		challenges.add(challenge1);
		
		final Challenge challenge2 = new Challenge();
		challenge2.setFixtureId("DD vs RCB @ 26-03-2014");
		challenges.add(challenge2);
		
		final Challenge challenge3 = new Challenge();
		challenge3.setFixtureId("DD vs MI @ 25-03-2014");
		challenges.add(challenge3);
		
		lsd.addAllFixturePrediction(challenges);
		
		return lsd;
	}
	
	

	/**
	 * @return the leagueScoreDetailsDaoImpl
	 */
	public LeagueScoreDetailsDaoImpl getLeagueScoreDetailsDaoImpl() {
		return leagueScoreDetailsDaoImpl;
	}

	/**
	 * @param leagueScoreDetailsDaoImpl the leagueScoreDetailsDaoImpl to set
	 */
	public void setLeagueScoreDetailsDaoImpl(LeagueScoreDetailsDaoImpl leagueScoreDetailsDaoImpl) {
		this.leagueScoreDetailsDaoImpl = leagueScoreDetailsDaoImpl;
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

}
