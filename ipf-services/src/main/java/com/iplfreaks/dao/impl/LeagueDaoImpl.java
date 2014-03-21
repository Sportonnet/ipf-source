/**
 * 
 */
package com.iplfreaks.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.iplfreaks.core.League;
import com.iplfreaks.dao.api.ILeagueDao;
import com.iplfreaks.dao.repository.LeagueRepository;

/**
 * @author jayeshm3
 *
 */
public class LeagueDaoImpl implements ILeagueDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private LeagueRepository leagueRepository;

	@Override
	public League fetchLeague(String leagueName) {
		final List<League> leagueList = this.leagueRepository.findByName(leagueName);
		
		if(leagueList == null || leagueList.isEmpty())
		{
			return null;
		}
		
		return leagueList.get(0);
	}
	

	@Override
	public void createLeague(League league) {
		this.mongoTemplate.insert(league);
	}

	@Override
	public void addChallengersToLeague(League league) {
		
	}

	/**
	 * @return the mongoTemplate
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * @param mongoTemplate the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	/**
	 * @return the leagueRepository
	 */
	public LeagueRepository getLeagueRepository() {
		return leagueRepository;
	}

	/**
	 * @param leagueRepository the leagueRepository to set
	 */
	public void setLeagueRepository(LeagueRepository leagueRepository) {
		this.leagueRepository = leagueRepository;
	}
}
