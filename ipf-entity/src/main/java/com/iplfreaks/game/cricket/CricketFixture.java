package com.iplfreaks.game.cricket;

import com.iplfreaks.game.Fixture;

/**
 * @author dhananjayp
 *
 */
public class CricketFixture extends Fixture {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3974141436395034648L;
	


	private String bonusQuestion;
	

	public String getBonusQuestion() {
		return bonusQuestion;
	}

	public void setBonusQuestion(String bonusQuestion) {
		this.bonusQuestion = bonusQuestion;
	}

}