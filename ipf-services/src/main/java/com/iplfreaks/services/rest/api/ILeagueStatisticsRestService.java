/**
 * 
 */
package com.iplfreaks.services.rest.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.iplfreaks.core.ChallengerScore;
import com.iplfreaks.core.LeagueStatistics;

/**
 * @author aniketd2
 * 
 */
@Path("/leagueStats")
public interface ILeagueStatisticsRestService {

	@GET
	@Path("/getFixtureScore")
	public LeagueStatistics fetchFixtureScore(
			@QueryParam("leagueName") String leagueName,
			@QueryParam("fixtureId") String fixtureId);

	@GET
	@Path("/getLeagueScore")
	public List<ChallengerScore> fetchLeagueScore(
			@QueryParam("leagueName") String leagueName);
}
