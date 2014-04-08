package com.iplfreaks.services.impl;

import org.apache.log4j.Logger;

import com.iplfreaks.dao.api.IUserDao;
import com.iplfreaks.dao.api.IUserLeaguesDao;
import com.iplfreaks.services.api.IUserService;
import com.iplfreaks.user.User;
import com.iplfreaks.user.UserLeagues;

public class UserServiceImpl implements IUserService {

	private Logger logger = Logger.getLogger(UserServiceImpl.class);
	private IUserDao userDao;
	private IUserLeaguesDao userLeagueDao;

	@Override
	public boolean createUser(String name, String emailId, String password) {
		this.logger.info("First Name : " + name);
		this.logger.info("Email Id : " + emailId);
		this.logger.info("Password : " + password);

		final User user = new User();
		user.setFirstName(name);
		user.setEmail(emailId);
		user.setPassword(password);
		return this.userDao.createUser(user);
	}

	@Override
	public UserLeagues getUserLeagues(String userEmail) throws Exception {
		final UserLeagues userLeagues = this.userLeagueDao
				.fetchUserLeagues(userEmail);

		if (userLeagues == null) {
			throw new Exception("There are no existing leagues for "
					+ userEmail);
		}

		return userLeagues;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @return the userLeagueDao
	 */
	public IUserLeaguesDao getUserLeagueDao() {
		return userLeagueDao;
	}

	/**
	 * @param userLeagueDao
	 *            the userLeagueDao to set
	 */
	public void setUserLeagueDao(IUserLeaguesDao userLeagueDao) {
		this.userLeagueDao = userLeagueDao;
	}

}
