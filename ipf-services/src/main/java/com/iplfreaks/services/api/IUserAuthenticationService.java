package com.iplfreaks.services.api;

public interface IUserAuthenticationService {

	/**
	 * 
	 * @param emailId
	 *            email id of the user
	 * @param password
	 *            password
	 * @return returns true if user is authenticated else false
	 */
	public boolean isUserAuthorized(String emailId, String password);
}
