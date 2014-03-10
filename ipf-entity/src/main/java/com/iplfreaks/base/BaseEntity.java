package com.iplfreaks.base;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.joda.time.DateTime;

/**
 * @author dhananjayp
 *
 */
public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1567917756300201879L;

	private String id;
	
	private DateTime createdDate;
	
	private DateTime updatedDate;
	
	private String createdBy;
	
	private String updatedBy;

	public BaseEntity() {
		this.id = UUID.randomUUID().toString();
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == this)
			return true;
		if(this.getClass() == other.getClass()){
			BaseEntity otherBase = (BaseEntity)other;
			return new EqualsBuilder().append(this.getId(), otherBase.getId()).isEquals();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId()).hashCode();
	}
	
	
	public String getId() {
		return id;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}
