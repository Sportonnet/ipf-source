package com.iplfreaks.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.iplfreaks.common.Status;
import com.iplfreaks.core.Challenger;
import com.iplfreaks.core.Competition;
import com.iplfreaks.core.League;
import com.iplfreaks.dao.api.ILeagueDao;
import com.iplfreaks.dao.api.IUserDao;
import com.iplfreaks.dao.api.IUserLeaguesDao;
import com.iplfreaks.services.api.ICreateLeagueService;
import com.iplfreaks.user.User;

public class CreateLeagueServiceImpl implements ICreateLeagueService {

	private ILeagueDao leagueDao;
	private IUserDao userDao;
	private IUserLeaguesDao userLeagueDao;

	@Override
	public void createLeague(String leagueName, String leagueOwner,
			String competitionName, String competitionSport) {

		// creating user who is the league owner
		final User user = new User();
		user.setEmail(leagueOwner);

		// creating competition
		final Competition competition = new Competition();
		competition.setName(competitionName);
		competition.setSport(competitionSport);

		// create the league
		final League league = new League();
		league.setName(leagueName);
		league.setLeagueOwner(user);
		league.setLeagueStartDate(new DateTime());
		league.setCompetition(competition);

		// save the league
		this.leagueDao.createLeague(league);

	}

	@Override
	public Map<String, Object> addChallengersToLeague(String leagueName,
			List<String> challengers) {

		final League league = this.leagueDao.fetchLeague(leagueName);

		final List<Challenger> leagueChallengers = new ArrayList<Challenger>();
		final List<Challenger> pendingChallengers = new ArrayList<Challenger>();

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

		league.addChallengers(leagueChallengers);
		league.addPendingChallengers(pendingChallengers);

		// adding challengers to the league
		this.leagueDao.addChallengersToLeague(league);

		// adding league challenges to userleague mapping
		for (final Challenger challeger : leagueChallengers) {
			this.userLeagueDao.addUserLeague(challeger.getUser().getEmail(),
					leagueName);
		}

		// result
		Map<String, Object> result = new HashMap<String, Object>();

		result.put(Status.SUCCESS.name(), leagueChallengers);
		result.put(Status.ERROR.name(), pendingChallengers);

		return result;
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

}
