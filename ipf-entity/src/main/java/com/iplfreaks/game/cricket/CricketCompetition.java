/**
 * 
 */
package com.iplfreaks.game.cricket;

import java.util.Set;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.iplfreaks.core.Competition;

/**
 * @author jayeshm3
 *
 */

@Document
@TypeAlias(value="cricketCompetition")
public class CricketCompetition extends Competition {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2695222272998879032L;
	/**
	 * 
	 */
	private Set<CricketFixture> fixtures;
	/**
	 * @return the fixtures
	 */
	public Set<CricketFixture> getFixtures() {
		return fixtures;
	}
	/**
	 * @param fixtures the fixtures to set
	 */
	public void setFixtures(Set<CricketFixture> fixtures) {
		this.fixtures = fixtures;
	}

}
