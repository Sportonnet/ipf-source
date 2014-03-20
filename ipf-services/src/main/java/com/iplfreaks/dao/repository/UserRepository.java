/**
 * 
 */
package com.iplfreaks.dao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.iplfreaks.user.User;

/**
 * @author jayeshm3
 *
 */
public interface UserRepository extends MongoRepository<User, String> {
	
	List<User> findByEmailAndPassword(final String email, final String password);
	
	@Query(fields = "{'email':1,'password':0}")
	List<User> findByEmail(final String email);

}
