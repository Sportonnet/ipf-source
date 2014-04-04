package com.iplfreaks.services.rest.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
import com.iplfreaks.common.Keys;
import com.iplfreaks.common.RestServiceResponse;
import com.iplfreaks.common.Status;
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

		RestServiceResponse response = null;

		try {
			Map<String, Object> result = new HashMap<String, Object>();
			List<Fixture> fixtures = this.fixtureService
					.getFixtures(leagueName);
			if (fixtures != null) {
				result.put(Keys.FIXTURES.name(), fixtures);
			} else {
				result.put(Status.ERROR.name(),
						"There are no active competitions");
			}

			response = new RestServiceResponse(Status.SUCCESS.name(), null,
					result);

		} catch (Exception e) {
			e.printStackTrace();
			response = new RestServiceResponse(Status.ERROR.name(),
					"System is temporarily down, please try again later", null);
		}

		return new Gson().toJson(response);
	}

	@Override
	@GET
	@Path("/getPastFixtures")
	public String getPastFixtures(@QueryParam("leagueName") String leagueName) {
		RestServiceResponse response = null;

		try {
			Map<String, Object> result = new HashMap<String, Object>();
			List<Fixture> fixtures = this.fixtureService
					.getPastFixtures(leagueName);

			if (fixtures != null) {
				result.put(Keys.FIXTURES.name(), fixtures);
			} else {
				result.put(Status.ERROR.name(),
						"There are no active competitions");
			}

			response = new RestServiceResponse(Status.SUCCESS.name(), null,
					result);

		} catch (Exception e) {
			e.printStackTrace();
			response = new RestServiceResponse(Status.ERROR.name(),
					"System is temporarily down, please try again later", null);
		}

		return new Gson().toJson(response);
	}

	@Override
	@GET
	@Path("/getUpcomingFixtures")
	public String getUpcomingFixtures(
			@QueryParam("leagueName") String leagueName) {
		RestServiceResponse response = null;

		try {
			Map<String, Object> result = new HashMap<String, Object>();
			List<Fixture> fixtures = this.fixtureService
					.getUpcomingFixtures(leagueName);

			if (fixtures != null) {
				result.put(Keys.FIXTURES.name(), fixtures);
			} else {
				result.put(Status.ERROR.name(),
						"There are no active competitions");
			}

			response = new RestServiceResponse(Status.SUCCESS.name(), null,
					result);

		} catch (Exception e) {
			e.printStackTrace();
			response = new RestServiceResponse(Status.ERROR.name(),
					"System is temporarily down, please try again later", null);
		}

		return new Gson().toJson(response);
	}

	public IFixturesService getFixtureService() {
		return fixtureService;
	}

	public void setFixtureService(IFixturesService fixtureService) {
		this.fixtureService = fixtureService;
	}

}
