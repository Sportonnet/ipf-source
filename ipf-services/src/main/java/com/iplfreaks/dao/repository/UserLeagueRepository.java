/**
 * 
 */
package com.iplfreaks.dao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iplfreaks.user.UserLeagues;

/**
 * @author jayeshm3
 *
 */
public interface UserLeagueRepository extends MongoRepository<UserLeagues, String> {
	
	List<UserLeagues> findByEmail(final String email);

}
