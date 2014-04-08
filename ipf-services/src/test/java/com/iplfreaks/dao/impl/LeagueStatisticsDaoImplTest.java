/**
 * 
 */
package com.iplfreaks.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iplfreaks.core.ChallengerScore;
import com.iplfreaks.core.FixtureScore;
import com.iplfreaks.core.LeagueStatistics;

/**
 * @author jayeshm3
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/spring-config-test.xml")
public class LeagueStatisticsDaoImplTest {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private LeagueStatsDaoImpl leagueStatsDaoImpl;
	
	@Test
	public void testCreateLeagueStats()
	{
		this.mongoTemplate.insert(createLeagueStats(), "leagueStatistics");
	}
	
	@Test
	public void testAddFixtureScore()
	{
		final FixtureScore fs = new FixtureScore("India vs Sri Lanka @ 2014-04-06T19:00:00Z");
		
		final ChallengerScore cs21 = new ChallengerScore();
		cs21.setChallengerName("a");
		cs21.setScore(100);
		
		final ChallengerScore cs22 = new ChallengerScore();
		cs22.setChallengerName("b");
		cs22.setScore(200);
		
		final ChallengerScore cs23 = new ChallengerScore();
		cs23.setChallengerName("c");
		cs23.setScore(300);
		
		final ChallengerScore cs24 = new ChallengerScore();
		cs24.setChallengerName("d");
		cs24.setScore(250);
		
		final Set<ChallengerScore> challengerScores2 = new HashSet<ChallengerScore>();
		challengerScores2.add(cs21);
		challengerScores2.add(cs22);
		challengerScores2.add(cs23);
		challengerScores2.add(cs24);
		
		fs.setChallengerScores(challengerScores2);
		
		this.leagueStatsDaoImpl.addFixtureScore("l1", fs);
	}
	
	@Test
	public void testFetchFixtureScore()
	{
		final LeagueStatistics ls = this.leagueStatsDaoImpl.fetchFixtureScore("l1", "Sri Lanka vs West Indies @ 2014-04-03T19:00:00Z");
		final Set<ChallengerScore> challengerScores = ls.getFixtureScores().iterator().next().getChallengerScores();
		for(final ChallengerScore cs : challengerScores)
		{
			System.out.println("Challenger name is : " + cs.getChallengerName());
			System.out.println("Challenger score is : " + cs.getScore());
		}
	}
	
	@Test
	public void testFetchLeagueScore()
	{
		final List<ChallengerScore> challengerScores = this.leagueStatsDaoImpl.fetchLeagueScore("l1");
		for(final ChallengerScore cs : challengerScores)
		{
			System.out.println("Challenger name is : " + cs.getChallengerName());
			System.out.println("Challenger score is : " + cs.getScore());
		}
	}
	
	private LeagueStatistics createLeagueStats()
	{
		final LeagueStatistics ls = new LeagueStatistics();
		
		ls.setLeagueName("l1");
		
		final HashSet<FixtureScore> fixtureScores = new HashSet<FixtureScore>();
		
		final FixtureScore fs1 = new FixtureScore("Sri Lanka vs West Indies @ 2014-04-03T19:00:00Z");
		
		final ChallengerScore cs11 = new ChallengerScore();
		cs11.setChallengerName("a");
		cs11.setScore(5);
		
		final ChallengerScore cs12 = new ChallengerScore();
		cs12.setChallengerName("b");
		cs12.setScore(10);
		
		final Set<ChallengerScore> challengerScores1 = new HashSet<ChallengerScore>();
		challengerScores1.add(cs11);
		challengerScores1.add(cs12);
		
		fs1.setChallengerScores(challengerScores1);
		
		fixtureScores.add(fs1);
		
		final FixtureScore fs2 = new FixtureScore("India vs South Africa @ 2014-04-04T19:00:00Z");
		
		final ChallengerScore cs21 = new ChallengerScore();
		cs21.setChallengerName("a");
		cs21.setScore(100);
		
		final ChallengerScore cs22 = new ChallengerScore();
		cs22.setChallengerName("b");
		cs22.setScore(200);
		
		final ChallengerScore cs23 = new ChallengerScore();
		cs23.setChallengerName("c");
		cs23.setScore(300);
		
		final Set<ChallengerScore> challengerScores2 = new HashSet<ChallengerScore>();
		challengerScores2.add(cs21);
		challengerScores2.add(cs22);
		challengerScores2.add(cs23);
		
		fs2.setChallengerScores(challengerScores2);
		
		fixtureScores.add(fs2);
		
		ls.setFixtureScores(fixtureScores);
		
		return ls;
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
	 * @return the leagueStatsDaoImpl
	 */
	public LeagueStatsDaoImpl getLeagueStatsDaoImpl() {
		return leagueStatsDaoImpl;
	}

	/**
	 * @param leagueStatsDaoImpl the leagueStatsDaoImpl to set
	 */
	public void setLeagueStatsDaoImpl(LeagueStatsDaoImpl leagueStatsDaoImpl) {
		this.leagueStatsDaoImpl = leagueStatsDaoImpl;
	}

}
