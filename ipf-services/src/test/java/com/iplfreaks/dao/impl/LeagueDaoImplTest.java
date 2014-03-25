/**
 * 
 */
package com.iplfreaks.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.iplfreaks.core.Challenger;
import com.iplfreaks.core.League;
import com.iplfreaks.game.Team;
import com.iplfreaks.user.User;

/**
 * @author jayeshm3
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/spring-config-test.xml")
public class LeagueDaoImplTest {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private LeagueDaoImpl leagueDaoImpl;
	
	@Test
	public void testFetchLeague() {
		final League league = leagueDaoImpl.fetchLeague("iplfreaks");
		System.out.println(league.getLeagueStartDate());
	}
	
	@Test
	public void testCreateLeague() {
		this.leagueDaoImpl.createLeague(createLeague());
	}
	
	@Test
	public void testAddChallengersToLeague() {
		final Set<Challenger> challengers = new HashSet<Challenger>();
		final Challenger challenger1 = new Challenger();
		challenger1.setName("c1");
		final User u1 = new User();
		u1.setEmail("a1");
		challenger1.setUser(u1);
		
		//challengers.add(challenger1);
		
		final Challenger challenger2 = new Challenger();
		challenger2.setName("c2");
		final User u2 = new User();
		u2.setEmail("a2");
		challenger2.setUser(u2);
		
		challengers.add(challenger2);
		
		this.leagueDaoImpl.addChallengersToLeague("l1", challengers);
	}
	
	private League createLeague()
	{
		final User user = new User();
		user.setEmail("a");
		final League league = new League("iplfreaks", user);
		league.setLeagueStartDate(new DateTime());
		
		return league;
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
	 * @return the leagueDaoImpl
	 */
	public LeagueDaoImpl getLeagueDaoImpl() {
		return leagueDaoImpl;
	}

	/**
	 * @param leagueDaoImpl the leagueDaoImpl to set
	 */
	public void setLeagueDaoImpl(LeagueDaoImpl leagueDaoImpl) {
		this.leagueDaoImpl = leagueDaoImpl;
	}

}
