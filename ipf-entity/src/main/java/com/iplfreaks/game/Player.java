package com.iplfreaks.game;

import com.iplfreaks.base.BaseEntity;

public class Player extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4728610973357566604L;

	private String name;

	private Skill skill;

	// TODO associate stats of the player

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Skillable getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
