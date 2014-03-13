package com.iplfreaks.services.impl;

import com.iplfreaks.services.api.IUserAuthenticationService;

public class UserAuthenticationServiceImpl implements
		IUserAuthenticationService {

	@Override
	public boolean isUserAuthorized(String userName, String password) {
		return true;
	}

}
