/**
 * 
 */
package com.iplfreaks.dao.api;

import java.util.List;

import com.iplfreaks.game.cricket.CricketCompetition;

/**
 * @author jayeshm3
 *
 */
public interface ICricketCompetitionDao {
	
	public CricketCompetition getCompetitionFixtures(final String name, final String sport);
	
	public List<CricketCompetition> getActiveCompetitions();

}
