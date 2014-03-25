/**
 * 
 */
package com.iplfreaks.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.iplfreaks.core.Challenger;
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
	
	private static final String LEAGUE_COLLECTION = "league";

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
	public void addChallengersToLeague(final String leagueName, final Set<Challenger> challengers) {
		
		final Query query = new Query(Criteria.where("name").is(leagueName));
		
		final League league = fetchLeague(leagueName);
		
		final Set<Challenger> challengersList = league.getChallengers();
		
		if(challengersList != null)
		{
			challengers.addAll(challengersList);
		}
		
		//final MyUpdate update = new MyUpdate();
		//update.myAddToSetAll("challengers", challengers, this.mongoTemplate);
		final Update update = new Update();
		update.set("challengers", challengers);
		//update.pushAll("challengers", challengers.toArray());
		/*for(final Challenger challenger : challengers)
		{
			update.addToSet("challengers", challenger);
			this.mongoTemplate.updateFirst(query, update, LEAGUE_COLLECTION);
		}*/
		
		this.mongoTemplate.updateFirst(query, update, LEAGUE_COLLECTION);
	}
	
	@Override
	public void addPendingChallengersToLeague(String leagueName,
			Set<Challenger> challengers) {
		
		final Query query = new Query(Criteria.where("name").is(leagueName));
		
		final Update update = new Update();
		for(final Challenger challenger : challengers)
		{
			update.addToSet("pendingChallengers", challenger);
		}
		
		this.mongoTemplate.updateFirst(query, update, LEAGUE_COLLECTION);
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
