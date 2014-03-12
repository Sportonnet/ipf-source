package com.iplfreaks.services.impl;

import java.util.UUID;

import com.iplfreaks.services.api.ICreateLeagueService;

public class CreateLeagueServiceImpl implements ICreateLeagueService {

	@Override
	public String createLeague(String competition, String legueName) {
		return UUID.randomUUID().toString();
	}

}
