package com.iplfreaks.services.rest.impl;

import java.util.List;

import com.iplfreaks.core.ChallengerScore;
import com.iplfreaks.core.LeagueStatistics;
import com.iplfreaks.services.api.ILeagueStatisticsService;
import com.iplfreaks.services.rest.api.ILeagueStatisticsRestService;

public class LeagueStatisticsRestServiceImpl implements
		ILeagueStatisticsRestService {

	private ILeagueStatisticsService leagueStatistics;

	@Override
	public LeagueStatistics fetchFixtureScore(String leagueName,
			String fixtureId) {
		this.leagueStatistics.fetchFixtureScore(leagueName, fixtureId);
		return null;
	}

	@Override
	public List<ChallengerScore> fetchLeagueScore(String leagueName) {
		this.leagueStatistics.fetchLeagueScore(leagueName);
		return null;
	}

	/**
	 * @return the leagueStatistics
	 */
	public ILeagueStatisticsService getLeagueStatistics() {
		return leagueStatistics;
	}

	/**
	 * @param leagueStatistics
	 *            the leagueStatistics to set
	 */
	public void setLeagueStatistics(ILeagueStatisticsService leagueStatistics) {
		this.leagueStatistics = leagueStatistics;
	}

}
