package com.iplfreaks.game;

import java.util.Set;

import com.iplfreaks.base.BaseEntity;

/**
 * @author dhananjayp
 * 
 */
public class Team extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1877266600126247841L;

	private String name;

	private String homeCity;

	private String country;

	private Set<Player> players;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

}
