package com.iplfreaks.services.rest.impl;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
import com.iplfreaks.game.Fixture;
import com.iplfreaks.services.api.IFixturesService;
import com.iplfreaks.services.rest.api.IFixturesRestService;

/**
 * 
 * @author aniketd2
 * 
 */
@Path("/cricketfixtures")
@Produces({ "application/json" })
public class CricketFixturesRestServiceImpl implements IFixturesRestService {

	private IFixturesService fixtureService;

	@Override
	@POST
	@Path("/getFixtures")
	public String getFixtures(
			@QueryParam("competitionSport") String competitionSport,
			@QueryParam("competitionName") String competitionName) {
		List<Fixture> fixtures = this.fixtureService.getFixtures(
				competitionSport, competitionName);

		String jsonResponse = new Gson().toJson(fixtures);

		return jsonResponse;
	}

	@Override
	@POST
	@Path("/getPastFixtures")
	public String getPastFixtures(
			@QueryParam("competitionSport") String competitionSport,
			@QueryParam("competitionName") String competitionName) {
		List<Fixture> fixtures = this.fixtureService.getPastFixtures(
				competitionSport, competitionName);

		String jsonResponse = new Gson().toJson(fixtures);

		return jsonResponse;
	}

	@Override
	@POST
	@Path("/getUpcomingFixtures")
	public String getUpcomingFixtures(
			@QueryParam("competitionSport") String competitionSport,
			@QueryParam("competitionName") String competitionName) {
		List<Fixture> fixtures = this.fixtureService.getUpcomingFixtures(
				competitionSport, competitionName);
		String jsonResponse = new Gson().toJson(fixtures);

		return jsonResponse;
	}

	public IFixturesService getFixtureService() {
		return fixtureService;
	}

	public void setFixtureService(IFixturesService fixtureService) {
		this.fixtureService = fixtureService;
	}

}
