package com.iplfreaks.services.rest.impl;

import com.iplfreaks.services.api.ICreateUserService;
import com.iplfreaks.services.rest.api.ICreateUserRestService;

public class CreateUserRestServiceImpl implements ICreateUserRestService {

	private ICreateUserService createUserService;

	@Override
	public boolean createUser(String name, String emailId, String password) {
		return this.createUserService.createUser(name, emailId, password);
	}

	public ICreateUserService getCreateUserService() {
		return createUserService;
	}

	public void setCreateUserService(ICreateUserService createUserService) {
		this.createUserService = createUserService;
	}

}
