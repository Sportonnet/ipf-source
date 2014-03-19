package com.iplfreaks.services.api;

import java.util.List;

import com.iplfreaks.game.Fixture;

public interface IFixturesService {
	/**
	 * this method returns the fixture which will be held today
	 * 
	 * @return list of fixtures on date
	 */
	public List<Fixture> getFixtures();

	/**
	 * this method returns all the fixtures before today
	 * 
	 * @return
	 */
	public List<Fixture> getPastFixtures();

	/**
	 * this method returns all the fixtures tomorrow onwards
	 * 
	 * @return
	 */
	public List<Fixture> getUpcomingFixtures();
}
