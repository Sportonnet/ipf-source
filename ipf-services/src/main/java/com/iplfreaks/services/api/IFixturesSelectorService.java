package com.iplfreaks.services.api;

import java.util.List;

import org.joda.time.DateTime;

public interface IFixturesSelectorService {
	/**
	 * this method fetches the fixture on the date
	 * 
	 * @param date
	 * @return list of fixtures on date
	 */
	public List<String> getFixtures(final DateTime date);
}
