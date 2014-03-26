package com.iplfreaks.game.cricket;

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
	


	private BonusEntity bonus;



	/**
	 * @return the bonus
	 */
	public BonusEntity getBonus() {
		return bonus;
	}



	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(BonusEntity bonus) {
		this.bonus = bonus;
	}
	
}