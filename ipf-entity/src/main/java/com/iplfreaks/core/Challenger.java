package com.iplfreaks.core;

import com.iplfreaks.user.User;

/**
 * @author dhananjayp
 * 
 *         These are users participating in the league
 * 
 */
public class Challenger {

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Challenger other = (Challenger) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;

		return true;
	}

}
