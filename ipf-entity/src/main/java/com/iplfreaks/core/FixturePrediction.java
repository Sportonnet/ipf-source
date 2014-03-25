/**
 * 
 */
package com.iplfreaks.core;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jayeshm3
 *
 */
public class FixturePrediction {
	
	private String fixtureName;
	
	private final Set<Prediction> fixturePredictionList = new HashSet<Prediction>();

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
	public Set<Prediction> getFixturePredictionList() {
		return fixturePredictionList;
	}

	public void addFixturePrediction(final Prediction prediction)
	{
		getFixturePredictionList().add(prediction);
	}

}
