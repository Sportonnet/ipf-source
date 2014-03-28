/**
 * 
 */
package com.iplfreaks.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.iplfreaks.core.Competition;
import com.iplfreaks.dao.repository.CompetitionRepository;
import com.iplfreaks.game.Fixture;
import com.iplfreaks.game.Team;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @author jayeshm3
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/spring-config-test.xml")
public class CompetitionDaoImplTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CompetitionRepository competitionRepository;
	
	@Test
	public void testFindFixtures()
	{
		
		DateMidnight dm1 = new DateMidnight("2014-03-26",DateTimeZone.UTC);
		dm1 = dm1.minusDays(1);
		System.out.println(dm1);
		
		DateMidnight dm2 = new DateMidnight("2014-03-26",DateTimeZone.UTC);//.plusDays(3);
		System.out.println(dm2);
		
		final Criteria criteria = new Criteria().andOperator(Criteria.where("name").is("Indian Premier League"), Criteria.where("sport").is("Cricket"), Criteria.where("fixtures.dateTime").gt(dm2));
		
		final Query query = new Query(criteria);
		query.fields().include("fixtures.$");
		//query.addCriteria(new Criteria().)
		
		//List<Competition> competitions = this.mongoTemplate.find(query, Competition.class);
		
		//final Query query = new Query(Criteria.where("name").is("Indian Premier League").and("sport").is("Cricket").and("fixtures.dateTime").gt(dm2));
		
		
		/*final BasicDBObject query = new  BasicDBObject("name", "Indian Premier League");
		query.append("sport", "Cricket");
		query.append("fixtures.dateTime", new BasicDBObject("$gt", dm2));*/
		
		final DBObject fields = new BasicDBObject("fixtures.$", 1);
		
		final DBCollection competitionCollection = this.mongoTemplate.getCollection("competition");
		
		//final Competition competition = (Competition) competitionCollection.findOne(query, fields);
		/*final DBCursor cursor = competitionCollection.find(query, fields);
		System.out.println(cursor.count());
		
		while(cursor.hasNext())
		{
			System.out.println(cursor.curr());
		}*/
		
		
		
		final Sort sort = new Sort(Direction.ASC, "fixtures.dateTime");
		
		final List<Competition> competitions = this.competitionRepository.findQuery("Indian Premier League", "Cricket", dm1, dm2);
		//final List<Competition> competitions = this.competitionRepository.findByNameAndSportAndFixturesDateTimeBetween("Indian Premier League", "Cricket", dm1, dm2, sort);
		final Competition c = competitions.get(0);
		final Set<Fixture> fixtures = c.getFixtures();
		for(final Fixture fixture: fixtures)
		{
			System.out.println(fixture.getFixtureName());
			System.out.println(fixture.getFixtureId());
			System.out.println(fixture.getDateTime());
		}
	}
	
	@Test
	public void testFetchCompetition()
	{
		final List<Competition> competitions = this.competitionRepository.findByNameAndSportAndSeason("Indian Premier League", "Cricket", "IPL 2014");
		Assert.notEmpty(competitions);
	}
	
	//@Test
	public void testInsertCompetition()
	{
		this.mongoTemplate.insert(getCompetition(), "competition");
	}
	
	private Competition getCompetition()
	{
		final Competition competition = new Competition();
		competition.setName("Indian Premier League");
		competition.setSport("Cricket");
		competition.setSeason("IPL 2014");
		competition.setFixtures(getFixtures());
		
		return competition;
	}
	
	private Set<Fixture> getFixtures()
	{
		final Set<Fixture> fixtures = new HashSet<Fixture>();
		
		final Fixture fixture1 = new Fixture();
		fixture1.setFixtureName("MI vs DD");
		
		final Team mi = new Team();
		mi.setName("Mumbai Indians (MI)");
		
		final Team dd = new Team();
		dd.setName("Delhi Daredevils (DD)");
		
		final Team rcb = new Team();
		rcb.setName("Royal Challengers Bangalore (RCB)");
		
		fixture1.setHomeTeam(mi);
		fixture1.setAwayTeam(dd);
		
		fixture1.setDateTime(new DateTime("2014-03-25").plusHours(12));
		
		fixtures.add(fixture1);
		
		
		final Fixture fixture2 = new Fixture();
		fixture2.setFixtureName("RCB vs DD");
		
		fixture2.setHomeTeam(rcb);
		fixture2.setAwayTeam(dd);
		
		fixture2.setDateTime(new DateTime("2014-03-26").plusHours(12));
		
		fixtures.add(fixture2);
		
		final Fixture fixture3 = new Fixture();
		fixture3.setFixtureName("MI vs RCB");
		
		fixture3.setHomeTeam(mi);
		fixture3.setAwayTeam(rcb);
		
		fixture3.setDateTime(new DateTime("2014-03-27").plusHours(12));
		
		fixtures.add(fixture3);
		
		return fixtures;
	}

	/**
	 * @return the competitionRepository
	 */
	public CompetitionRepository getCompetitionRepository() {
		return competitionRepository;
	}

	/**
	 * @param competitionRepository the competitionRepository to set
	 */
	public void setCompetitionRepository(CompetitionRepository competitionRepository) {
		this.competitionRepository = competitionRepository;
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
