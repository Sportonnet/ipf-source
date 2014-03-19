/**
 * 
 */
package com.iplfreaks.dao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iplfreaks.game.Team;

/**
 * @author jayeshm3
 *
 */
public interface TeamRepository extends MongoRepository<Team, String> {
	
	List<Team> findByName(final String name);
	
	List<Team> findByhomeVenue(final String homevenue);
	
	List<Team> findByPlayersName(final String name);

}
