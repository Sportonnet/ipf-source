package com.iplfreaks.services.rest.api;

import java.util.List;

public interface ICreateLeagueRestService {

	/**
	 * 
	 * @param leagueName
	 *            name of the league
	 * @param leagueOwner
	 *            email id of the league creator
	 * @param competitionName
	 *            name of the competition
	 * @param competitionSport
	 *            name of the sport competition is related to
	 * @return true or false depending on league creation was successful or
	 *         unsuccessful
	 */
	public String createLeague(String leagueName, String leagueOwner,
			String competitionName, String competitionSport);

	/**
	 * 
	 * @param leagueName
	 *            name of the league
	 * 
	 * @param challengers
	 *            list of challengers for the league
	 * @return
	 */
	public String addChallengersToLeague(String leagueName,
			List<String> challengers);
}
