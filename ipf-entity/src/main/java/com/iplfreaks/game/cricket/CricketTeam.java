package com.iplfreaks.game.cricket;

import java.util.HashSet;
import java.util.Set;

import com.iplfreaks.game.Player;
import com.iplfreaks.game.Skill;
import com.iplfreaks.game.Team;


public class CricketTeam extends Team {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7989158598206276871L;

	/**
	 * @return
	 */
	public Set<Player> getBowlers(){
		Set<Player> bowlers = new HashSet<Player>();
		if(this.getPlayers() != null && !this.getPlayers().isEmpty()){
			for (Player player : bowlers) {
				if(player.getSkill() == Skill.BOWLER)
					bowlers.add(player);
			}
		}
		return bowlers;
	}
	
	/**
	 * @return
	 */
	public Set<Player> getBatsmen(){
		Set<Player> batsmen = new HashSet<Player>();
		if(this.getPlayers() != null && !this.getPlayers().isEmpty()){
			for (Player player : batsmen) {
				if(player.getSkill() == Skill.BATSMAN)
					batsmen.add(player);
			}
		}
		return batsmen;
	}
	
	/**
	 * @return
	 */
	public Set<Player> getAllrounders(){
		Set<Player> allrounders = new HashSet<Player>();
		if(this.getPlayers() != null && !this.getPlayers().isEmpty()){
			for (Player player : allrounders) {
				if(player.getSkill() == Skill.ALLROUNDER)
					allrounders.add(player);
			}
		}
		return allrounders;
	}
	
}
