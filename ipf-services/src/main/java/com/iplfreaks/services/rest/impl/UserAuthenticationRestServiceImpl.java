package com.iplfreaks.services.rest.impl;

import com.iplfreaks.services.api.IUserAuthenticationService;
import com.iplfreaks.services.rest.api.IUserAuthenticationRestService;

public class UserAuthenticationRestServiceImpl implements
		IUserAuthenticationRestService {

	private IUserAuthenticationService userAuthenticationService;

	@Override
	public boolean isUserAuthorized(String userName, String password) {
		return this.userAuthenticationService.isUserAuthorized(userName,
				password);
	}

	public IUserAuthenticationService getUserAuthenticationService() {
		return userAuthenticationService;
	}

	public void setUserAuthenticationService(
			IUserAuthenticationService userAuthenticationService) {
		this.userAuthenticationService = userAuthenticationService;
	}

}
