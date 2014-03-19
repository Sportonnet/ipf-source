package com.iplfreaks.user;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.iplfreaks.base.BaseEntity;

/**
 * @author dhananjayp
 *
 */
@Document
@TypeAlias(value="User")
public class User extends BaseEntity {

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
	
	@Indexed(unique=true)
	private String email;
	
	private String password;

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
		this.email = email;
	}
	
}
