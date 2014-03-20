package com.iplfreaks.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iplfreaks.user.UserLeagues;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/spring-config-test.xml")
public class UserLeaguesDaoImplTest {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private UserLeaguesDaoImpl userLeaguesDaoImpl;
	
	@Test
	public void testAddUserLeague()
	{
		userLeaguesDaoImpl.addUserLeague("abc", "l2");
	}
	
	@Test
	public void testFindUserLeagues()
	{
		final UserLeagues userLeagues = userLeaguesDaoImpl.fetchUserLeagues("a");
		System.out.println(userLeagues.getLeagues().size());
	}

	/**
	 * @return the userLeaguesDaoImpl
	 */
	public UserLeaguesDaoImpl getUserLeaguesDaoImpl() {
		return userLeaguesDaoImpl;
	}

	/**
	 * @param userLeaguesDaoImpl the userLeaguesDaoImpl to set
	 */
	public void setUserLeaguesDaoImpl(UserLeaguesDaoImpl userLeaguesDaoImpl) {
		this.userLeaguesDaoImpl = userLeaguesDaoImpl;
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
