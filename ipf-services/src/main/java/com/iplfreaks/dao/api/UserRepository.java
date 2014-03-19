/**
 * 
 */
package com.iplfreaks.dao.api;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iplfreaks.user.User;

/**
 * @author jayeshm3
 *
 */
public interface UserRepository extends MongoRepository<User, String> {
	
	List<User> findByEmailAndPassword(final String email, final String password);

}
