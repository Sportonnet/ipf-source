package com.iplfreaks.services.impl;

import com.iplfreaks.services.api.ICreateUserService;

public class CreateUserServiceImpl implements ICreateUserService {

	@Override
	public boolean createUser(String firstName, String lastName,
			String emailId, String password) {
		return true;
	}

}
