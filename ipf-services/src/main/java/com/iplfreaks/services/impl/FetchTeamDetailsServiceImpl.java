package com.iplfreaks.services.impl;

import com.iplfreaks.dao.api.ITeamDao;
import com.iplfreaks.game.Team;
import com.iplfreaks.services.api.IFetchTeamDetailsService;

public class FetchTeamDetailsServiceImpl implements IFetchTeamDetailsService {

	private ITeamDao teamDao;

	@Override
	public Team getTeamDetails(String teamName) {
		return this.teamDao.getTeamDetails(teamName);
	}

	public ITeamDao getFetchTeamDetailsDao() {
		return teamDao;
	}

	public void setFetchTeamDetailsDao(ITeamDao fetchTeamDetailsDao) {
		this.teamDao = fetchTeamDetailsDao;
	}

}
