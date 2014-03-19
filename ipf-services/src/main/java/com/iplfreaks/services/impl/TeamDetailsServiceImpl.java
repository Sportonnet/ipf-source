package com.iplfreaks.services.impl;

import com.iplfreaks.dao.api.ITeamDao;
import com.iplfreaks.game.Team;
import com.iplfreaks.services.api.ITeamDetailsService;

public class TeamDetailsServiceImpl implements ITeamDetailsService {

	private ITeamDao teamDao;

	@Override
	public Team getTeamDetails(String teamName) {
		return this.teamDao.getTeamDetails(teamName);
	}

	public ITeamDao getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(ITeamDao teamDao) {
		this.teamDao = teamDao;
	}

}
