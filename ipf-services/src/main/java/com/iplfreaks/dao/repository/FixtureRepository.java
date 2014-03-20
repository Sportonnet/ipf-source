/**
 * 
 */
package com.iplfreaks.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iplfreaks.game.Fixture;

/**
 * @author jayeshm3
 *
 */
public interface FixtureRepository extends MongoRepository<Fixture, String> {

	List<Fixture> findBydateTimeGreaterThan(final Date dateTime);
	
	List<Fixture> findBydateTime(final Date dateTime);
	
	
	
}
