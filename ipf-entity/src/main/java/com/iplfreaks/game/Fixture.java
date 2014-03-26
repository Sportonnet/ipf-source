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
	
	private String venue;
	
	private FixtureOutcome outcome;

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

	/**
	 * @return the venue
	 */
	public String getVenue() {
		return venue;
	}

	/**
	 * @param venue the venue to set
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}

	/**
	 * @return the outcome
	 */
	public FixtureOutcome getOutcome() {
		return outcome;
	}

	/**
	 * @param outcome the outcome to set
	 */
	public void setOutcome(FixtureOutcome outcome) {
		this.outcome = outcome;
	}

}