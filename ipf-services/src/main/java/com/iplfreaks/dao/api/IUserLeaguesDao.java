/**
 * 
 */
package com.iplfreaks.dao.api;

import java.util.List;

import com.iplfreaks.user.UserLeagues;


/**
 * @author jayeshm3
 *
 */
public interface IUserLeaguesDao {
	
	public void addUserLeague(final String email, final String leagueName);
	
	public UserLeagues fetchUserLeagues(final String email);

}
