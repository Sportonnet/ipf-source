package com.iplfreaks.core;

import java.util.Set;

import com.iplfreaks.base.BaseEntity;

public class FixtureScore extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1766007232021951053L;

	private String fixtureId;
	
	private Set<ChallengerScore> challengerScores;

	public String getFixtureId() {
		return fixtureId;
	}

	public void setFixtureId(String fixtureId) {
		this.fixtureId = fixtureId;
	}

	public Set<ChallengerScore> getChallengerScores() {
		return challengerScores;
	}

	public void setChallengerScores(Set<ChallengerScore> challengerScores) {
		this.challengerScores = challengerScores;
	}
	
	
}
