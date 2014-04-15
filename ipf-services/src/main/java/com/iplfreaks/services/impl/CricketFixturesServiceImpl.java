package com.iplfreaks.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.iplfreaks.dao.api.ICricketCompetitionDao;
import com.iplfreaks.dao.impl.CricketLeagueDaoImpl;
import com.iplfreaks.game.Fixture;
import com.iplfreaks.game.cricket.CricketCompetition;
import com.iplfreaks.game.cricket.CricketLeague;
import com.iplfreaks.services.api.IFixturesService;

public class CricketFixturesServiceImpl implements IFixturesService {

	private CricketLeagueDaoImpl cricketLeagueDao;
	private ICricketCompetitionDao cricketCompetitionDao;

	@Override
	public List<Fixture> getFixtures(final String leagueName) {

		final CricketLeague league = this.cricketLeagueDao
				.fetchLeague(leagueName);

		if (league == null || league.getCompetition() == null
				|| !league.getCompetition().isActive()) {
			return null;
		}

		final CricketCompetition competition = league.getCompetition();

		final CricketCompetition cricketCompetition = this.cricketCompetitionDao
				.getTodaysFixtures(competition.getName(),
						competition.getSport());
		if (cricketCompetition != null) {
			final List<Fixture> todaysFixtures = new ArrayList<Fixture>(
					cricketCompetition.getFixtures());

			return todaysFixtures;
		}
		return null;
	}

	@Override
	public List<Fixture> getPastFixtures(final String leagueName) {

		final CricketLeague league = this.cricketLeagueDao
				.fetchLeague(leagueName);

		if (league == null || league.getCompetition() == null
				|| !league.getCompetition().isActive()) {
			return null;
		}

		final CricketCompetition competition = league.getCompetition();

		final CricketCompetition cricketCompetition = this.cricketCompetitionDao
				.getPastFixtures(competition.getName(), competition.getSport());
		if (cricketCompetition != null) {
			final List<Fixture> pastFixtures = new ArrayList<Fixture>(
					cricketCompetition.getFixtures());

			return pastFixtures;
		}
		return null;
	}

	@Override
	public List<Fixture> getUpcomingFixtures(final String leagueName) {

		final CricketLeague league = this.cricketLeagueDao
				.fetchLeague(leagueName);

		if (league == null || league.getCompetition() == null
				|| !league.getCompetition().isActive()) {
			return null;
		}

		final CricketCompetition competition = league.getCompetition();

		final CricketCompetition cricketCompetition = this.cricketCompetitionDao
				.getFutureFixtures(competition.getName(),
						competition.getSport());
		if (cricketCompetition != null) {
			final List<Fixture> upcomingFixtures = new ArrayList<Fixture>(
					cricketCompetition.getFixtures());

			return upcomingFixtures;
		}
		return null;
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

}
