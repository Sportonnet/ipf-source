package com.iplfreaks.services.api;

import com.iplfreaks.user.UserLeagues;

public interface IUserService {

	/**
	 * 
	 * @param name
	 *            full name of the user
	 * @param emailId
	 *            email id of the user
	 * @param password
	 *            password
	 * @return return true if user is created successfully else false
	 */
	public boolean createUser(String namen, String emailId, String password);

	/**
	 * 
	 * @param userEmail
	 *            email id of the user
	 * @return
	 * @throws Exception
	 */
	public UserLeagues getUserLeagues(String userEmail) throws Exception;
}
