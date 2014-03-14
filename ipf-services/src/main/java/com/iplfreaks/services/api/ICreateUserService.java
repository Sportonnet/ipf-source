package com.iplfreaks.services.api;

public interface ICreateUserService {

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
}
