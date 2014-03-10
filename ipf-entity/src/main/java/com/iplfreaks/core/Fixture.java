package com.iplfreaks.core;

import java.util.Set;

import com.iplfreaks.base.BaseEntity;
import com.iplfreaks.game.Team;

/**
 * @author dhananjayp
 *
 */
public class Fixture extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3974141436395034648L;

	private String bonusQuestion;
	
	private Team homeTeam;
	
	private Team awayTeam;
	
	private Set<Prediction> predictions;
	
	private Prediction result;

	public String getBonusQuestion() {
		return bonusQuestion;
	}

	public void setBonusQuestion(String bonusQuestion) {
		this.bonusQuestion = bonusQuestion;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
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
	
}
