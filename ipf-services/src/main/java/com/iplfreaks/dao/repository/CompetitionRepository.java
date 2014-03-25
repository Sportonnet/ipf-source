/**
 * 
 */
package com.iplfreaks.dao.repository;

import java.util.Date;
import java.util.List;

import org.joda.time.DateMidnight;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.iplfreaks.core.Competition;

/**
 * @author jayeshm3
 *
 */
public interface CompetitionRepository extends MongoRepository<Competition, String> {

	List<Competition> findByNameAndSport(final String name, final String sport);
	
	List<Competition> findByNameandSportAndFixturesDateTimeGreaterThan(final String name, final String sport, final Date date);
	
	List<Competition> findByNameAndSportAndFixturesDateTimeBetween(final String name, final String sport, final DateMidnight dateTime1, final DateMidnight dateTime2, Sort sort);
	
}
