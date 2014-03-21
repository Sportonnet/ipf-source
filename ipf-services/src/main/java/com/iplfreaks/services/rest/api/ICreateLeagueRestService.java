package com.iplfreaks.services.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/leagues")
@Produces({ "application/json" })
public interface ICreateLeagueRestService {

	/**
	 * 
	 * @param leagueName
	 *            name of the league
	 * @param leagueOwner
	 *            email id of the league creator
	 * @param competitionName
	 *            name of the competition
	 * @param competitionSport
	 *            name of the sport competition is related to
	 * @return true or false depending on league creation was successful or
	 *         unsuccessful
	 */
	@POST
	@Path("/createLeague")
	public String createLeague(@FormParam("leagueName") String leagueName,
			@FormParam("leagueOwnerId") String leagueOwner,
			@FormParam("competitionName") String competitionName,
			@FormParam("competitionSport") String competitionSport);

	/**
	 * 
	 * @param leagueName
	 *            name of the league
	 * 
	 * @param challengers
	 *            list of challengers for the league
	 * @return
	 */
	@POST
	@Path("/addChallengersToLeague")
	public String addChallengersToLeague(
			@FormParam("leagueName") String leagueName,
			@FormParam("challenger") List<String> challengers);
}
