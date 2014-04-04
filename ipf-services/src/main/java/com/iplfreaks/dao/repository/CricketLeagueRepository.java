/**
 * 
 */
package com.iplfreaks.dao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iplfreaks.core.League;
import com.iplfreaks.game.cricket.CricketLeague;

/**
 * @author jayeshm3
 *
 */
public interface CricketLeagueRepository extends MongoRepository<League, String> {
	
	List<CricketLeague> findByName(final String name);

}
