package com.iplfreaks.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.iplfreaks.common.Status;
import com.iplfreaks.core.Challenge;
import com.iplfreaks.core.Challenger;
import com.iplfreaks.core.Competition;
import com.iplfreaks.core.League;
import com.iplfreaks.dao.api.ILeagueDao;
import com.iplfreaks.dao.api.ILeagueScoreDetailsDao;
import com.iplfreaks.dao.api.IUserDao;
import com.iplfreaks.dao.api.IUserLeaguesDao;
import com.iplfreaks.dao.repository.CricketCompetitionRepository;
import com.iplfreaks.game.Fixture;
import com.iplfreaks.services.api.ICreateLeagueService;
import com.iplfreaks.user.User;

public class CreateLeagueServiceImpl implements ICreateLeagueService {

	private Logger logger = Logger.getLogger(CreateLeagueServiceImpl.class);
	private ILeagueDao leagueDao;
	private IUserDao userDao;
	private IUserLeaguesDao userLeagueDao;
	private ILeagueScoreDetailsDao leagueScoreDetailsDao;
	private CricketCompetitionRepository competitionRepository;

	@Override
	public void createLeague(String leagueName, String leagueOwner,
			String competitionName, String competitionSport) {

		this.logger.info("creating league " + leagueName + "for user"
				+ leagueOwner);

		// creating user who is the league owner
		final User user = new User();
		user.setEmail(leagueOwner);

		// creating competition
		final Competition competition = new Competition();
		competition.setName(competitionName);
		competition.setSport(competitionSport);

		// create the league object
		final League league = new League();
		league.setName(leagueName);
		league.setLeagueOwner(user);
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

		final List<Competition> competitions = this.competitionRepository
				.findByNameAndSport(competitionName, competitionSport);

		if (competitions != null && !competitions.isEmpty()) {

			Set<Fixture> fixtures = competitions.get(0).getFixtures();

			// get default challenges for the league
			Set<Challenge> challenges = getDefaultChallengesForLeague(fixtures);

			// creating score details for the league created
			this.leagueScoreDetailsDao.createNewLeagueScoreDetails(leagueName,
					challenges);
		}
		this.logger.info("successfully created league " + leagueName);

	}

	@Override
	public Map<String, Object> addChallengersToLeague(String leagueName,
			List<String> challengers) {
		this.logger.info("adding " + challengers + "to league " + leagueName);

		final League league = this.leagueDao.fetchLeague(leagueName);

		final Set<Challenger> leagueChallengers = new HashSet<Challenger>();
		final Set<Challenger> pendingChallengers = new HashSet<Challenger>();

		// filtering existing users and pending users from list of challengers
		for (final String challenger : challengers) {

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

		result.put(Status.SUCCESS.name(), leagueChallengers);
		result.put(Status.ERROR.name(), pendingChallengers);

		return result;
	}

	private Set<Challenge> getDefaultChallengesForLeague(Set<Fixture> fixtures) {
		Set<Challenge> challenges = new HashSet<Challenge>();

		for (Fixture fixture : fixtures) {
			Challenge challenge = new Challenge();
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

	/**
	 * @return the competitionRepository
	 */
	public CricketCompetitionRepository getCompetitionRepository() {
		return competitionRepository;
	}

	/**
	 * @param competitionRepository
	 *            the competitionRepository to set
	 */
	public void setCompetitionRepository(
			CricketCompetitionRepository competitionRepository) {
		this.competitionRepository = competitionRepository;
	}

}
