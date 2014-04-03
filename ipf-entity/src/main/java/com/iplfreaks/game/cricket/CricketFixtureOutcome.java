/**
 * 
 */
package com.iplfreaks.game.cricket;

import java.util.List;

import com.iplfreaks.core.BonusEntity;
import com.iplfreaks.game.FixtureOutcome;
import com.iplfreaks.game.Player;

/**
 * @author jayeshm3
 *
 */
public class CricketFixtureOutcome extends FixtureOutcome {
	
	private Player bestBowler;
	
	private Player bestBatsman;
	
	private Player manOfTheMatch;
	
	private List<BonusEntity> bonus;

	public Player getBestBowler() {
		return bestBowler;
	}

	public void setBestBowler(Player bestBowler) {
		this.bestBowler = bestBowler;
	}

	public Player getBestBatsman() {
		return bestBatsman;
	}

	public void setBestBatsman(Player bestBatsman) {
		this.bestBatsman = bestBatsman;
	}

	public Player getManOfTheMatch() {
		return manOfTheMatch;
	}

	public void setManOfTheMatch(Player manOfTheMatch) {
		this.manOfTheMatch = manOfTheMatch;
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
