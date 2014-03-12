package com.iplfreaks.services.api;

/**
 * 
 * @author aniketd2
 * 
 */
public interface ICreateLeagueService {

	/**
	 * this method creates league
	 * 
	 * @param competition
	 *            competition name
	 * @param legueName
	 *            league name
	 * @return id of the league created
	 */
	public String createLeague(String competition, String legueName);
}
