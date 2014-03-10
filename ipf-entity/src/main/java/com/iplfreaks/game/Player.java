package com.iplfreaks.game;

import com.iplfreaks.base.BaseEntity;

public abstract class Player extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4728610973357566604L;
	
	

	private String name;
	
	private Skillable skill;

	//TODO associate stats of the player
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Skillable getSkill() {
		return skill;
	}

	public void setSkill(Skillable skill) {
		this.skill = skill;
	}
	
	
	
}
