package com.iplfreaks.user;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author dhananjayp
 * 
 */
@Document
@TypeAlias(value = "user")
public class User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7316488563525276298L;

	/**
	 * 
	 */
	private String firstName;

	/**
	 * 
	 */
	private String lastName;

	/**
	 * 
	 */

	@Indexed(unique = true)
	private String email;

	private String password;

	/**
	 * default constructor
	 */
	public User() {
		super();
	}

	/**
	 * 
	 * @param emailId
	 *            email id of the user
	 */
	public User(String emailId) {
		setEmail(emailId);
	}

	/**
	 * 
	 * @param firstName
	 *            first name of user
	 * @param lastName
	 *            last name of user
	 * @param emailId
	 *            email id of the user
	 * @param password
	 *            password for the account
	 */
	public User(String firstName, String lastName, String emailId,
			String password) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(emailId);
		setPassword(password);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
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
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

}
