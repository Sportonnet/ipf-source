/**
 * 
 */
package com.iplfreaks.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.iplfreaks.dao.api.ICricketCompetitionDao;
import com.iplfreaks.dao.repository.CricketCompetitionRepository;
import com.iplfreaks.game.cricket.CricketCompetition;

/**
 * @author jayeshm3
 *
 */
public class CricketCompetitionDaoImpl implements ICricketCompetitionDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CricketCompetitionRepository competitionRepository;

	@Override
	public CricketCompetition getCompetitionFixtures(final String name, final String sport) {
		
		final List<CricketCompetition> competitions = getCompetitionRepository().findByNameAndSportAndIsActive(name, sport, true);
		
		if(competitions == null || competitions.isEmpty())
		{
			return null;
		}
		return competitions.get(0);
	}

	@Override
	public List<CricketCompetition> getActiveCompetitions() {
		return getCompetitionRepository().findByIsActive(true);
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
	 * @return the competitionRepository
	 */
	public CricketCompetitionRepository getCompetitionRepository() {
		return competitionRepository;
	}

	/**
	 * @param competitionRepository the competitionRepository to set
	 */
	public void setCompetitionRepository(CricketCompetitionRepository competitionRepository) {
		this.competitionRepository = competitionRepository;
	}
}
