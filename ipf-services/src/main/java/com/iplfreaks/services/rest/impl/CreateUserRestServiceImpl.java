package com.iplfreaks.services.rest.impl;

import org.springframework.dao.DuplicateKeyException;

import com.google.gson.Gson;
import com.iplfreaks.common.RestServiceResponse;
import com.iplfreaks.common.Status;
import com.iplfreaks.services.api.ICreateUserService;
import com.iplfreaks.services.rest.api.ICreateUserRestService;

public class CreateUserRestServiceImpl implements ICreateUserRestService {

	private ICreateUserService createUserService;

	@Override
	public String createUser(String name, String emailId, String password) {

		RestServiceResponse response = null;
		try {
			this.createUserService.createUser(name, emailId, password);
			response = new RestServiceResponse(Status.SUCCESS.name(), null,
					null);
		} catch (DuplicateKeyException e) {
			response = new RestServiceResponse(Status.ERROR.name(),
					"user already exists", null);
		} catch (Exception e) {
			response = new RestServiceResponse(Status.ERROR.name(),
					"System is temporarily down, please try again later", null);
		}

		return new Gson().toJson(response);
	}

	public ICreateUserService getCreateUserService() {
		return createUserService;
	}

	public void setCreateUserService(ICreateUserService createUserService) {
		this.createUserService = createUserService;
	}

}
