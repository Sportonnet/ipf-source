package com.iplfreaks.user;

import java.util.Set;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.iplfreaks.base.BaseEntity;

/**
 * Object for storing and querying user and user-league association.
 * 
 * @author dhananjayp
 *
 */
@Document
@TypeAlias(value="UserLeagues")
public class UserLeagues extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6191890843194844548L;
	
	@Indexed(unique=true, sparse=true)
	private String email;
	
	private Set<String> leagues;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getLeagues() {
		return leagues;
	}

	public void setLeagues(Set<String> leagues) {
		this.leagues = leagues;
	}

}
