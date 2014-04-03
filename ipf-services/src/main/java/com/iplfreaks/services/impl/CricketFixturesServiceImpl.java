package com.iplfreaks.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.iplfreaks.cache.services.api.ICacheService;
import com.iplfreaks.dao.api.ICricketCompetitionDao;
import com.iplfreaks.game.Fixture;
import com.iplfreaks.game.cricket.CricketCompetition;
import com.iplfreaks.services.api.IFixturesService;

public class CricketFixturesServiceImpl implements IFixturesService {

	private ICricketCompetitionDao cricketCompetitionDao;
	private ICacheService cacheService;

	public void init() {
	}

	@Override
	public List<Fixture> getFixtures(String competitionSport,
			String competitionName) {
		List<Fixture> fixtures = this.cacheService.getFixtures(
				competitionSport, competitionName);

		if (fixtures == null) {
			final CricketCompetition competition = this.cricketCompetitionDao
					.getCompetitionFixtures(competitionName, competitionSport);

			fixtures = new ArrayList<Fixture>(competition.getFixtures());

			if (fixtures != null && !fixtures.isEmpty()) {
				final String key = this.cacheService.generateKey(
						competitionSport, competitionName);
				this.cacheService.put(key, fixtures);
			}
		}

		final List<Fixture> todaysFixtures = new ArrayList<Fixture>();

		for (final Fixture fixture : fixtures) {
			final int day = fixture.getDateTime().toLocalDateTime()
					.getDayOfMonth();
			final int month = fixture.getDateTime().toLocalDateTime()
					.getMonthOfYear();
			final int year = fixture.getDateTime().toLocalDateTime().getYear();
			final LocalDate today = new DateTime().toLocalDate();
			if (year == today.getYear() && day == today.getDayOfMonth()
					&& month == today.getMonthOfYear()) {
				todaysFixtures.add(fixture);
			}
		}

		return todaysFixtures;
	}

	@Override
	public List<Fixture> getPastFixtures(String competitionSport,
			String competitionName) {
		List<Fixture> fixtures = this.cacheService.getFixtures(
				competitionSport, competitionName);

		if (fixtures == null) {
			final CricketCompetition competition = this.cricketCompetitionDao
					.getCompetitionFixtures(competitionName, competitionSport);
			fixtures = new ArrayList<Fixture>(competition.getFixtures());

			if (fixtures != null && !fixtures.isEmpty()) {
				final String key = this.cacheService.generateKey(
						competitionSport, competitionName);
				this.cacheService.put(key, fixtures);
			}
		}
		final List<Fixture> pastFixtures = new ArrayList<Fixture>();

		for (final Fixture fixture : fixtures) {
			final int day = fixture.getDateTime().toLocalDateTime()
					.getDayOfMonth();
			final int month = fixture.getDateTime().toLocalDateTime()
					.getMonthOfYear();
			final LocalDate today = new DateTime().toLocalDate();

			if (month < today.getMonthOfYear()
					|| (month == today.getMonthOfYear() && day < today
							.getDayOfMonth())) {
				pastFixtures.add(fixture);
			}
		}

		return pastFixtures;
	}

	@Override
	public List<Fixture> getUpcomingFixtures(String competitionSport,
			String competitionName) {
		List<Fixture> fixtures = this.cacheService.getFixtures(
				competitionSport, competitionName);

		if (fixtures == null) {
			final CricketCompetition competition = this.cricketCompetitionDao
					.getCompetitionFixtures(competitionName, competitionSport);

			fixtures = new ArrayList<Fixture>(competition.getFixtures());

			if (fixtures != null && !fixtures.isEmpty()) {
				final String key = this.cacheService.generateKey(
						competitionSport, competitionName);
				this.cacheService.put(key, fixtures);
			}
		}

		final List<Fixture> upcomingFixtures = new ArrayList<Fixture>();

		for (final Fixture fixture : fixtures) {
			final int day = fixture.getDateTime().toLocalDateTime()
					.getDayOfMonth();
			final int month = fixture.getDateTime().toLocalDateTime()
					.getMonthOfYear();
			final LocalDate today = new DateTime().toLocalDate();

			if (month > today.getMonthOfYear()
					|| (month == today.getMonthOfYear() && day > today
							.getDayOfMonth())) {
				upcomingFixtures.add(fixture);
			}
		}

		return upcomingFixtures;
	}

	/**
	 * @return the cricketCompetitionDao
	 */
	public ICricketCompetitionDao getCricketCompetitionDao() {
		return cricketCompetitionDao;
	}

	/**
	 * @param cricketCompetitionDao
	 *            the cricketCompetitionDao to set
	 */
	public void setCricketCompetitionDao(
			ICricketCompetitionDao cricketCompetitionDao) {
		this.cricketCompetitionDao = cricketCompetitionDao;
	}

	/**
	 * @return the cacheService
	 */
	public ICacheService getCacheService() {
		return cacheService;
	}

	/**
	 * @param cacheService
	 *            the cacheService to set
	 */
	public void setCacheService(ICacheService cacheService) {
		this.cacheService = cacheService;
	}

}
