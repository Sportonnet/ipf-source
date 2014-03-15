package com.iplfreaks.services.rest.impl;

import java.util.List;

import com.google.gson.Gson;
import com.iplfreaks.game.Fixture;
import com.iplfreaks.services.api.IFixturesSelectorService;
import com.iplfreaks.services.rest.api.IFixturesSelectorRestService;

/**
 * 
 * @author aniketd2
 * 
 */
public class FixturesSelectorRestServiceImpl implements
		IFixturesSelectorRestService {

	private IFixturesSelectorService fixtureSelectorService;

	@Override
	public String getFixtures() {
		List<Fixture> fixtures = this.fixtureSelectorService.getFixtures();

		String jsonResponse = new Gson().toJson(fixtures);

		return jsonResponse;
	}

	@Override
	public String getPastFixtures() {
		List<Fixture> fixtures = this.fixtureSelectorService.getPastFixtures();

		String jsonResponse = new Gson().toJson(fixtures);

		return jsonResponse;
	}

	@Override
	public String getUpcomingFixtures() {
		List<Fixture> fixtures = this.fixtureSelectorService
				.getUpcomingFixtures();
		String jsonResponse = new Gson().toJson(fixtures);

		return jsonResponse;
	}

	public IFixturesSelectorService getFixtureSelectorService() {
		return fixtureSelectorService;
	}

	public void setFixtureSelectorService(
			IFixturesSelectorService fixtureSelectorService) {
		this.fixtureSelectorService = fixtureSelectorService;
	}

}
