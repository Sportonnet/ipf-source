package com.iplfreaks.game.cricket;

import java.util.List;

import com.iplfreaks.core.BonusEntity;
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
	
	private CricketFixtureOutcome outcome;
	
	private List<BonusEntity> bonus;

	/**
	 * @return the outcome
	 */
	public CricketFixtureOutcome getOutcome() {
		return outcome;
	}



	/**
	 * @param outcome the outcome to set
	 */
	public void setOutcome(CricketFixtureOutcome outcome) {
		this.outcome = outcome;
	}

	/**
	 * @return the bonus
	 */
	public List<BonusEntity> getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(List<BonusEntity> bonus) {
		this.bonus = bonus;
	}
	
}