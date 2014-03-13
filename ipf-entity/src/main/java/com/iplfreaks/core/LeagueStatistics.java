package com.iplfreaks.core;

import java.util.Set;

import com.iplfreaks.base.BaseEntity;

/**
 * @author dhananjayp
 *
 */
public class LeagueStatistics extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2564492627913252373L;
	
	private String leagueName;
	
	private Set<FixtureScore> fixtureScores;

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public Set<FixtureScore> getFixtureScores() {
		return fixtureScores;
	}

	public void setFixtureScores(Set<FixtureScore> fixtureScores) {
		this.fixtureScores = fixtureScores;
	}

}
