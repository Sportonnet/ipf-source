package com.iplfreaks.services.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/teams")
@Produces({ "application/json" })
public interface IFetchTeamDetailsRestService {

	/**
	 * Rest Service returns the team details for the team name received
	 * 
	 * @param teamName
	 *            name of the team
	 * @return team details with set of players belonging to team
	 */
	@GET
	@Path("/getTeamDetails/{team}")
	public String getTeamDetails(@PathParam("team") String teamName);

}
