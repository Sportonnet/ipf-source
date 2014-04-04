package com.iplfreaks.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.iplfreaks.cache.services.api.ICacheService;
import com.iplfreaks.dao.api.ICricketCompetitionDao;
import com.iplfreaks.dao.impl.CricketLeagueDaoImpl;
import com.iplfreaks.game.Fixture;
import com.iplfreaks.game.cricket.CricketCompetition;
import com.iplfreaks.game.cricket.CricketLeague;
import com.iplfreaks.services.api.IFixturesService;

public class CricketFixturesServiceImpl implements IFixturesService {

	private CricketLeagueDaoImpl cricketLeagueDao;
	private ICacheService cacheService;
	private ICricketCompetitionDao cricketCompetitionDao;

	@Override
	public List<Fixture> getFixtures(final String leagueName) {

		final CricketLeague league = this.cricketLeagueDao
				.fetchLeague(leagueName);

		final CricketCompetition competition = league.getCompetition();

		if (competition == null || !competition.isActive()) {
			return null;
		}
		List<Fixture> fixtures = this.cacheService.getFixtures(
				competition.getSport(), competition.getName());

		if (fixtures == null) {
			final CricketCompetition cricketCompetition = this.cricketCompetitionDao
					.getCompetitionFixtures(competition.getName(),
							competition.getSport());

			fixtures = new ArrayList<Fixture>(cricketCompetition.getFixtures());

			if (fixtures != null && !fixtures.isEmpty()) {
				final String key = this.cacheService.generateKey(
						competition.getSport(), competition.getName());
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
	public List<Fixture> getPastFixtures(final String leagueName) {

		final CricketLeague league = this.cricketLeagueDao
				.fetchLeague(leagueName);

		final CricketCompetition competition = league.getCompetition();

		if (competition == null || !competition.isActive()) {
			return null;
		}

		List<Fixture> fixtures = this.cacheService.getFixtures(
				competition.getSport(), competition.getName());

		if (fixtures == null) {
			final CricketCompetition cricketCompetition = this.cricketCompetitionDao
					.getCompetitionFixtures(competition.getName(),
							competition.getSport());
			fixtures = new ArrayList<Fixture>(cricketCompetition.getFixtures());

			if (fixtures != null && !fixtures.isEmpty()) {
				final String key = this.cacheService.generateKey(
						competition.getSport(), competition.getName());
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
	public List<Fixture> getUpcomingFixtures(final String leagueName) {

		final CricketLeague league = this.cricketLeagueDao
				.fetchLeague(leagueName);

		final CricketCompetition competition = league.getCompetition();

		if (competition == null || !competition.isActive()) {
			return null;
		}
		List<Fixture> fixtures = this.cacheService.getFixtures(
				competition.getSport(), competition.getName());

		if (fixtures == null) {
			final CricketCompetition cricketCompetition = this.cricketCompetitionDao
					.getCompetitionFixtures(competition.getName(),
							competition.getSport());
			fixtures = new ArrayList<Fixture>(cricketCompetition.getFixtures());

			if (fixtures != null && !fixtures.isEmpty()) {
				final String key = this.cacheService.generateKey(
						competition.getSport(), competition.getName());
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
	 * @return the cricketLeagueDao
	 */
	public CricketLeagueDaoImpl getCricketLeagueDao() {
		return cricketLeagueDao;
	}

	/**
	 * @param cricketLeagueDao
	 *            the cricketLeagueDao to set
	 */
	public void setCricketLeagueDao(CricketLeagueDaoImpl cricketLeagueDao) {
		this.cricketLeagueDao = cricketLeagueDao;
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
