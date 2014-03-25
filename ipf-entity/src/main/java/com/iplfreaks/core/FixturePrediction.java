/**
 * 
 */
package com.iplfreaks.core;

import java.util.List;

/**
 * @author jayeshm3
 *
 */
public class FixturePrediction {
	
	private String fixtureName;
	
	private List<Prediction> fixturePredictionList;

	/**
	 * @return the fixtureName
	 */
	public String getFixtureName() {
		return fixtureName;
	}

	/**
	 * @param fixtureName the fixtureName to set
	 */
	public void setFixtureName(String fixtureName) {
		this.fixtureName = fixtureName;
	}

	/**
	 * @return the fixturePredictionList
	 */
	public List<Prediction> getFixturePredictionList() {
		return fixturePredictionList;
	}

	/**
	 * @param fixturePredictionList the fixturePredictionList to set
	 */
	public void setFixturePredictionList(List<Prediction> fixturePredictionList) {
		this.fixturePredictionList = fixturePredictionList;
	}
	
	public void addFixturePrediction(final Prediction prediction)
	{
		getFixturePredictionList().add(prediction);
	}

}
