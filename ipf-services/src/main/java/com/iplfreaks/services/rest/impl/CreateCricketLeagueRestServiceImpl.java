package com.iplfreaks.services.rest.impl;

import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;

import com.google.gson.Gson;
import com.iplfreaks.common.RestServiceResponse;
import com.iplfreaks.common.Status;
import com.iplfreaks.services.api.ICreateLeagueService;
import com.iplfreaks.services.rest.api.ICreateLeagueRestService;

/**
 * 
 * @author aniketd2
 * 
 */
@Path("/cricketleagues")
@Produces({ "application/json" })
public class CreateCricketLeagueRestServiceImpl implements
		ICreateLeagueRestService {

	private Logger logger = Logger
			.getLogger(CreateCricketLeagueRestServiceImpl.class);
	private ICreateLeagueService createLeagueService;

	/**
	 * @return the createLeagueService
	 */
	public ICreateLeagueService getCreateLeagueService() {
		return createLeagueService;
	}

	/**
	 * @param createLeagueService
	 *            the createLeagueService to set
	 */
	public void setCreateLeagueService(ICreateLeagueService createLeagueService) {
		this.createLeagueService = createLeagueService;
	}

	@POST
	@Path("/createLeague")
	@Override
	public String createLeague(@FormParam("leagueName") String leagueName,
			@FormParam("leagueOwnerId") String leagueOwnerId,
			@FormParam("competitionName") String competitionName,
			@FormParam("competitionSport") String competitionSport) {
		RestServiceResponse response = null;
		try {

			this.createLeagueService.createLeague(leagueName, leagueOwnerId,
					competitionName, competitionSport);

			response = new RestServiceResponse(Status.SUCCESS.name(), null,
					null);

		} catch (DuplicateKeyException e) {
			this.logger.error("league name'" + leagueName + "'already exists");
			response = new RestServiceResponse(Status.ERROR.name(),
					"league name already exists", null);
		} catch (Exception e) {
			this.logger.error(e.getMessage());
			response = new RestServiceResponse(Status.ERROR.name(),
					"System is temporarily down, please try again later", null);
		}
		return new Gson().toJson(response);
	}

	@POST
	@Path("/addChallengersToLeague")
	@Override
	public String addChallengersToLeague(
			@FormParam("leagueName") String leagueName,
			@FormParam("challengers") List<String> challengers) {
		Map<String, Object> result = null;
		RestServiceResponse response = null;
		try {
			result = this.createLeagueService.addChallengersToLeague(
					leagueName, challengers);
			response = new RestServiceResponse(Status.SUCCESS.name(), null,
					result);
		} catch (Exception e) {
			this.logger.error(e.getMessage());
			response = new RestServiceResponse(Status.ERROR.name(),
					e.getMessage(), null);
		}
		return new Gson().toJson(response);
	}

}
