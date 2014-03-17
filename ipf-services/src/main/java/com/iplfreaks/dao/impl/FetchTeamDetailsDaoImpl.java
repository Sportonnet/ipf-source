package com.iplfreaks.dao.impl;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.iplfreaks.dao.api.IFetchTeamDetailsDao;
import com.iplfreaks.game.Team;

public class FetchTeamDetailsDaoImpl implements IFetchTeamDetailsDao {

	private MongoTemplate mongoTemplate;
	private static final String TEAM_COLLECTION = "teams";

	@Override
	public Team getTeamDetails(String teamName) {

		final Query teamDetailsQuery = new Query(Criteria.where("name").is(
				teamName));

		final Team team = this.mongoTemplate.findOne(teamDetailsQuery,
				Team.class, TEAM_COLLECTION);

		return team;
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}
