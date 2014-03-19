package com.iplfreaks.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.iplfreaks.dao.api.ITeamDao;
import com.iplfreaks.dao.repository.TeamRepository;
import com.iplfreaks.game.Team;

public class TeamDaoImpl implements ITeamDao {

	private MongoTemplate mongoTemplate;
	//private static final String TEAM_COLLECTION = "teams";
	
	@Autowired
	private TeamRepository teamRepository;

	/**
	 * @param teamRepository the teamRepository to set
	 */
	public void setTeamRepository(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	@Override
	public Team getTeamDetails(String teamName) {

		/*final Query teamDetailsQuery = new Query(Criteria.where("name").is(
				teamName));

		final Team team = this.mongoTemplate.findOne(teamDetailsQuery,
				Team.class, TEAM_COLLECTION);*/
		
		if(teamName == null)
		{
			throw new IllegalArgumentException("Team name cannot be NULL");
		}
		
		final List<Team> teamList = teamRepository.findByName(teamName.trim());
		
		if(teamList == null || teamList.isEmpty())
		{
			return null;
		}

		return teamList.get(0);
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}
