package com.iplfreaks.core;

import java.util.Set;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.iplfreaks.base.BaseEntity;
import com.iplfreaks.game.Fixture;

@Document
@TypeAlias(value="competition")
public class Competition extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1955722532579796264L;

	private String name;
	
	private String sport;
	
	private Set<Fixture> fixtures;
	
	private String season;
	
	private boolean isActive;

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

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
