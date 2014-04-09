package com.iplfreaks.services.impl;

import java.util.List;

import com.iplfreaks.core.ChallengerScore;
import com.iplfreaks.core.LeagueStatistics;
import com.iplfreaks.dao.api.ILeagueStatsDao;
import com.iplfreaks.services.api.ILeagueStatisticsService;

public class LeagueStatisticsServiceImpl implements ILeagueStatisticsService {

	private ILeagueStatsDao leagueStatisticsDao;

	@Override
	public LeagueStatistics fetchFixtureScore(String leagueName,
			String fixtureId) {
		return this.leagueStatisticsDao
				.fetchFixtureScore(leagueName, fixtureId);
	}

	@Override
	public List<ChallengerScore> fetchLeagueScore(String leagueName) {
		return this.leagueStatisticsDao.fetchLeagueScore(leagueName);
	}

	/**
	 * @return the leagueStatisticsDao
	 */
	public ILeagueStatsDao getLeagueStatisticsDao() {
		return leagueStatisticsDao;
	}

	/**
	 * @param leagueStatisticsDao
	 *            the leagueStatisticsDao to set
	 */
	public void setLeagueStatisticsDao(ILeagueStatsDao leagueStatisticsDao) {
		this.leagueStatisticsDao = leagueStatisticsDao;
	}

}
