package com.iplfreaks.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.iplfreaks.game.Fixture;
import com.iplfreaks.game.cricket.CricketTeam;
import com.iplfreaks.services.api.IFixturesSelectorService;

public class FixturesSelectorService implements IFixturesSelectorService {

	@Override
	public List<Fixture> getFixtures() {
		final List<Fixture> fixtures = new ArrayList<Fixture>();

		final DateTime date = new DateTime(System.nanoTime());
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

		Fixture fixture1 = new Fixture();
		fixture1.setFixtureName(homeTeam1.getName() + " vs "
				+ awayTeam1.getName());
		fixture1.setHomeTeam(homeTeam1);
		fixture1.setAwayTeam(awayTeam1);
		fixture1.setDateTime(date);

		homeTeam2.setCountry("India");
		homeTeam2.setHomeCity("Rajasthan");
		homeTeam2.setName("Rajasthan Royals");

		awayTeam2.setCountry("India");
		awayTeam2.setHomeCity("Bangalore");
		awayTeam2.setName("Royal Chanllegers Bangalore");

		Fixture fixture2 = new Fixture();
		fixture2.setFixtureName(homeTeam2.getName() + " vs "
				+ awayTeam2.getName());
		fixture2.setHomeTeam(homeTeam2);
		fixture2.setAwayTeam(awayTeam2);
		fixture2.setDateTime(date);

		fixtures.add(fixture1);
		fixtures.add(fixture2);

		return fixtures;
	}

	@Override
	public List<Fixture> getPastFixtures() {
		final List<Fixture> fixtures = new ArrayList<Fixture>();

		final DateTime date = new DateTime(System.nanoTime()).minusDays(2);
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

		Fixture fixture1 = new Fixture();
		fixture1.setFixtureName(homeTeam1.getName() + " vs "
				+ awayTeam1.getName());
		fixture1.setHomeTeam(homeTeam1);
		fixture1.setAwayTeam(awayTeam1);
		fixture1.setDateTime(date);

		homeTeam2.setCountry("India");
		homeTeam2.setHomeCity("Kolkata");
		homeTeam2.setName("Kolkata Knight Riders");

		awayTeam2.setCountry("India");
		awayTeam2.setHomeCity("Hyderabad");
		awayTeam2.setName("Sunrisers Hyderabad");

		Fixture fixture2 = new Fixture();
		fixture2.setFixtureName(homeTeam2.getName() + " vs "
				+ awayTeam2.getName());
		fixture2.setHomeTeam(homeTeam2);
		fixture2.setAwayTeam(awayTeam2);
		fixture2.setDateTime(date);

		fixtures.add(fixture1);
		fixtures.add(fixture2);

		return fixtures;
	}

	@Override
	public List<Fixture> getUpcomingFixtures() {
		final List<Fixture> fixtures = new ArrayList<Fixture>();

		final DateTime date = new DateTime(System.nanoTime()).plusDays(1);
		final CricketTeam homeTeam1 = new CricketTeam();
		final CricketTeam homeTeam2 = new CricketTeam();

		final CricketTeam awayTeam1 = new CricketTeam();
		final CricketTeam awayTeam2 = new CricketTeam();

		homeTeam1.setCountry("India");
		homeTeam1.setHomeCity("Panjab");
		homeTeam1.setName("Kings XI Panjab");

		awayTeam1.setCountry("India");
		awayTeam1.setHomeCity("Chennai");
		awayTeam1.setName("Chennai Super Kings");

		Fixture fixture1 = new Fixture();
		fixture1.setFixtureName(homeTeam1.getName() + " vs "
				+ awayTeam1.getName());
		fixture1.setHomeTeam(homeTeam1);
		fixture1.setAwayTeam(awayTeam1);
		fixture1.setDateTime(date);

		homeTeam2.setCountry("India");
		homeTeam2.setHomeCity("Rajasthan");
		homeTeam2.setName("Rajasthan Royals");

		awayTeam2.setCountry("India");
		awayTeam2.setHomeCity("Hyderabad");
		awayTeam2.setName("Sunrisers Hyderabad");

		Fixture fixture2 = new Fixture();
		fixture2.setFixtureName(homeTeam2.getName() + " vs "
				+ awayTeam2.getName());
		fixture2.setHomeTeam(homeTeam2);
		fixture2.setAwayTeam(awayTeam2);
		fixture2.setDateTime(date);

		fixtures.add(fixture1);
		fixtures.add(fixture2);

		return fixtures;
	}
}
