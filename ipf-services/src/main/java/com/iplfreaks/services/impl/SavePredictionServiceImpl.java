/**
 * 
 */
package com.iplfreaks.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.iplfreaks.core.BonusEntity;
import com.iplfreaks.core.Challenger;
import com.iplfreaks.dao.api.ICricketLeagueScoreDao;
import com.iplfreaks.game.Player;
import com.iplfreaks.game.Team;
import com.iplfreaks.game.cricket.CricketPrediction;
import com.iplfreaks.services.api.ISavePredictionService;
import com.iplfreaks.user.User;

/**
 * @author Aniket
 * 
 */
public class SavePredictionServiceImpl implements ISavePredictionService {

	private Logger logger = Logger.getLogger(SavePredictionServiceImpl.class);
	private ICricketLeagueScoreDao cricketLeagueScoreDao;

	@Override
	public void saveCricketPrediction(String leagueName, String fixtureId,
			String challengerEmailId, String bestBowlerName,
			String bestBatsmanName, String manOfTheMatchName,
			String winnerTeam, List<String> bonus) {

		this.logger.info("saving prediction for fixture : " + fixtureId
				+ " by user : " + challengerEmailId);
		// creating prediction to add
		final CricketPrediction prediction = new CricketPrediction();

		// challenger for whom prediction belongs to
		final Challenger challenger = new Challenger(
				new User(challengerEmailId));

		prediction.setChallenger(challenger);

		// prediction of the challenger
		final Player bestBowler = new Player(bestBowlerName);
		final Player bestBatsman = new Player(bestBatsmanName);
		final Player manOfTheMatch = new Player(manOfTheMatchName);

		final List<BonusEntity> bonusList = new ArrayList<BonusEntity>();

		for (final String bonusQA : bonus) {
			final BonusEntity bonusEntity = new BonusEntity();
			String bonusQ = bonusQA.substring(0, bonusQA.lastIndexOf("|"))
					.trim();
			String bonusA = bonusQA.substring(bonusQA.lastIndexOf("|") + 1)
					.trim();
			bonusEntity.setBonusQuestion(bonusQ);
			bonusEntity.setBonusAnswer(bonusA);
			bonusList.add(bonusEntity);
		}

		final Team winner = new Team();
		winner.setName(winnerTeam);

		prediction.setBestBatsman(bestBatsman);
		prediction.setBestBowler(bestBowler);
		prediction.setManOfTheMatch(manOfTheMatch);
		prediction.setBonus(bonusList);
		prediction.setWinnerTeam(winner);

		prediction.setTime(new DateTime());

		// adding prediction of the challenger
		this.cricketLeagueScoreDao.addChallengerPrediction(leagueName,
				fixtureId, prediction);

		this.logger.info("succesfullly saved prediction for fixture : "
				+ fixtureId + " by user : " + challengerEmailId);
	}

	@Override
	public boolean canSavePrediction(String fixtureId) {

		final DateTime fixtureDateTime = new DateTime(fixtureId.substring(
				fixtureId.lastIndexOf("@") + 1).trim());

		if (fixtureDateTime.minusMinutes(30).isAfterNow()) {
			return true;
		}

		return false;
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

}
