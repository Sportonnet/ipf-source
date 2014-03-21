package com.iplfreaks.services.api;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author aniketd2
 * 
 */
public interface ICreateLeagueService {

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
	public void createLeague(String leagueName, String leagueOwner,
			String competitionName, String competitionSport);

	/**
	 * 
	 * @param leagueName
	 *            name of the league *
	 * @param challengers
	 *            list of challengers for the league
	 * @return map of <String, List of players> which are successful as well as
	 *         unsuccessful
	 */
	public Map<String, Object> addChallengersToLeague(String leagueName,
			List<String> challengers);
}
