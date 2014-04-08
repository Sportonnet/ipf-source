package com.iplfreaks.services.rest.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DuplicateKeyException;

import com.google.gson.Gson;
import com.iplfreaks.common.Keys;
import com.iplfreaks.common.RestServiceResponse;
import com.iplfreaks.common.Status;
import com.iplfreaks.services.api.IUserService;
import com.iplfreaks.services.rest.api.IUserRestService;
import com.iplfreaks.user.UserLeagues;

public class UserRestServiceImpl implements IUserRestService {

	private IUserService userService;

	@Override
	public String createUser(String name, String emailId, String password) {

		RestServiceResponse response = null;
		try {
			this.userService.createUser(name, emailId, password);
			response = new RestServiceResponse(Status.SUCCESS.name(), null,
					null);
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			response = new RestServiceResponse(Status.ERROR.name(),
					"user already exists", null);
		} catch (Exception e) {
			e.printStackTrace();
			response = new RestServiceResponse(Status.ERROR.name(),
					"System is temporarily down, please try again later", null);
		}

		return new Gson().toJson(response);
	}

	@Override
	public String getUserLeagues(String userEmail) {
		RestServiceResponse response = null;
		try {
			final UserLeagues userLeagues = this.userService
					.getUserLeagues(userEmail);
			final Map<String, Object> result = new HashMap<String, Object>();
			result.put(Keys.USER_LEAGUES.name(), userLeagues);
			response = new RestServiceResponse(Status.SUCCESS.name(), null,
					result);
		} catch (Exception e) {
			e.printStackTrace();
			response = new RestServiceResponse(Status.ERROR.name(),
					"System is temporarily down, please try again later", null);
		}
		return new Gson().toJson(response);
	}

	/**
	 * @return the userService
	 */
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
