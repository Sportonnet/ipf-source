/**
 * 
 */
package com.iplfreaks.core;

import java.util.List;

/**
 * @author jayeshm3
 *
 */
public class LeagueScoreDetails {
	
	private String leagueName;
	
	private List<FixturePrediction> fixturePredictionList;
	
	public void addFixturePrediction(final FixturePrediction fixturePrediction)
	{
		getFixturePredictionList().add(fixturePrediction);
	}

	/**
	 * @return the leagueName
	 */
	public String getLeagueName() {
		return leagueName;
	}

	/**
	 * @param leagueName the leagueName to set
	 */
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	/**
	 * @return the fixturePredictionList
	 */
	public List<FixturePrediction> getFixturePredictionList() {
		return fixturePredictionList;
	}

	/**
	 * @param fixturePredictionList the fixturePredictionList to set
	 */
	public void setFixturePredictionList(List<FixturePrediction> fixturePredictionList) {
		this.fixturePredictionList = fixturePredictionList;
	}

}
