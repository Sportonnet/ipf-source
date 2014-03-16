package com.iplfreaks.dao.api;

import java.util.List;

import com.iplfreaks.game.Fixture;

public interface IFixtureSelectorDao {

	/**
	 * 
	 * @return the list of fixtures on current date
	 */
	public List<Fixture> getFixtures();

	/**
	 * 
	 * @return the list of fixtures before current date
	 */
	public List<Fixture> getPastFixtures();

	/**
	 * 
	 * @return the list of fixtures after current date
	 */
	public List<Fixture> getUpcomingFixtures();

}
