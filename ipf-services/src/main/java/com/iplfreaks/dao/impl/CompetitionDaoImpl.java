/**
 * 
 */
package com.iplfreaks.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.iplfreaks.core.Competition;
import com.iplfreaks.dao.api.ICompetitionDao;
import com.iplfreaks.dao.repository.CompetitionRepository;

/**
 * @author jayeshm3
 *
 */
public class CompetitionDaoImpl implements ICompetitionDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CompetitionRepository competitionRepository;

	@Override
	public Competition getCompetitionFixtures(final String name, final String sport) {
		
		final List<Competition> competitions = getCompetitionRepository().findByNameAndSportAndIsActive(name, sport, true);
		
		if(competitions == null || competitions.isEmpty())
		{
			return null;
		}
		return competitions.get(0);
	}

	@Override
	public List<Competition> getActiveCompetitions() {
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
	public CompetitionRepository getCompetitionRepository() {
		return competitionRepository;
	}

	/**
	 * @param competitionRepository the competitionRepository to set
	 */
	public void setCompetitionRepository(CompetitionRepository competitionRepository) {
		this.competitionRepository = competitionRepository;
	}
}
