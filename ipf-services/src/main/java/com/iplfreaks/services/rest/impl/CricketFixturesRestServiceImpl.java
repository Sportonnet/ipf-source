package com.iplfreaks.services.rest.impl;

import java.util.List;

import javax.ws.rs.GET;
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
	@GET
	@Path("/getFixtures")
	public String getFixtures(@QueryParam("leagueName") String leagueName) {
		List<Fixture> fixtures = this.fixtureService.getFixtures(leagueName);

		String jsonResponse = new Gson().toJson(fixtures);

		return jsonResponse;
	}

	@Override
	@GET
	@Path("/getPastFixtures")
	public String getPastFixtures(@QueryParam("leagueName") String leagueName) {
		List<Fixture> fixtures = this.fixtureService
				.getPastFixtures(leagueName);

		String jsonResponse = new Gson().toJson(fixtures);

		return jsonResponse;
	}

	@Override
	@GET
	@Path("/getUpcomingFixtures")
	public String getUpcomingFixtures(
			@QueryParam("leagueName") String leagueName) {
		List<Fixture> fixtures = this.fixtureService
				.getUpcomingFixtures(leagueName);
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
