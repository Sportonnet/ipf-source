package com.iplfreaks.services.rest.impl;

import java.util.List;

import com.google.gson.Gson;
import com.iplfreaks.game.Fixture;
import com.iplfreaks.services.api.IFixturesService;
import com.iplfreaks.services.rest.api.IFixturesRestService;

/**
 * 
 * @author aniketd2
 * 
 */
public class FixturesRestServiceImpl implements IFixturesRestService {

	private IFixturesService fixtureService;

	@Override
	public String getFixtures() {
		List<Fixture> fixtures = this.fixtureService.getFixtures();

		String jsonResponse = new Gson().toJson(fixtures);

		return jsonResponse;
	}

	@Override
	public String getPastFixtures() {
		List<Fixture> fixtures = this.fixtureService.getPastFixtures();

		String jsonResponse = new Gson().toJson(fixtures);

		return jsonResponse;
	}

	@Override
	public String getUpcomingFixtures() {
		List<Fixture> fixtures = this.fixtureService.getUpcomingFixtures();
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
