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
	
	private String sport;
	
	private Set<Fixture> fixtures;
	
	private String season;

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

	/**
	 * @return the sport
	 */
	public String getSport() {
		return sport;
	}

	/**
	 * @param sport the sport to set
	 */
	public void setSport(String sport) {
		this.sport = sport;
	}

	/**
	 * @return the season
	 */
	public String getSeason() {
		return season;
	}

	/**
	 * @param season the season to set
	 */
	public void setSeason(String season) {
		this.season = season;
	}
	
}
