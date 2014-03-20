/**
 * 
 */
package com.iplfreaks.dao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iplfreaks.core.League;

/**
 * @author jayeshm3
 *
 */
public interface LeagueRepository extends MongoRepository<League, String> {
	
	List<League> findByName(final String name);

}
