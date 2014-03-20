/**
 * 
 */
package com.iplfreaks.dao.repository;

import java.util.List;

import org.joda.time.DateMidnight;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.iplfreaks.game.Fixture;

/**
 * @author jayeshm3
 *
 */
public interface FixtureRepository extends MongoRepository<Fixture, Long> {

	List<Fixture> findBydateTimeGreaterThan(final DateMidnight dateTime);
	
	List<Fixture> findBydateTimeLessThan(final DateMidnight dateTime);
	
	List<Fixture> findBydateTime(final DateMidnight dateTime);
	
	List<Fixture> findBydateTimeBetween(final DateMidnight dateTime1,final DateMidnight dateTime2, final Sort sort);
	
}
