package com.iplfreaks.core;

import org.joda.time.DateTime;

import com.iplfreaks.base.BaseEntity;

public class Prediction extends BaseEntity {

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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((challenger == null) ? 0 : challenger.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prediction other = (Prediction) obj;
		if (challenger == null) {
			if (other.challenger != null)
				return false;
		} else if (!challenger.equals(other.challenger))
			return false;
		return true;
	}	
	
	
}
