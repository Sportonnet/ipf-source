package com.iplfreaks.services.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/teams")
@Produces({ "application/json" })
public interface ITeamDetailsRestService {

	/**
	 * Rest Service returns the team details for the team name received
	 * 
	 * @param teamName
	 *            name of the team
	 * @return team details with set of players belonging to team
	 */
	@GET
	@Path("/getTeamDetails")
	public String getTeamDetails(@QueryParam("team") String teamName);

}
