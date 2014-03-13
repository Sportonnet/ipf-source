package com.iplfreaks.core;

import com.iplfreaks.base.BaseEntity;

public class ChallengerScore extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2530485144614570513L;

	private String challengerName;
	
	private int score;

	public String getChallengerName() {
		return challengerName;
	}

	public void setChallengerName(String challengerName) {
		this.challengerName = challengerName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
