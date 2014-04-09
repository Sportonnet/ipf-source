package com.iplfreaks.services.impl;

import java.util.List;

import com.iplfreaks.core.ChallengerScore;
import com.iplfreaks.core.LeagueStatistics;
import com.iplfreaks.dao.api.ILeagueStatsDao;
import com.iplfreaks.services.api.ILeagueStatisticsService;

public class LeagueStatisticsServiceImpl implements ILeagueStatisticsService {

	private ILeagueStatsDao leagueStatsDao;

	@Override
	public LeagueStatistics fetchFixtureScore(String leagueName,
			String fixtureId) {
		this.leagueStatsDao.fetchFixtureScore(leagueName, fixtureId);
		return null;
	}

	@Override
	public List<ChallengerScore> fetchLeagueScore(String leagueName) {
		this.leagueStatsDao.fetchLeagueScore(leagueName);
		return null;
	}

	/**
	 * @return the leagueStatsDao
	 */
	public ILeagueStatsDao getLeagueStatsDao() {
		return leagueStatsDao;
	}

	/**
	 * @param leagueStatsDao
	 *            the leagueStatsDao to set
	 */
	public void setLeagueStatsDao(ILeagueStatsDao leagueStatsDao) {
		this.leagueStatsDao = leagueStatsDao;
	}

}
