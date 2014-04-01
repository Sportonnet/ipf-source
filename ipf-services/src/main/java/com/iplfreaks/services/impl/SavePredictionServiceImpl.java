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
import com.iplfreaks.dao.api.ILeagueScoreDetailsDao;
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
	private ILeagueScoreDetailsDao leagueScoreDetailsDao;

	@Override
	public void saveCricketPrediction(String leagueName, String fixtureId,
			String challengerEmailId, String bestBowlerName,
			String bestBatsmanName, String manOfTheMatchName,
			String winnerTeam, String bonusAnswer) {

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

		final List<BonusEntity> bonusAnswers = new ArrayList<BonusEntity>();
		final BonusEntity bonus = new BonusEntity();
		bonus.setBonusAnswer(bonusAnswer);
		bonusAnswers.add(bonus);

		final Team winner = new Team();
		winner.setName(winnerTeam);

		prediction.setBestBatsman(bestBatsman);
		prediction.setBestBowler(bestBowler);
		prediction.setManOfTheMatch(manOfTheMatch);
		prediction.setBonus(bonusAnswers);
		prediction.setWinnerTeam(winner);

		prediction.setTime(new DateTime());

		// adding prediction of the challenger
		this.leagueScoreDetailsDao.addChallengerPrediction(leagueName,
				fixtureId, prediction);
		this.logger.info("succesfullly saved prediction for fixture : "
				+ fixtureId + " by user : " + challengerEmailId);
	}

	/**
	 * @return the leagueScoreDetailsDao
	 */
	public ILeagueScoreDetailsDao getLeagueScoreDetailsDao() {
		return leagueScoreDetailsDao;
	}

	/**
	 * @param leagueScoreDetailsDao
	 *            the leagueScoreDetailsDao to set
	 */
	public void setLeagueScoreDetailsDao(
			ILeagueScoreDetailsDao leagueScoreDetailsDao) {
		this.leagueScoreDetailsDao = leagueScoreDetailsDao;
	}

}
