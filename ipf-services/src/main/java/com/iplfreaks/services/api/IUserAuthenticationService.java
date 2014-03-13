package com.iplfreaks.services.api;

public interface IUserAuthenticationService {

	/**
	 * 
	 * @param userName
	 *            user name
	 * @param password
	 *            password
	 * @return returns true if user is authenticated else false
	 */
	public boolean isUserAuthorized(String userName, String password);
}
