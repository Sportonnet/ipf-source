package com.iplfreaks.services.rest.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.iplfreaks.common.Keys;
import com.iplfreaks.common.RestServiceResponse;
import com.iplfreaks.common.Status;
import com.iplfreaks.core.ChallengerScore;
import com.iplfreaks.core.LeagueStatistics;
import com.iplfreaks.services.api.ILeagueStatisticsService;
import com.iplfreaks.services.rest.api.ILeagueStatisticsRestService;

public class LeagueStatisticsRestServiceImpl implements
		ILeagueStatisticsRestService {

	private ILeagueStatisticsService leagueStatistics;

	@Override
	public String fetchFixtureScore(String leagueName, String fixtureId) {
		RestServiceResponse response = null;
		try {
			final LeagueStatistics fixtureScore = this.leagueStatistics
					.fetchFixtureScore(leagueName, fixtureId);
			if (fixtureScore != null) {
				Map<String, Object> result = new HashMap<String, Object>();
				result.put(Keys.FIXTURE_SCORE.name(), fixtureScore);
				response = new RestServiceResponse(Status.SUCCESS.name(), null,
						result);
			} else {
				response = new RestServiceResponse(Status.ERROR.name(),
						"Score for "
								+ fixtureId
										.substring(0, fixtureId.indexOf("@"))
										.trim() + " is Not Available.", null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response = new RestServiceResponse(Status.ERROR.name(),
					e.getMessage(), null);
		}
		return new Gson().toJson(response);
	}

	@Override
	public String fetchLeagueScore(String leagueName) {
		RestServiceResponse response = null;
		try {
			final List<ChallengerScore> leagueScore = this.leagueStatistics
					.fetchLeagueScore(leagueName);

			if (leagueScore != null && !leagueScore.isEmpty()) {
				Map<String, Object> result = new HashMap<String, Object>();
				result.put(Keys.LEAGUE_SCORE.name(), leagueScore);
				response = new RestServiceResponse(Status.SUCCESS.name(), null,
						result);
			} else {
				response = new RestServiceResponse(Status.ERROR.name(),
						"Score for " + leagueName + " is Not Available.", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new RestServiceResponse(Status.ERROR.name(),
					e.getMessage(), null);
		}
		return new Gson().toJson(response);
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
