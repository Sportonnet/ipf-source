package com.iplfreaks.core;

import com.iplfreaks.base.BaseEntity;
import com.iplfreaks.user.User;

/**
 * @author dhananjayp
 * 
 *         These are users participating in the league
 * 
 */
public class Challenger extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3508717215658014043L;

	private String name;

	private User user;

	/**
	 * default constructor
	 */
	public Challenger() {

	}

	public Challenger(User user) {
		setUser(user);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
