package com.iplfreaks.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iplfreaks.game.Fixture;
import com.iplfreaks.game.cricket.CricketFixture;
import com.iplfreaks.game.cricket.CricketTeam;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/spring-config-test.xml")
public class FixtureSelectorDaoImplTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void test() {
		this.mongoTemplate.insert(getFixtures(), "fixtures");
		this.mongoTemplate.insert(getPastFixtures(), "fixtures");
		this.mongoTemplate.insert(getUpcomingFixtures(), "fixtures");
	}

	private List<Fixture> getFixtures() {

		final List<Fixture> fixtures = new ArrayList<Fixture>();
		final DateTime date1 = new DateTime("2014-03-16").plusDays(0)
				.plusHours(16);
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

		final DateTime date2 = new DateTime("2014-03-16").plusDays(0)
				.plusHours(20);

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

		final DateTime date1 = new DateTime("2014-03-16").minusDays(1)
				.plusHours(16);
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

		final DateTime date2 = new DateTime("2014-03-16").minusDays(2)
				.plusHours(20);
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

		final DateTime date1 = new DateTime("2014-03-16").plusDays(1)
				.plusHours(20);
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

		final DateTime date2 = new DateTime("2014-03-16").plusDays(2)
				.plusHours(16);
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
