package com.iplfreaks.core;

import org.joda.time.DateTime;

import com.iplfreaks.base.BaseEntity;

public abstract class Prediction extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7014636475065416837L;

	private Challenger challenger;
	
	private DateTime time;
	
	public DateTime getTime() {
		return time;
	}

	public void setTime(DateTime time) {
		this.time = time;
	}

	public Challenger getChallenger() {
		return challenger;
	}

	public void setChallenger(Challenger challenger) {
		this.challenger = challenger;
	}	
	
}
