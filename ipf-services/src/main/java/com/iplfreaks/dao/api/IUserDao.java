package com.iplfreaks.dao.api;

import com.iplfreaks.user.User;

public interface IUserDao {
	
	public boolean authenticateUser(final User user);
	
	public boolean createUser(final User user);
	
	public boolean isUserPresent(final String email);
	
	public User fetchUser(final String email);

}
