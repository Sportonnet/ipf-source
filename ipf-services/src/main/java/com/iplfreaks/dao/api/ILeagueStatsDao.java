/**
 * 
 */
package com.iplfreaks.dao.api;

import java.util.List;

import com.iplfreaks.core.ChallengerScore;
import com.iplfreaks.core.FixtureScore;
import com.iplfreaks.core.LeagueStatistics;

/**
 * @author jayeshm3
 *
 */
public interface ILeagueStatsDao {
	
	public void createLeagueStats(final LeagueStatistics leagueStatistics);
	
	public void createLeagueStats(final String leagueName);
	
	public void addFixtureScore(final String leagueName, final FixtureScore fixtureScore);
	
	public LeagueStatistics fetchFixtureScore(final String leagueName, final String fixtureId);
	
	public List<ChallengerScore> fetchLeagueScore(final String leagueName);

}
