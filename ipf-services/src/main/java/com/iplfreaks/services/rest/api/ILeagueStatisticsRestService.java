/**
 * 
 */
package com.iplfreaks.services.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * @author aniketd2
 * 
 */
@Path("/leagueStats")
public interface ILeagueStatisticsRestService {

	@GET
	@Path("/getFixtureScore")
	public String fetchFixtureScore(
			@QueryParam("leagueName") String leagueName,
			@QueryParam("fixtureId") String fixtureId);

	@GET
	@Path("/getLeagueScore")
	public String fetchLeagueScore(@QueryParam("leagueName") String leagueName);
}
