package com.iplfreaks.services.rest.impl;

import com.google.gson.Gson;
import com.iplfreaks.game.Team;
import com.iplfreaks.services.api.ITeamDetailsService;
import com.iplfreaks.services.rest.api.ITeamDetailsRestService;

public class TeamDetailsRestServiceImpl implements ITeamDetailsRestService {

	private ITeamDetailsService teamDetailsService;

	@Override
	public String getTeamDetails(String teamName) {
		final Team team = this.teamDetailsService.getTeamDetails(teamName);
		return new Gson().toJson(team);
	}

	public ITeamDetailsService getTeamDetailsService() {
		return teamDetailsService;
	}

	public void setTeamDetailsService(ITeamDetailsService teamDetailsService) {
		this.teamDetailsService = teamDetailsService;
	}

}
