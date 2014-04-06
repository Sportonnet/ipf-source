package com.iplfreaks.services.rest.impl;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.iplfreaks.common.Keys;
import com.iplfreaks.common.RestServiceResponse;
import com.iplfreaks.common.Status;
import com.iplfreaks.game.Team;
import com.iplfreaks.services.api.ITeamDetailsService;
import com.iplfreaks.services.rest.api.ITeamDetailsRestService;

public class TeamDetailsRestServiceImpl implements ITeamDetailsRestService {

	private ITeamDetailsService teamDetailsService;

	@Override
	public String getTeamDetails(String teamName) {

		RestServiceResponse response = null;
		try {
			Map<String, Object> result = new HashMap<String, Object>();
			final Team team = this.teamDetailsService.getTeamDetails(teamName);
			result.put(Keys.TEAM.name(), team);
			response = new RestServiceResponse(Status.SUCCESS.name(), null,
					result);

		} catch (Exception e) {
			e.printStackTrace();
			response = new RestServiceResponse(Status.ERROR.name(),
					e.getMessage(), null);
		}
		return new Gson().toJson(response);
	}

	public ITeamDetailsService getTeamDetailsService() {
		return teamDetailsService;
	}

	public void setTeamDetailsService(ITeamDetailsService teamDetailsService) {
		this.teamDetailsService = teamDetailsService;
	}

}
