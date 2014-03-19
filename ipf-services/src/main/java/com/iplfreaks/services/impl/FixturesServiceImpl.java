package com.iplfreaks.services.impl;

import java.util.List;

import com.iplfreaks.dao.api.IFixturesDao;
import com.iplfreaks.game.Fixture;
import com.iplfreaks.services.api.IFixturesService;

public class FixturesServiceImpl implements IFixturesService {

	private IFixturesDao fixtureDao;

	@Override
	public List<Fixture> getFixtures() {
		final List<Fixture> fixtures = this.fixtureDao.getFixtures();
		return fixtures;
	}

	@Override
	public List<Fixture> getPastFixtures() {
		final List<Fixture> fixtures = this.fixtureDao.getPastFixtures();
		return fixtures;
	}

	@Override
	public List<Fixture> getUpcomingFixtures() {
		final List<Fixture> fixtures = this.fixtureDao.getUpcomingFixtures();
		return fixtures;
	}

	public IFixturesDao getFixtureDao() {
		return fixtureDao;
	}

	public void setFixtureDao(IFixturesDao fixtureDao) {
		this.fixtureDao = fixtureDao;
	}

}
