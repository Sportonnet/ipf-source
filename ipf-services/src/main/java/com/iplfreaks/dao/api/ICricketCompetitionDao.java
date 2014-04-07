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
	
	public CricketCompetition getTodaysFixtures(final String name, final String sport);
	
	public CricketCompetition getPastFixtures(final String name, final String sport);
	
	public CricketCompetition getFutureFixtures(final String name, final String sport);
	
	public CricketCompetition getFixtureBasedOnFixtureId(final String fixtureId);
	
	public CricketCompetition getFixtureBasedOnFixtureId(final String name, final String sport, final String fixtureId);

}
