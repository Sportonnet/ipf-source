package com.iplfreaks.core;

import java.util.Set;

import com.iplfreaks.base.BaseEntity;
/**
 * 
 * @author dhananjayp
 *	 Can be Cricket
 *			Football
 *			Formula 1
 *
 *
 */
public class Game extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3691406255117869709L;
	
	private String name;
	
	private Set<Competition> competitions;

	public Set<Competition> getCompetitions() {
		return competitions;
	}

	public void setCompetitions(Set<Competition> competitions) {
		this.competitions = competitions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
