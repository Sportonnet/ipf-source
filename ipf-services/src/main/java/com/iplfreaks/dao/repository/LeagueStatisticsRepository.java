/**
 * 
 */
package com.iplfreaks.dao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iplfreaks.core.LeagueStatistics;

/**
 * @author jayeshm3
 *
 */
public interface LeagueStatisticsRepository extends MongoRepository<LeagueStatistics, String> {
	
	List<LeagueStatistics> findByLeagueName(final String leagueName);

}
