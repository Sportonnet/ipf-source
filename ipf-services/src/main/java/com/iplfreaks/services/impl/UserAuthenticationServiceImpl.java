package com.iplfreaks.services.impl;

import org.apache.log4j.Logger;

import com.iplfreaks.dao.api.IUserDao;
import com.iplfreaks.services.api.IUserAuthenticationService;
import com.iplfreaks.user.User;

public class UserAuthenticationServiceImpl implements
		IUserAuthenticationService {

	private Logger logger = Logger.getLogger(CreateUserServiceImpl.class);
	private IUserDao userDao;

	@Override
	public boolean isUserAuthorized(String emailId, String password) {
		this.logger.info("authenticating user : " + emailId + password);

		final User user = new User();
		user.setEmail(emailId.toLowerCase());
		user.setPassword(password);

		return userDao.authenticateUser(user);

	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
