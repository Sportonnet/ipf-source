package com.iplfreaks.services.rest.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.iplfreaks.services.api.IHelloService;
import com.iplfreaks.services.rest.api.IHelloServiceRest;
import com.iplfreaks.user.User;

/**
 * @author dhananjayp
 * 
 */
public class HelloServiceRestImpl implements IHelloServiceRest {

	private IHelloService helloService;

	public IHelloService getHelloService() {
		return helloService;
	}

	public void setHelloService(IHelloService helloService) {
		this.helloService = helloService;
	}

	public String handleGet(String name) {
		final User user = new User();
		user.setFirstName("Aniket");
		user.setEmail("aniket.divekar@gmail.com");
		user.setLastName("Divekar");

		final User user1 = new User();
		user1.setFirstName("Dhananjay");
		user1.setEmail("dhananjay.patkar@citiustech.com");
		user1.setLastName("Patkar");

		final List<User> users = new ArrayList<User>();
		users.add(user);
		users.add(user1);

		return new Gson().toJson(users);
	}

}
