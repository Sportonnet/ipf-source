package com.iplfreaks.services.api;

import com.iplfreaks.game.Team;

public interface IFetchTeamDetailsService {

	/**
	 * 
	 * @param teamName
	 *            name of the team
	 * @return team details with set of players belonging to team
	 */
	public Team getTeamDetails(String teamName);
}
