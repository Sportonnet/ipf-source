package com.iplfreaks.services.api;

public interface ICreateUserService {

	/**
	 * 
	 * @param firstName
	 *            first name
	 * @param lastName
	 *            last name
	 * @param emailId
	 *            email id
	 * @param password
	 *            password
	 * @return return true if user is created successfully else false
	 */
	public boolean createUser(String firstName, String lastName,
			String emailId, String password);
}
