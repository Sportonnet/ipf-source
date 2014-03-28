/**
 * 
 */
package com.iplfreaks.dao.repository;

import java.util.Date;
import java.util.List;

import org.joda.time.DateMidnight;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.iplfreaks.core.Competition;

/**
 * @author jayeshm3
 *
 */
public interface CompetitionRepository extends MongoRepository<Competition, String> {

	List<Competition> findByNameAndSport(final String name, final String sport);
	
	List<Competition> findByNameAndSportAndSeason(final String name, final String sport, final String season);
	
	List<Competition> findByNameAndSportAndFixturesDateTimeGreaterThan(final String name, final String sport, final Date date);
	
	//@Query(value="{}", fields="{'fixtures.$':1}")
	List<Competition> findByNameAndSportAndFixturesDateTimeBetween(final String name, final String sport, final DateMidnight dateTime1, final DateMidnight dateTime2, Sort sort);
	
	@Query(value="{'name' : ?0,'sport' : ?1,'fixtures.dateTime' : {$gt : ?2},'fixtures.dateTime' : {$lt : ?3}}")//, fields="{'name':1, 'fixtures.$':1}")
	//@Query(fields="{fixturessss.$:1}")
	List<Competition> findQuery(final String name, final String sport, final DateMidnight dateTime1, final DateMidnight dateTime2);
	
}
