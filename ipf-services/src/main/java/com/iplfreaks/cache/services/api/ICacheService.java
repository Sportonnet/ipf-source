/**
 * 
 */
package com.iplfreaks.cache.services.api;

import java.util.List;

import com.iplfreaks.game.Fixture;
import com.iplfreaks.game.Team;

/**
 * @author aniketd2
 * 
 */
public interface ICacheService {

	/**
	 * 
	 * @param competitionSport
	 *            name of the sport
	 * @param competitionName
	 *            name of the competition
	 * @return list of fixtures associated with the competition
	 */
	public List<Fixture> getFixtures(String competitionSport,
			String competitionName);

	/**
	 * 
	 * @param teamName
	 *            name of the team
	 * @return team entity with list of players
	 */
	public Team getTeam(String teamName);

	/**
	 * 
	 * @param key
	 *            key
	 * @param value
	 *            value
	 */
	public void put(String key, Object value);

}
