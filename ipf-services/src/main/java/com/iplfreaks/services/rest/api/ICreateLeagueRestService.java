package com.iplfreaks.services.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/leagues")
@Produces({ "application/json" })
public interface ICreateLeagueRestService {

	/**
	 * 
	 * @param competition
	 *            competition name
	 * @param leagueName
	 *            league name
	 * @return
	 */
	@GET
	@Path("/createLeague/{competition}/{leagueName}")
	public String createLeague(@PathParam("competition") String competition,
			@PathParam("leagueName") String leagueName);
}
