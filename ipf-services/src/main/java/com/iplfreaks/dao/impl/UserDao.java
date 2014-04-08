package com.iplfreaks.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.iplfreaks.dao.api.IUserDao;
import com.iplfreaks.dao.repository.UserRepository;
import com.iplfreaks.user.User;

public class UserDao implements IUserDao {

	private MongoTemplate mongoTemplate;
	private UserRepository userRepository;

	private static final String USER_COLLECTION = "user";
	
	@Override
	public boolean isUserPresent(final String email) {

		if (fetchUser(email) == null) {
			return false;
		}
		return true;
	}
	

	@Override
	public User fetchUser(String email) {
		return getFirstUser(this.userRepository.findByEmail(email));
	}

	public boolean authenticateUser(final User user) {

		final Query userQuery = new Query(Criteria.where("email")
				.is(user.getEmail()).and("password").is(user.getPassword()));

		// final BasicDBObject userQuery = new BasicDBObject("_id",
		// user.getEmail());
		// userQuery.append("password", user.getPassword());
		// final long userCount = this.userCollection.count(userQuery);

		/*final List<User> userList = this.mongoTemplate.find(userQuery,
				User.class, USER_COLLECTION);*/

		final List<User> userList = this.getUserRepository().findByEmailAndPassword(user.getEmail(), user.getPassword());
		
		if (userList == null || userList.isEmpty()) {
			return false;
		}

		return true;

		// return userCount == 1 ? true : false;
	}
	
	private User getFirstUser(final List<User> userList)
	{
		if (userList == null || userList.isEmpty()) {
			return null;
		}
		
		return userList.get(0);
	}

	public boolean createUser(final User user) {
		getMongoTemplate().insert(user, USER_COLLECTION);
		return true;
	}

	/**
	 * init method
	 */
	public void init() {
		/*System.out.println("getting user collection");
		this.userCollection = mongoTemplate.getCollection(USER_COLLECTION);
		System.out.println("Fetched user collection");*/

		/*
		 * final User user = new User();
		 * user.setEmail("aniket.divekar@citiustech.com");
		 * user.setPassword("aniket");
		 * 
		 * System.out.println(authenticateUser(user));
		 * 
		 * final User newUser = new User();
		 * newUser.setEmail("hiren.develiya@citiustech.com");
		 * newUser.setPassword("hiren"); newUser.setFirstName("hiren");
		 * newUser.setCreatedDate(new DateTime()); createUser(user);
		 * 
		 * final User user2 = new User();
		 * user2.setEmail("hiren.develiya@citiustech.com");
		 * user2.setPassword("hiren");
		 * 
		 * System.out.println(authenticateUser(user2));
		 */
	}

	/**
	 * @return the mongoTemplate
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * @param mongoTemplate
	 *            the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	/**
	 * @return the userRepository
	 */
	public UserRepository getUserRepository() {
		return userRepository;
	}

	/**
	 * @param userRepository the userRepository to set
	 */
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
