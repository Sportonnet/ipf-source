/**
 * 
 */
package com.iplfreaks.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jayeshm3
 *
 */
public class BonusEntity {
	
	private String bonusQuestion;
	
	private String bonusAnswer;
	
	private List<String> options = new ArrayList<String>();

	/**
	 * @return the bonusQuestion
	 */
	public String getBonusQuestion() {
		return bonusQuestion;
	}

	/**
	 * @param bonusQuestion the bonusQuestion to set
	 */
	public void setBonusQuestion(String bonusQuestion) {
		this.bonusQuestion = bonusQuestion;
	}

	/**
	 * @return the bonusAnswer
	 */
	public String getBonusAnswer() {
		return bonusAnswer;
	}

	/**
	 * @param bonusAnswer the bonusAnswer to set
	 */
	public void setBonusAnswer(String bonusAnswer) {
		this.bonusAnswer = bonusAnswer;
	}

	/**
	 * @return the options
	 */
	public List<String> getBonusOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setBonusOptions(List<String> bonusOptions) {
		this.options = bonusOptions;
	}

}
