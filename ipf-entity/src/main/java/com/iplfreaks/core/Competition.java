package com.iplfreaks.core;

import java.util.Set;

import com.iplfreaks.base.BaseEntity;
import com.iplfreaks.game.Fixture;

public class Competition extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1955722532579796264L;

	private String name;
	
	private Set<Fixture> fixtures;

	public Set<Fixture> getFixtures() {
		return fixtures;
	}

	public void setFixtures(Set<Fixture> fixtures) {
		this.fixtures = fixtures;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
