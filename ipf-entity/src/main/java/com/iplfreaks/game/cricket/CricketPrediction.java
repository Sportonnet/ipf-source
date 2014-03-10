package com.iplfreaks.game.cricket;

import com.iplfreaks.core.Prediction;
import com.iplfreaks.game.Player;
import com.iplfreaks.game.Team;

public class CricketPrediction extends Prediction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4265890238381673149L;

	private Player bestBowler;
	
	private Player bestBatsman;
	
	private Player manOfTheMatch;
	
	private Team winnerTeam;
	
	private String bonusAnswer;
	
	public Player getBestBowler() {
		return bestBowler;
	}

	public void setBestBowler(Player bestBowler) {
		this.bestBowler = bestBowler;
	}

	public Player getBestBatsman() {
		return bestBatsman;
	}

	public void setBestBatsman(Player bestBatsman) {
		this.bestBatsman = bestBatsman;
	}

	public Player getManOfTheMatch() {
		return manOfTheMatch;
	}

	public void setManOfTheMatch(Player manOfTheMatch) {
		this.manOfTheMatch = manOfTheMatch;
	}

	public Team getWinnerTeam() {
		return winnerTeam;
	}

	public void setWinnerTeam(Team winnerTeam) {
		this.winnerTeam = winnerTeam;
	}

	public String getBonusAnswer() {
		return bonusAnswer;
	}

	public void setBonusAnswer(String bonusAnswer) {
		this.bonusAnswer = bonusAnswer;
	}
}
