package com.iplfreaks.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.FormParam;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.iplfreaks.common.Keys;
import com.iplfreaks.core.Challenger;
import com.iplfreaks.core.League;
import com.iplfreaks.dao.api.ICricketCompetitionDao;
import com.iplfreaks.dao.api.ICricketLeagueScoreDao;
import com.iplfreaks.dao.api.ILeagueDao;
import com.iplfreaks.dao.api.IUserDao;
import com.iplfreaks.dao.api.IUserLeaguesDao;
import com.iplfreaks.game.Fixture;
import com.iplfreaks.game.cricket.CricketChallenge;
import com.iplfreaks.game.cricket.CricketCompetition;
import com.iplfreaks.game.cricket.CricketFixture;
import com.iplfreaks.game.cricket.CricketLeague;
import com.iplfreaks.services.api.ICreateLeagueService;
import com.iplfreaks.user.User;

public class CreateCricketLeagueServiceImpl implements ICreateLeagueService {

	private Logger logger = Logger
			.getLogger(CreateCricketLeagueServiceImpl.class);
	private ILeagueDao leagueDao;
	private IUserDao userDao;
	private IUserLeaguesDao userLeagueDao;
	private ICricketLeagueScoreDao cricketLeagueScoreDao;
	private ICricketCompetitionDao cricketCompetitionDao;

	@Override
	public void createLeague(String leagueName, String leagueOwner,
			String competitionName, String competitionSport) {

		this.logger.info("creating league " + leagueName + "for user"
				+ leagueOwner);

		// creating user who is the league owner
		final User user = new User();
		user.setEmail(leagueOwner);

		// creating competition
		final CricketCompetition competition = this.cricketCompetitionDao
				.getCompetitionFixtures(competitionName, competitionSport);

		// create the league object
		final CricketLeague league = new CricketLeague(leagueName, user);
		league.setLeagueStartDate(new DateTime());
		league.setCompetition(competition);

		// create the league
		this.leagueDao.createLeague(league);

		// add mapping in user-mapping
		this.userLeagueDao.addUserLeague(leagueOwner, leagueName);

		// adding league owner to the list of challengers
		final List<String> challengers = new ArrayList<String>();
		challengers.add(leagueOwner);
		addChallengersToLeague(leagueName, challengers);

		if (competition != null) {

			final Set<CricketFixture> fixtures = competition.getFixtures();

			// get default challenges for the league
			Set<CricketChallenge> challenges = getDefaultChallengesForLeague(fixtures);

			// creating score details for the league created
			this.cricketLeagueScoreDao.createNewCricketLeagueScore(leagueName,
					challenges);
		}
		this.logger.info("successfully created league " + leagueName);

	}

	@Override
	public Map<String, Object> addChallengersToLeague(
			@FormParam("leagueName") String leagueName,
			@FormParam("challengers") List<String> challengers) {
		this.logger.info("adding " + challengers + "to league " + leagueName);

		final League league = this.leagueDao.fetchLeague(leagueName);

		final Set<Challenger> leagueChallengers = new HashSet<Challenger>();
		final Set<Challenger> pendingChallengers = new HashSet<Challenger>();

		// filtering existing users and pending users from list of challengers
		for (final String challenger : challengers) {

			if (challenger != null && challenger.trim() != null
					&& !challenger.trim().isEmpty()) {

				final Challenger challenger2 = new Challenger();
				final User user = new User();
				user.setEmail(challenger);
				challenger2.setUser(user);

				if (this.userDao.isUserPresent(challenger)) {
					leagueChallengers.add(challenger2);
				} else {
					pendingChallengers.add(challenger2);
				}
			}
		}

		league.addChallengers(new ArrayList<Challenger>(leagueChallengers));
		league.addPendingChallengers(new ArrayList<Challenger>(
				pendingChallengers));

		// adding challengers to the league
		this.leagueDao.addChallengersToLeague(leagueName, leagueChallengers);
		this.leagueDao.addPendingChallengersToLeague(leagueName,
				pendingChallengers);

		this.logger.info("successfully added " + leagueChallengers.size()
				+ " challengers out of " + challengers.size());

		this.logger.info("adding league challengers to user-league mapping");

		// adding league challengers to user-league mapping
		for (final Challenger leagueChalleger : leagueChallengers) {
			this.userLeagueDao.addUserLeague(leagueChalleger.getUser()
					.getEmail(), leagueName);
		}
		for (final Challenger pendingChalleger : pendingChallengers) {
			this.userLeagueDao.addUserLeague(pendingChalleger.getUser()
					.getEmail(), leagueName);
		}

		this.logger
				.info("successfully added league challengers to user-league mapping");

		// result
		Map<String, Object> result = new HashMap<String, Object>();

		result.put(Keys.CHALLENGERS.name(), leagueChallengers);
		result.put(Keys.PENDING_CHALLENGERS.name(), pendingChallengers);

		return result;
	}

	private Set<CricketChallenge> getDefaultChallengesForLeague(
			Set<CricketFixture> fixtures) {
		Set<CricketChallenge> challenges = new HashSet<CricketChallenge>();

		for (final Fixture fixture : fixtures) {
			final CricketChallenge challenge = new CricketChallenge();
			challenge.setFixtureId(fixture.getFixtureId());
			challenges.add(challenge);
		}

		return challenges;
	}

	/**
	 * @return the leagueDao
	 */
	public ILeagueDao getLeagueDao() {
		return leagueDao;
	}

	/**
	 * @param leagueDao
	 *            the leagueDao to set
	 */
	public void setLeagueDao(ILeagueDao leagueDao) {
		this.leagueDao = leagueDao;
	}

	/**
	 * @return the userDao
	 */
	public IUserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao
	 *            the userDao to set
	 */
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @return the userLeagueDao
	 */
	public IUserLeaguesDao getUserLeagueDao() {
		return userLeagueDao;
	}

	/**
	 * @param userLeagueDao
	 *            the userLeagueDao to set
	 */
	public void setUserLeagueDao(IUserLeaguesDao userLeagueDao) {
		this.userLeagueDao = userLeagueDao;
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
	 * @return the cricketCompetitionDao
	 */
	public ICricketCompetitionDao getCricketCompetitionDao() {
		return cricketCompetitionDao;
	}

	/**
	 * @param cricketCompetitionDao
	 *            the cricketCompetitionDao to set
	 */
	public void setCricketCompetitionDao(
			ICricketCompetitionDao cricketCompetitionDao) {
		this.cricketCompetitionDao = cricketCompetitionDao;
	}

}
