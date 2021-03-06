package com.iplfreaks.services.rest.api;

public interface IFixturesRestService {

	/**
	 * Rest Service returns the fixture which will be held today
	 * 
	 * @return
	 */

	public String getFixtures(String leagueName);

	/**
	 * Rest Service returns all the fixtures before today
	 * 
	 * @return
	 */

	public String getPastFixtures(String leagueName);

	/**
	 * Rest Service returns all the fixtures tomorrow onwards
	 * 
	 * @return
	 */

	public String getUpcomingFixtures(String leagueName);
}
