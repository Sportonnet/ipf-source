/**
 * 
 */
package com.iplfreaks.cache.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iplfreaks.cache.services.api.ICacheService;
import com.iplfreaks.core.Competition;
import com.iplfreaks.dao.api.ITeamDao;
import com.iplfreaks.dao.impl.TeamDaoImpl;
import com.iplfreaks.dao.repository.CompetitionRepository;
import com.iplfreaks.dao.repository.TeamRepository;
import com.iplfreaks.game.Fixture;
import com.iplfreaks.game.Team;

/**
 * @author aniketd2
 * 
 */
public class CacheServiceImpl implements ICacheService {

	private final Map<String, Object> cache = new HashMap<String, Object>();
	private CompetitionRepository competitionRepository;
	private ITeamDao teamDao;

	@Override
	public List<Fixture> getFixtures(String competitionSport,
			String competitionName) {
		final String key = competitionSport + "," + competitionName;
		return (List<Fixture>) this.cache.get(key);
	}

	@Override
	public Team getTeam(String key) {

		return (Team) this.cache.get(key);
	}

	@Override
	public void put(String key, Object value) {
		this.cache.put(key, value);
	}

	public void init() {
		final List<Competition> competitions = this.competitionRepository
				.findAll();

		for (final Competition competition : competitions) {
			if (competition.isActive()) {
				put(competition.getSport() + "," + competition.getName(),
						new ArrayList<Fixture>(competition.getFixtures()));
			}
		}

		final List<Team> teams = this.teamDao.getAllTeams();

		for (final Team team : teams) {
			put(team.getName(), team);
		}
	}

	/**
	 * @return the competitionRepository
	 */
	public CompetitionRepository getCompetitionRepository() {
		return competitionRepository;
	}

	/**
	 * @param competitionRepository
	 *            the competitionRepository to set
	 */
	public void setCompetitionRepository(
			CompetitionRepository competitionRepository) {
		this.competitionRepository = competitionRepository;
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
