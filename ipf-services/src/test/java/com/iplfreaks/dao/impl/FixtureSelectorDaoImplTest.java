package com.iplfreaks.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iplfreaks.dao.repository.FixtureRepository;
import com.iplfreaks.game.Fixture;
import com.iplfreaks.game.cricket.CricketFixture;
import com.iplfreaks.game.cricket.CricketTeam;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/spring-config-test.xml")
public class FixtureSelectorDaoImplTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private FixtureRepository fixtureRepository;
	
	@Test
	public void testFetchFixture()
	{
		final DateTime dt = new DateTime();
		dt.withTime(0, 0, 0, 0);
		//System.out.println(dt);
		
		DateMidnight dm1 = new DateMidnight(DateTimeZone.UTC);
		dm1 = dm1.minusDays(1);
		System.out.println(dm1);
		
		DateMidnight dm2 = dm1.plusDays(1);
		System.out.println(dm2);
		
		//final List<Fixture> fixtureList = fixtureRepository.findBydateTimeLessThan(dm);
		final Sort sort = new Sort(Direction.ASC, "dateTime");
		final List<Fixture> fixtureList = fixtureRepository.findBydateTimeBetween(dm1, dm2, sort);
		for(final Fixture fixture: fixtureList)
		{
			System.out.println(fixture.getDateTime());
		}
	}

	@Test
	public void test() {
		this.mongoTemplate.insert(getFixtures(), "fixtures");
		this.mongoTemplate.insert(getPastFixtures(), "fixtures");
		this.mongoTemplate.insert(getUpcomingFixtures(), "fixtures");
	}

	private List<Fixture> getFixtures() {

		final List<Fixture> fixtures = new ArrayList<Fixture>();
		final DateTime date1 = new DateTime("2014-03-17").plusDays(0)
				.plusHours(16).toDateTime(DateTimeZone.getDefault());
		final CricketTeam homeTeam1 = new CricketTeam();
		final CricketTeam homeTeam2 = new CricketTeam();

		final CricketTeam awayTeam1 = new CricketTeam();
		final CricketTeam awayTeam2 = new CricketTeam();

		homeTeam1.setCountry("India");
		homeTeam1.setHomeCity("Panjab");
		homeTeam1.setName("Kings XI Panjab");

		awayTeam1.setCountry("India");
		awayTeam1.setHomeCity("Delhi");
		awayTeam1.setName("Delhi Daredevils");

		final CricketFixture fixture1 = new CricketFixture();
		fixture1.setFixtureName(homeTeam1.getName() + " vs "
				+ awayTeam1.getName());
		fixture1.setHomeTeam(homeTeam1);
		fixture1.setAwayTeam(awayTeam1);
		fixture1.setDateTime(date1);

		homeTeam2.setCountry("India");
		homeTeam2.setHomeCity("Kolkata");
		homeTeam2.setName("Kolkata Knight Riders");

		awayTeam2.setCountry("India");
		awayTeam2.setHomeCity("Hyderabad");
		awayTeam2.setName("Sunrisers Hyderabad");

		final DateTime date2 = new DateTime("2014-03-17").plusDays(0)
				.plusHours(20).toDateTime(DateTimeZone.getDefault());

		final CricketFixture fixture2 = new CricketFixture();
		fixture2.setFixtureName(homeTeam2.getName() + " vs "
				+ awayTeam2.getName());
		fixture2.setHomeTeam(homeTeam2);
		fixture2.setAwayTeam(awayTeam2);
		fixture2.setDateTime(date2);

		fixtures.add(fixture1);
		fixtures.add(fixture2);
		return fixtures;
	}

	private List<Fixture> getPastFixtures() {
		final List<Fixture> fixtures = new ArrayList<Fixture>();

		final DateTime date1 = new DateTime("2014-03-17").minusDays(1)
				.plusHours(16).toDateTime(DateTimeZone.getDefault());
		final CricketTeam homeTeam1 = new CricketTeam();
		final CricketTeam homeTeam2 = new CricketTeam();

		final CricketTeam awayTeam1 = new CricketTeam();
		final CricketTeam awayTeam2 = new CricketTeam();

		homeTeam1.setCountry("India");
		homeTeam1.setHomeCity("Mumbai");
		homeTeam1.setName("Mumbai Indians");

		awayTeam1.setCountry("India");
		awayTeam1.setHomeCity("Chennai");
		awayTeam1.setName("Chennai Super Kings");

		final CricketFixture fixture1 = new CricketFixture();
		fixture1.setFixtureName(homeTeam1.getName() + " vs "
				+ awayTeam1.getName());
		fixture1.setHomeTeam(homeTeam1);
		fixture1.setAwayTeam(awayTeam1);
		fixture1.setDateTime(date1);

		homeTeam2.setCountry("India");
		homeTeam2.setHomeCity("Rajasthan");
		homeTeam2.setName("Rajasthan Royals");

		awayTeam2.setCountry("India");
		awayTeam2.setHomeCity("Bangalore");
		awayTeam2.setName("Royal Chanllegers Bangalore");

		final DateTime date2 = new DateTime("2014-03-17").minusDays(2)
				.plusHours(20).toDateTime(DateTimeZone.getDefault());
		final CricketFixture fixture2 = new CricketFixture();
		fixture2.setFixtureName(homeTeam2.getName() + " vs "
				+ awayTeam2.getName());
		fixture2.setHomeTeam(homeTeam2);
		fixture2.setAwayTeam(awayTeam2);
		fixture2.setDateTime(date2);

		fixtures.add(fixture1);
		fixtures.add(fixture2);

		return fixtures;
	}

	private List<Fixture> getUpcomingFixtures() {
		final List<Fixture> fixtures = new ArrayList<Fixture>();

		final DateTime date1 = new DateTime("2014-03-17").plusDays(1)
				.plusHours(20).toDateTime(DateTimeZone.getDefault());
		final CricketTeam homeTeam1 = new CricketTeam();
		final CricketTeam homeTeam2 = new CricketTeam();

		final CricketTeam awayTeam1 = new CricketTeam();
		final CricketTeam awayTeam2 = new CricketTeam();

		homeTeam1.setCountry("India");
		homeTeam1.setHomeCity("Mumbai");
		homeTeam1.setName("Mumbai Indians");

		awayTeam1.setCountry("India");
		awayTeam1.setHomeCity("Bangalore");
		awayTeam1.setName("Royal Chanllegers Bangalore");

		final CricketFixture fixture1 = new CricketFixture();
		fixture1.setFixtureName(homeTeam1.getName() + " vs "
				+ awayTeam1.getName());
		fixture1.setHomeTeam(homeTeam1);
		fixture1.setAwayTeam(awayTeam1);
		fixture1.setDateTime(date1);

		homeTeam2.setCountry("India");
		homeTeam2.setHomeCity("Rajasthan");
		homeTeam2.setName("Rajasthan Royals");

		awayTeam2.setCountry("India");
		awayTeam2.setHomeCity("Chennai");
		awayTeam2.setName("Chennai Super Kings");

		final DateTime date2 = new DateTime("2014-03-17").plusDays(2)
				.plusHours(16).toDateTime(DateTimeZone.getDefault());
		final CricketFixture fixture2 = new CricketFixture();
		fixture2.setFixtureName(homeTeam2.getName() + " vs "
				+ awayTeam2.getName());
		fixture2.setHomeTeam(homeTeam2);
		fixture2.setAwayTeam(awayTeam2);
		fixture2.setDateTime(date2);

		fixtures.add(fixture1);
		fixtures.add(fixture2);

		return fixtures;
	}
}
