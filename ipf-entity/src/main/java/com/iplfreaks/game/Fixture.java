package com.iplfreaks.game;

import org.joda.time.DateTime;

import com.iplfreaks.base.BaseEntity;
import com.iplfreaks.game.Team;

/**
 * 
 * @author Aniket
 * 
 */
public class Fixture extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3974141436395034648L;

	/**
	 * Simple name for this fixture
	 */
	private String fixtureName;

	private Team homeTeam;

	private Team awayTeam;

	private DateTime dateTime;

	public String getFixtureName() {
		return fixtureName;
	}

	public void setFixtureName(String fixtureName) {
		this.fixtureName = fixtureName;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

}