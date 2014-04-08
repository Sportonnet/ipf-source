package com.iplfreaks.core;

import java.util.HashSet;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.iplfreaks.base.BaseEntity;

/**
 * @author dhananjayp
 *
 */
@Document
@TypeAlias(value="leagueStats")
public class LeagueStatistics extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2564492627913252373L;
	
	private String leagueName;
	
	private HashSet<FixtureScore> fixtureScores = new HashSet<FixtureScore>();

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public HashSet<FixtureScore> getFixtureScores() {
		return fixtureScores;
	}

	public void setFixtureScores(HashSet<FixtureScore> fixtureScores) {
		this.fixtureScores = fixtureScores;
	}

}
