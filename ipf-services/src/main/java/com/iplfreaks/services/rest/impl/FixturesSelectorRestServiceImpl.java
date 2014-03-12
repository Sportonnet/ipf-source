package com.iplfreaks.services.rest.impl;

import java.util.List;

import org.joda.time.DateTime;

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
	public List<String> getFixtures(DateTime date) {
		List<String> fixtures = this.fixtureSelectorService.getFixtures(date);
		return fixtures;
	}

	public IFixturesSelectorService getFixtureSelectorService() {
		return fixtureSelectorService;
	}

	public void setFixtureSelectorService(
			IFixturesSelectorService fixtureSelectorService) {
		this.fixtureSelectorService = fixtureSelectorService;
	}

}
