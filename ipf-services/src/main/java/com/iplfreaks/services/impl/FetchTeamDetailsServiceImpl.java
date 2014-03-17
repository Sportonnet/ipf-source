package com.iplfreaks.services.impl;

import com.iplfreaks.dao.api.IFetchTeamDetailsDao;
import com.iplfreaks.game.Team;
import com.iplfreaks.services.api.IFetchTeamDetailsService;

public class FetchTeamDetailsServiceImpl implements IFetchTeamDetailsService {

	private IFetchTeamDetailsDao fetchTeamDetailsDao;

	@Override
	public Team getTeamDetails(String teamName) {
		return this.fetchTeamDetailsDao.getTeamDetails(teamName);
	}

	public IFetchTeamDetailsDao getFetchTeamDetailsDao() {
		return fetchTeamDetailsDao;
	}

	public void setFetchTeamDetailsDao(IFetchTeamDetailsDao fetchTeamDetailsDao) {
		this.fetchTeamDetailsDao = fetchTeamDetailsDao;
	}

}
