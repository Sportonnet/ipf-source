package com.iplfreaks.services.api;

import java.util.Date;

public interface ISavePredictionService {

	/**
	 * 
	 * @param leagueName
	 *            name of the league for which challenger is predicting
	 * @param fixtureId
	 *            name of the fixture against the prediction by challenger
	 * @param challengerEmailId
	 *            email id of the challenger
	 * @param bestBowler
	 *            name of the best bowler
	 * @param bestBatsman
	 *            name of the best batsman
	 * @param manOfTheMatch
	 *            name of the man of the match
	 * @param winnerTeam
	 *            name of the winning team
	 * @param bonusAnswer
	 *            answer to the bonus question
	 */
	public void saveCricketPrediction(String leagueName, String fixtureId,
			String challengerEmailId, String bestBowler, String bestBatsman,
			String manOfTheMatch, String winnerTeam, String bonusAnswer);

	/**
	 * 
	 * @param fixtureId
	 *            fixture id
	 * @param currenDateTime
	 *            current time
	 * @return true if fixture datetime is after current datetime else false
	 */
	public boolean canSavePrediction(String fixtureId, Date currentDateTime);
}
