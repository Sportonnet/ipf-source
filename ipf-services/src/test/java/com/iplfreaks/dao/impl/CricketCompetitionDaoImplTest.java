/**
 * 
 */
package com.iplfreaks.dao.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.iplfreaks.core.BonusEntity;
import com.iplfreaks.dao.repository.CricketCompetitionRepository;
import com.iplfreaks.game.Player;
import com.iplfreaks.game.Team;
import com.iplfreaks.game.cricket.CricketCompetition;
import com.iplfreaks.game.cricket.CricketFixture;
import com.iplfreaks.game.cricket.CricketFixtureOutcome;

/**
 * @author jayeshm3
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/spring-config-test.xml")
public class CricketCompetitionDaoImplTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CricketCompetitionRepository competitionRepository;
	
	@Autowired
	private CricketCompetitionDaoImpl competitionDaoImpl;
	
	@Test
	public void testFetchAllActiveCompetitions()
	{
		final List<CricketCompetition> competitions = this.competitionDaoImpl.getActiveCompetitions();
		Assert.notEmpty(competitions);
	}
	
	@Test
	public void testFetchCompetitionFixture()
	{
		final CricketCompetition competition = this.competitionDaoImpl.getCompetitionFixtures("Indian Premier League", "Cricket");
		Assert.notNull(competition);
	}
	
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
		
		final Criteria ct = new Criteria().andOperator(Criteria.where("name").is("Indian Premier League"), Criteria.where("sport").is("Cricket"), Criteria.where("fixtures").elemMatch(Criteria.where("homeTeam.name").is("Mumbai Indians (MI)")));
		
		final Query q = new Query(ct);
		
		System.out.println(q);
		
		List<CricketCompetition> competitionList = this.mongoTemplate.find(q, CricketCompetition.class);
		
		//System.out.println(competitionList.get(0).getFixtures().size());
		
		//Aggregation agg = Aggregation.newAggregation(Aggregation.match(Criteria.where("name").is("T20 World Cup 2014").andOperator(Criteria.where("sport").is("Cricket"))),Aggregation.unwind("fixtures"), Aggregation.match(Criteria.where("fixtures.fixtureName").is("India vs South Africa")), Aggregation.group("fixtures").push("fixtures"));
		
		/*TypedAggregation<CricketCompetition> typedAgg = new TypedAggregation<CricketCompetition>(CricketCompetition.class, 
				Aggregation.newAggregation(Aggregation.match(Criteria.where("name").is("T20 World Cup 2014").andOperator(Criteria.where("sport").is("Cricket"))),
						Aggregation.unwind("fixtures"), 
						Aggregation.match(Criteria.where("fixtures.fixtureName").is("India vs South Africa")));//, Aggregation.group("fixtures").push("fixtures")));
		
		final AggregationOperation operations = Aggregation.newAggregation(Aggregation.match(Criteria.where("name").is("T20 World Cup 2014").andOperator(Criteria.where("sport").is("Cricket")));*/
		
		TypedAggregation<CricketCompetition> typedAggregation = newAggregation(CricketCompetition.class,
				match(Criteria.where("name").is("T20 World Cup 2014").andOperator(Criteria.where("sport").is("Cricket"))),
				unwind("fixtures"),
				match(Criteria.where("fixtures.fixtureName").is("India vs South Africa")),
				group().push("fixtures").as("fixtures").first("name").as("name")
				);
		
		TypedAggregation<CricketCompetition> typedAggregation1 = newAggregation(CricketCompetition.class,
				unwind("fixtures"),
				match(Criteria.where("fixtures.fixtureName").ne("asdsds")),//is("India vs South Africa")),
				group().push("fixtures").as("fixtures").first("name").as("name")
				);
		
		
		final DateMidnight dmid = new DateMidnight("2014-04-06");
		System.out.println(dmid);
		System.out.println(dmid.minusDays(1));
		
		TypedAggregation<CricketCompetition> typedAggregation2 = newAggregation(CricketCompetition.class,
				match(Criteria.where("name").is("T20 World Cup 2014").andOperator(Criteria.where("sport").is("Cricket"))),
				unwind("fixtures"),
				match(Criteria.where("fixtures.dateTime").lte(dmid).andOperator(Criteria.where("fixtures.dateTime").gt(dmid.minusDays(1)))),
				group().push("fixtures").as("fixtures").first("name").as("name")
				);
		
		System.out.println(typedAggregation);
		
		AggregationResults<CricketCompetition> result = mongoTemplate.aggregate(typedAggregation2, "cricketCompetition", CricketCompetition.class);
		
		System.out.println(result.getMappedResults().get(0).getName());
		
		final CricketCompetition cc = result.getMappedResults().get(0);
		
		System.out.println("Fixture size is : " + cc.getFixtures().size());
		
		for(final CricketFixture cfx : cc.getFixtures())
		{
			System.out.println("Fxitrue details is : " + cfx.getFixtureId());
		}
		
		//List<Competition> competitions = this.mongoTemplate.find(query, Competition.class);
		
		//final Query query = new Query(Criteria.where("name").is("Indian Premier League").and("sport").is("Cricket").and("fixtures.dateTime").gt(dm2));
		
		
		/*final BasicDBObject query = new  BasicDBObject("name", "Indian Premier League");
		query.append("sport", "Cricket");
		query.append("fixtures.dateTime", new BasicDBObject("$gt", dm2));*/
		
		//final DBObject fields = new BasicDBObject("fixtures.$", 1);
		
		//final DBCollection competitionCollection = this.mongoTemplate.getCollection("cricketCompetition");
		
		//final Competition competition = (Competition) competitionCollection.findOne(query, fields);
		/*final DBCursor cursor = competitionCollection.find(query, fields);
		System.out.println(cursor.count());
		
		while(cursor.hasNext())
		{
			System.out.println(cursor.curr());
		}*/
		
		
		
		/*final Sort sort = new Sort(Direction.ASC, "fixtures.dateTime");
		
		final List<CricketCompetition> competitions = this.competitionRepository.findQuery("Indian Premier League", "Cricket", dm1, dm2);
		//final List<Competition> competitions = this.competitionRepository.findByNameAndSportAndFixturesDateTimeBetween("Indian Premier League", "Cricket", dm1, dm2, sort);
		final CricketCompetition c = competitions.get(0);
		final Set<CricketFixture> fixtures = c.getFixtures();
		for(final CricketFixture fixture: fixtures)
		{
			System.out.println(fixture.getFixtureName());
			System.out.println(fixture.getFixtureId());
			System.out.println(fixture.getDateTime());
		}*/
	}
	
	//@Test
	public void testFetchCompetition()
	{
		final List<CricketCompetition> competitions = this.competitionRepository.findByNameAndSportAndSeason("Indian Premier League", "Cricket", "IPL 2014");
		Assert.notEmpty(competitions);
	}
	
	//@Test
	public void testInsertCompetition()
	{
		this.mongoTemplate.insert(getCompetition(), "cricketCompetition");
	}
	
	private CricketCompetition getCompetition()
	{
		final CricketCompetition competition = new CricketCompetition();
		competition.setName("T20 World Cup 2014");
		competition.setSport("Cricket");
		competition.setSeason("T20 2014");
		competition.setActive(true);
		competition.setFixtures(getFixtures());
		
		return competition;
	}
	
	private HashSet<CricketFixture> getFixtures()
	{
		final HashSet<CricketFixture> fixtures = new HashSet<CricketFixture>();
		
		final List<BonusEntity> bonus = new ArrayList<BonusEntity>();
		final BonusEntity be1 = new BonusEntity();
		be1.setBonusQuestion("Which player will score the maximum runs in the match?");
		bonus.add(be1);
		
		final BonusEntity be2 = new BonusEntity();
		be2.setBonusQuestion("What will be the distance of longest six in the match?");
		bonus.add(be2);
		
		final CricketFixture fixture1 = new CricketFixture();
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
		
		fixture1.setVenue("Wankhede Stadium");
		fixture1.setBonus(bonus);
		
		final List<BonusEntity> bonusOutcome = new ArrayList<BonusEntity>();
		final BonusEntity beo1 = new BonusEntity();
		beo1.setBonusQuestion("Which player will score the maximum runs in the match?");
		beo1.setBonusAnswer("Rahul Sharma");
		bonusOutcome.add(beo1);
		
		final BonusEntity beo2 = new BonusEntity();
		beo2.setBonusQuestion("What will be the distance of longest six in the match?");
		beo2.setBonusAnswer("80 - 85 metres");
		bonusOutcome.add(beo2);
		
		final CricketFixtureOutcome cfo = new CricketFixtureOutcome();
		cfo.setBestBatsman(new Player("Sachin Tendulkar"));
		cfo.setBestBowler(new Player("Lasith Malinga"));
		cfo.setManOfTheMatch(new Player("Sachin Tendulkar"));
		cfo.setWinner(mi);
		cfo.setBonus(bonusOutcome);
		
		fixture1.setOutcome(cfo);
		
		fixtures.add(fixture1);
		
		
		final CricketFixture fixture2 = new CricketFixture();
		fixture2.setFixtureName("RCB vs DD");
		
		fixture2.setHomeTeam(rcb);
		fixture2.setAwayTeam(dd);
		
		fixture2.setDateTime(new DateTime("2014-03-26").plusHours(12));
		
		fixture2.setVenue("FerozShah Kotla Ground");
		fixture2.setBonus(bonus);
		
		final List<BonusEntity> bonusOutcome2 = new ArrayList<BonusEntity>();
		final BonusEntity beo3 = new BonusEntity();
		beo3.setBonusQuestion("Which player will score the maximum runs in the match?");
		beo3.setBonusAnswer("Virat Kohli");
		bonusOutcome2.add(beo3);

		final BonusEntity beo4 = new BonusEntity();
		beo4.setBonusQuestion("What will be the distance of longest six in the match?");
		beo4.setBonusAnswer("90 - 95 metres");
		bonusOutcome2.add(beo4);

		final CricketFixtureOutcome cfo2 = new CricketFixtureOutcome();
		cfo2.setBestBatsman(new Player("Virat Kohli"));
		cfo2.setBestBowler(new Player("Chris Gayle"));
		cfo2.setManOfTheMatch(new Player("Virat Kohli"));
		cfo2.setWinner(rcb);
		cfo2.setBonus(bonusOutcome2);
		
		fixture2.setOutcome(cfo2);
		
		
		fixtures.add(fixture2);
		
		final CricketFixture fixture3 = new CricketFixture();
		fixture3.setFixtureName("MI vs RCB");
		
		fixture3.setHomeTeam(mi);
		fixture3.setAwayTeam(rcb);
		
		fixture3.setDateTime(new DateTime("2014-03-27").plusHours(12));
		
		//fixtures.add(fixture3);
		
		return fixtures;
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
	 * @return the competitionDaoImpl
	 */
	public CricketCompetitionDaoImpl getCompetitionDaoImpl() {
		return competitionDaoImpl;
	}

	/**
	 * @param competitionDaoImpl the competitionDaoImpl to set
	 */
	public void setCompetitionDaoImpl(CricketCompetitionDaoImpl competitionDaoImpl) {
		this.competitionDaoImpl = competitionDaoImpl;
	}
}
