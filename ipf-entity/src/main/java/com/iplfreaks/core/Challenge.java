package com.iplfreaks.core;

import java.util.HashSet;
import java.util.Set;

import com.iplfreaks.base.BaseEntity;

public class Challenge extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3974141436395034648L;
	
	//Unique identifier for the fixture
	private String fixtureId;
	
	private Set<Prediction> predictions = new HashSet<Prediction>();
	
	public String getFixtureId() {
		return fixtureId;
	}

	public void setFixtureId(String fixtureId) {
		this.fixtureId = fixtureId;
	}

	public Set<Prediction> getPredictions() {
		return predictions;
	}

	public void setPredictions(Set<Prediction> predictions) {
		this.predictions = predictions;
	}

	public Prediction getResult() {
		return result;
	}

	public void setResult(Prediction result) {
		this.result = result;
	}

	private Prediction result;

}
