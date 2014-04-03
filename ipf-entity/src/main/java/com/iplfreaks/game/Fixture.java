package com.iplfreaks.game;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.index.Indexed;

import com.iplfreaks.base.BaseEntity;

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
	
	@Indexed(unique=true, sparse=true)
	private String fixtureId;
	
	private String fixtureName;

	private Team homeTeam;

	private Team awayTeam;

	private DateTime dateTime;
	
	private String venue;
	
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
	 * @return the fixtureId
	 */
	public String getFixtureId() {
		
		if(fixtureId != null)
		{
			return fixtureId;
		}
		return getFixtureName() + " @ " + getDateTime(); 
	}

	/**
	 * @param fixtureId the fixtureId to set
	 */
	public void setFixtureId(String fixtureId) {
		this.fixtureId = fixtureId;
	}

}