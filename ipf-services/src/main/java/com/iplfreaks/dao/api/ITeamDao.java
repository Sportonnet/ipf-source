package com.iplfreaks.dao.api;

import java.util.List;

import com.iplfreaks.game.Team;

public interface ITeamDao {

	/**
	 * 
	 * @param teamName
	 *            name of the team
	 * @return team details with set of players belonging to team
	 */
	public Team getTeamDetails(String teamName);

	public List<Team> getAllTeams();
}
