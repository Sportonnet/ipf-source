/**
 * 
 */
package com.iplfreaks.dao.api;

import java.util.Set;

import com.iplfreaks.core.Challenger;
import com.iplfreaks.core.League;

/**
 * @author jayeshm3
 *
 */
public interface ILeagueDao {
	
	public League fetchLeague(final String leagueName);
	
	public void createLeague(final League league);
	
	public void addChallengersToLeague(final String leagueName, final Set<Challenger> challengers);
	
	public void addPendingChallengersToLeague(final String leagueName, final Set<Challenger> challengers);

}
