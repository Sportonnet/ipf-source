package com.iplfreaks.services.rest.impl;

import com.google.gson.Gson;
import com.iplfreaks.game.Team;
import com.iplfreaks.services.api.IFetchTeamDetailsService;
import com.iplfreaks.services.rest.api.IFetchTeamDetailsRestService;

public class FetchTeamDetailsRestServiceImpl implements
		IFetchTeamDetailsRestService {

	private IFetchTeamDetailsService fetchTeamDetailsService;

	@Override
	public String getTeamDetails(String teamName) {
		final Team team = this.fetchTeamDetailsService.getTeamDetails(teamName);
		return new Gson().toJson(team);
	}

	public IFetchTeamDetailsService getFetchTeamDetailsService() {
		return fetchTeamDetailsService;
	}

	public void setFetchTeamDetailsService(
			IFetchTeamDetailsService fetchTeamDetailsService) {
		this.fetchTeamDetailsService = fetchTeamDetailsService;
	}

}
