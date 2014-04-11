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
	/**
	 * default constructor
	 */
	public Player() {

	}

	/**
	 * name of the player
	 * 
	 * @param name
	 */
	public Player(String name) {
		setName(name);
	}

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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
				if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
