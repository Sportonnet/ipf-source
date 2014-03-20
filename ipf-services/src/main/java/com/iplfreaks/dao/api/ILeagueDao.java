/**
 * 
 */
package com.iplfreaks.dao.api;

import com.iplfreaks.core.League;

/**
 * @author jayeshm3
 *
 */
public interface ILeagueDao {
	
	public League fetchLeague(final String leagueName);
	
	public void createLeague(final League league);
	
	public void addChallengersToLeague(final League league);

}
