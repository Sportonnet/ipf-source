package com.iplfreaks.dao.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.iplfreaks.dao.api.IUserDao;
import com.iplfreaks.user.User;
import com.mongodb.DBCollection;

public class UserDao implements IUserDao {
	
	private MongoTemplate mongoTemplate;
	private DBCollection userCollection;
	
	private static final String USER_COLLECTION = "user";

	public boolean authenticateUser(final User user) {
		
		
		final Query userQuery = new Query(Criteria.where("email").is(user.getEmail()).and("password").is(user.getPassword()));
		
		
		
		//final BasicDBObject userQuery = new BasicDBObject("_id", user.getEmail());
		//userQuery.append("password", user.getPassword());
		//final long userCount = this.userCollection.count(userQuery);
		
		final List<User> userList = this.mongoTemplate.find(userQuery, User.class, USER_COLLECTION);
		
		if(userList == null || userList.isEmpty())
		{
			return false;
		}
		
		return true;
		
		//return userCount ==	1 ? true : false;
	}
	
	public boolean createUser(final User user) {
		getMongoTemplate().insert(user, USER_COLLECTION);
		return true;
	}
	
	private void init() {
		System.out.println("getting user collection");
		this.userCollection = mongoTemplate.getCollection(USER_COLLECTION);
		System.out.println("Fetched user collection");
		
		/*final User user = new User();
		user.setEmail("aniket.divekar@citiustech.com");
		user.setPassword("aniket");
		
		System.out.println(authenticateUser(user));
		
		final User newUser = new User();
		newUser.setEmail("hiren.develiya@citiustech.com");
		newUser.setPassword("hiren");
		newUser.setFirstName("hiren");
		newUser.setCreatedDate(new DateTime());
		createUser(user);
		
		final User user2 = new User();
		user2.setEmail("hiren.develiya@citiustech.com");
		user2.setPassword("hiren");
		
		System.out.println(authenticateUser(user2));*/
	}

	/**
	 * @return the mongoTemplate
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * @param mongoTemplate the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}
