/**
 * 
 */
package com.iplfreaks.game.cricket;

import java.util.HashSet;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import com.iplfreaks.core.Competition;

/**
 * @author jayeshm3
 *
 */

@Document
@TypeAlias(value="cricketCompetition")
@CompoundIndexes(value={
	    @CompoundIndex(name="name_sport_id", def="{'name':1, 'sport':1}", unique=true)
	})
public class CricketCompetition extends Competition {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2695222272998879032L;
	/**
	 * 
	 */
	private HashSet<CricketFixture> fixtures;
	/**
	 * @return the fixtures
	 */
	public HashSet<CricketFixture> getFixtures() {
		return fixtures;
	}
	/**
	 * @param fixtures the fixtures to set
	 */
	public void setFixtures(HashSet<CricketFixture> fixtures) {
		this.fixtures = fixtures;
	}

}
