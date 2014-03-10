package com.iplfreaks.core;

import java.util.Set;

import com.iplfreaks.base.BaseEntity;

public class Competition extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1955722532579796264L;

	private String name;
	
	private Set<League> leagues;

	public Set<League> getLeagues() {
		return leagues;
	}

	public void setLeagues(Set<League> leagues) {
		this.leagues = leagues;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
