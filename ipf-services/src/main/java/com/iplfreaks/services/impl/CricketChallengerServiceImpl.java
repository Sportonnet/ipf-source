package com.iplfreaks.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;

import com.iplfreaks.common.Keys;
import com.iplfreaks.dao.api.ICricketLeagueScoreDao;
import com.iplfreaks.dao.impl.CricketLeagueDaoImpl;
import com.iplfreaks.game.cricket.CricketChallenge;
import com.iplfreaks.game.cricket.CricketLeagueScore;
import com.iplfreaks.game.cricket.CricketPrediction;
import com.iplfreaks.services.api.IChallengerService;

public class CricketChallengerServiceImpl implements IChallengerService {

	private CricketLeagueDaoImpl cricketLeagueDao;
	private ICricketLeagueScoreDao cricketLeagueScoreDao;

	@Override
	public Map<String, Object> getFixtureChallenges(final String leagueName,
			final String fixtureId) {
		/**
		 * 1. Fetch league score details based on the league name
		 * 
		 * 2. Get Challenge list from the league score details for all the
		 * fixtures
		 * 
		 * 3. Iterate over the Challenges and based on the fixture id get the
		 * prediction list
		 * 
		 * 4. Iterate over the Predictions to map it to the Challenger and add
		 * the response
		 * 
		 */

		final Map<String, Object> result = new HashMap<String, Object>();

		final CricketLeagueScore leagueScore = this.cricketLeagueScoreDao
				.fetchCricketLeagueScore(leagueName);
		Set<CricketChallenge> challenges = new HashSet<CricketChallenge>();

		if (leagueScore != null) {
			challenges = leagueScore.getFixturePredictionList();
		}

		Set<CricketPrediction> predictions = new HashSet<CricketPrediction>();

		for (final CricketChallenge challenge : challenges) {
			if (fixtureId.equalsIgnoreCase(challenge.getFixtureId())) {
				predictions = challenge.getPredictions();
				break;
			}
		}
		final List<Map<String, Object>> userPredictions = new ArrayList<Map<String, Object>>();

		for (final CricketPrediction prediction : predictions) {
			final Map<String, Object> userPrediction = new HashMap<String, Object>();
			userPrediction.put(Keys.CHALLENGER.name(), prediction
					.getChallenger().getUser().getEmail());
			userPrediction.put(Keys.PREDICTION.name(), prediction);
			userPredictions.add(userPrediction);

		}

		result.put(Keys.FIXTURE_CHALLENGES.name(), userPredictions);

		/**
		 * 
		 */
		final DateTime fixtureDate = new DateTime(fixtureId.substring(
				fixtureId.lastIndexOf("@")).trim());

		if (fixtureDate.minusMinutes(30).isBeforeNow()) {
			result.put(Keys.CAN_EDIT_CHALLENGE.name(), true);
		} else {
			result.put(Keys.CAN_EDIT_CHALLENGE.name(), false);
		}

		return result;
	}

	/**
	 * @return the cricketLeagueScoreDao
	 */
	public ICricketLeagueScoreDao getCricketLeagueScoreDao() {
		return cricketLeagueScoreDao;
	}

	/**
	 * @param cricketLeagueScoreDao
	 *            the cricketLeagueScoreDao to set
	 */
	public void setCricketLeagueScoreDao(
			ICricketLeagueScoreDao cricketLeagueScoreDao) {
		this.cricketLeagueScoreDao = cricketLeagueScoreDao;
	}

	/**
	 * @return the cricketLeagueDao
	 */
	public CricketLeagueDaoImpl getCricketLeagueDao() {
		return cricketLeagueDao;
	}

	/**
	 * @param cricketLeagueDao
	 *            the cricketLeagueDao to set
	 */
	public void setCricketLeagueDao(CricketLeagueDaoImpl cricketLeagueDao) {
		this.cricketLeagueDao = cricketLeagueDao;
	}

}
