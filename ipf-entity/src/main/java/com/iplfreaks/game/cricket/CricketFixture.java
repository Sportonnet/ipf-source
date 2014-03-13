package com.iplfreaks.game.cricket;

import com.iplfreaks.base.BaseEntity;
import com.iplfreaks.game.Team;

/**
 * @author dhananjayp
 *
 */
public class CricketFixture extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3974141436395034648L;
	
	/**
	 * Simple name for this fixture
	 */
	private String fixtureName;

	public String getFixtureName() {
		return fixtureName;
	}

	public void setFixtureName(String fixtureName) {
		this.fixtureName = fixtureName;
	}

	private String bonusQuestion;
	
	private Team homeTeam;
	
	private Team awayTeam;

	public String getBonusQuestion() {
		return bonusQuestion;
	}

	public void setBonusQuestion(String bonusQuestion) {
		this.bonusQuestion = bonusQuestion;
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
}