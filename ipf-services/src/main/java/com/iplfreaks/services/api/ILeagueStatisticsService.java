/**
 * 
 */
package com.iplfreaks.services.api;

import java.util.List;

import com.iplfreaks.core.ChallengerScore;
import com.iplfreaks.core.LeagueStatistics;

/**
 * @author aniketd2
 * 
 */
public interface ILeagueStatisticsService {

	public LeagueStatistics fetchFixtureScore(String leagueName,
			String fixtureId);

	public List<ChallengerScore> fetchLeagueScore(String leagueName);
}
