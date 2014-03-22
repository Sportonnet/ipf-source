/**
 * 
 */
package com.iplfreaks.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.iplfreaks.dao.api.IUserLeaguesDao;
import com.iplfreaks.dao.repository.UserLeagueRepository;
import com.iplfreaks.user.UserLeagues;

/**
 * @author jayeshm3
 * 
 */
public class UserLeaguesDaoImpl implements IUserLeaguesDao {

	private UserLeagueRepository userLeagueRepository;

	private MongoTemplate mongoTemplate;

	@Override
	public void addUserLeague(final String email, final String leagueName) {
		final Query query = new Query(Criteria.where("email").is(email));
		final Update update = new Update();
		update.addToSet("leagues", leagueName);
		this.mongoTemplate.upsert(query, update, "userLeagues");
	}

	@Override
	public UserLeagues fetchUserLeagues(final String email) {
		final List<UserLeagues> userLeaguesList = this.userLeagueRepository
				.findByEmail(email);

		if (userLeaguesList == null || userLeaguesList.isEmpty()) {
			return null;
		}

		return userLeaguesList.get(0);
	}

	/**
	 * @param userLeagueRepository
	 *            the userLeagueRepository to set
	 */
	public void setUserLeagueRepository(
			UserLeagueRepository userLeagueRepository) {
		this.userLeagueRepository = userLeagueRepository;
	}

	/**
	 * @return the mongoTemplate
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * @param mongoTemplate
	 *            the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
}
