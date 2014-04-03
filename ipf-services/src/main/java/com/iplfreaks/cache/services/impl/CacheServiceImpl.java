/**
 * 
 */
package com.iplfreaks.cache.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iplfreaks.cache.services.api.ICacheService;
import com.iplfreaks.dao.api.ICricketCompetitionDao;
import com.iplfreaks.dao.api.ITeamDao;
import com.iplfreaks.game.Fixture;
import com.iplfreaks.game.Team;
import com.iplfreaks.game.cricket.CricketCompetition;
import com.iplfreaks.game.cricket.CricketFixture;

/**
 * @author aniketd2
 * 
 */
public class CacheServiceImpl implements ICacheService {

	private final Map<String, Object> cache = new HashMap<String, Object>();
	private ICricketCompetitionDao cricketCompetitionDao;
	private ITeamDao teamDao;

	public void init() {
		// cache fixtures
		createCricketFixturesCache();
		// cache team details
		createTeamDetailCache();
	}

	private void createTeamDetailCache() {
		final List<Team> teams = this.teamDao.getAllTeams();

		for (final Team team : teams) {
			put(generateKey(team.getName()), team);
		}
	}

	private void createCricketFixturesCache() {
		final List<CricketCompetition> competitions = this.cricketCompetitionDao
				.getActiveCompetitions();

		for (final CricketCompetition competition : competitions) {
			if (competition.isActive()) {

				put(generateKey(competition.getSport(), competition.getName()),
						new ArrayList<CricketFixture>(competition.getFixtures()));
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fixture> getFixtures(String competitionSport,
			String competitionName) {
		final String key = generateKey(competitionSport, competitionName);
		return (List<Fixture>) this.cache.get(key);
	}

	@Override
	public Team getTeam(String teamName) {
		final String key = generateKey(teamName);
		return (Team) this.cache.get(key);
	}

	@Override
	public void put(String key, Object value) {
		this.cache.put(key, value);
	}

	@Override
	public String generateKey(String... keyParams) {

		String key = "";

		if (keyParams.length == 1)
			return keyParams[0];

		for (int i = 0; i < keyParams.length; i++) {
			key = key + keyParams[i] + ".";
		}

		return key.substring(0, key.lastIndexOf('.'));
	}

	/**
	 * @return the cricketCompetitionDao
	 */
	public ICricketCompetitionDao getCricketCompetitionDao() {
		return cricketCompetitionDao;
	}

	/**
	 * @param cricketCompetitionDao
	 *            the cricketCompetitionDao to set
	 */
	public void setCricketCompetitionDao(
			ICricketCompetitionDao cricketCompetitionDao) {
		this.cricketCompetitionDao = cricketCompetitionDao;
	}

	/**
	 * @return the teamDao
	 */
	public ITeamDao getTeamDao() {
		return teamDao;
	}

	/**
	 * @param teamDao
	 *            the teamDao to set
	 */
	public void setTeamDao(ITeamDao teamDao) {
		this.teamDao = teamDao;
	}

}
