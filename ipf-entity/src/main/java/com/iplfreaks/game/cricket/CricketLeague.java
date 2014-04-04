/**
 * 
 */
package com.iplfreaks.game.cricket;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.iplfreaks.core.League;
import com.iplfreaks.user.User;

/**
 * @author jayeshm3
 *
 */
public class CricketLeague extends League {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1565400568891173758L;
	
	@DBRef
	private CricketCompetition competition;

	public CricketLeague(String name, User leagueOwner) {
		super(name, leagueOwner);
	}

	/**
	 * @return the competition
	 */
	public CricketCompetition getCompetition() {
		return competition;
	}

	/**
	 * @param competition the competition to set
	 */
	public void setCompetition(CricketCompetition competition) {
		this.competition = competition;
	}

}
