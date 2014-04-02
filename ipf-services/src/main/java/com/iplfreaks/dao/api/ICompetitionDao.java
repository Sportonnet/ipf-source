/**
 * 
 */
package com.iplfreaks.dao.api;

import java.util.List;

import com.iplfreaks.core.Competition;

/**
 * @author jayeshm3
 *
 */
public interface ICompetitionDao {
	
	public Competition getCompetitionFixtures(final String name, final String sport);
	
	public List<Competition> getActiveCompetitions();

}
