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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bonusAnswer == null) ? 0 : bonusAnswer.hashCode());
		result = prime * result
				+ ((bonusQuestion == null) ? 0 : bonusQuestion.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BonusEntity other = (BonusEntity) obj;
		if (bonusAnswer == null) {
			if (other.bonusAnswer != null)
				return false;
		} else if (!bonusAnswer.equals(other.bonusAnswer))
			return false;
		if (bonusQuestion == null) {
			if (other.bonusQuestion != null)
				return false;
		} else if (!bonusQuestion.equals(other.bonusQuestion))
			return false;
		return true;
	}
	
}
