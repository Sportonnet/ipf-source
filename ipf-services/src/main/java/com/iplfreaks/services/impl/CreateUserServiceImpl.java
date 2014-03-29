package com.iplfreaks.services.impl;

import org.apache.log4j.Logger;

import com.iplfreaks.dao.api.IUserDao;
import com.iplfreaks.services.api.ICreateUserService;
import com.iplfreaks.user.User;

public class CreateUserServiceImpl implements ICreateUserService {

	private Logger logger = Logger.getLogger(CreateUserServiceImpl.class);
	private IUserDao userDao;

	@Override
	public boolean createUser(String name, String emailId, String password) {
		this.logger.info("First Name : " + name);
		this.logger.info("Email Id : " + emailId);
		this.logger.info("Password : " + password);

		final User user = new User();
		user.setFirstName(name);
		user.setEmail(emailId.toLowerCase());
		user.setPassword(password);
		return this.userDao.createUser(user);
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
