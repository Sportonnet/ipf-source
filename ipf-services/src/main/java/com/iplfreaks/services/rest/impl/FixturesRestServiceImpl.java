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
	public String getFixtures(String competitionSport, String competitionName) {
		List<Fixture> fixtures = this.fixtureService.getFixtures(
				competitionSport, competitionName);

		String jsonResponse = new Gson().toJson(fixtures);

		return jsonResponse;
	}

	@Override
	public String getPastFixtures(String competitionSport,
			String competitionName) {
		List<Fixture> fixtures = this.fixtureService.getPastFixtures(
				competitionSport, competitionName);

		String jsonResponse = new Gson().toJson(fixtures);

		return jsonResponse;
	}

	@Override
	public String getUpcomingFixtures(String competitionSport,
			String competitionName) {
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
