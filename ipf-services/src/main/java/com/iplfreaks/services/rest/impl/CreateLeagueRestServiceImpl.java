package com.iplfreaks.services.rest.impl;

import com.iplfreaks.services.api.ICreateLeagueService;
import com.iplfreaks.services.rest.api.ICreateLeagueRestService;

/**
 * 
 * @author aniketd2
 * 
 */
public class CreateLeagueRestServiceImpl implements ICreateLeagueRestService {

	private ICreateLeagueService creteLeagueService;

	@Override
	public String createLeague(String competition, String leagueName) {
		return creteLeagueService.createLeague(competition, leagueName);
	}

	public ICreateLeagueService getCreteLeagueService() {
		return creteLeagueService;
	}

	public void setCreteLeagueService(ICreateLeagueService creteLeagueService) {
		this.creteLeagueService = creteLeagueService;
	}

}
