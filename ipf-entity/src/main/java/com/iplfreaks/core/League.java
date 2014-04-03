package com.iplfreaks.core;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.iplfreaks.base.BaseEntity;
import com.iplfreaks.user.User;

/**
 * @author dhananjayp
 * 
 */
@Document
@TypeAlias(value = "league")
public class League extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4308164605799997987L;

	@Indexed(unique = true, sparse = true)
	private String name;

	private final Set<Challenger> challengers = new HashSet<Challenger>();

	private final Set<Challenger> pendingChallengers = new HashSet<Challenger>();

	private DateTime leagueStartDate;

	private User leagueOwner;

	@DBRef
	private Competition competition;

	public League(String name, User leagueOwner, String startDate) {
		this.name = name;
		this.leagueOwner = leagueOwner;
		this.leagueStartDate = new DateTime(startDate);
	}

	public League() {
	}

	public League(String name, User leagueOwner) {
		this.name = name;
		this.leagueOwner = leagueOwner;
	}

	/**
	 * adds the collection of challengers to the set
	 * 
	 * @param challenger
	 */
	public void addChallengers(List<Challenger> challengers) {
		this.challengers.addAll(challengers);
	}

	/**
	 * adds a single challenger to the set
	 * 
	 * @param challenger
	 */
	public void addChallenger(Challenger challenger) {
		this.challengers.add(challenger);
	}

	/**
	 * adds the collection of pending challengers to the set
	 * 
	 * @param pendingChallengers
	 */
	public void addPendingChallengers(List<Challenger> pendingChallengers) {
		this.pendingChallengers.addAll(pendingChallengers);
	}

	/**
	 * adds a single pending challenger to the set
	 * 
	 * @param pendingChallenger
	 */
	public void addPendingChallenger(Challenger pendingChallenger) {
		this.pendingChallengers.add(pendingChallenger);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	/**
	 * @return the challengers
	 */
	public Set<Challenger> getChallengers() {
		return challengers;
	}

	/**
	 * @return the leagueStartDate
	 */
	public DateTime getLeagueStartDate() {
		return leagueStartDate;
	}

	/**
	 * @param leagueStartDate
	 *            the leagueStartDate to set
	 */
	public void setLeagueStartDate(DateTime leagueStartDate) {
		this.leagueStartDate = leagueStartDate;
	}

	/**
	 * @return the leagueOwner
	 */
	public User getLeagueOwner() {
		return leagueOwner;
	}

	/**
	 * @param leagueOwner
	 *            the leagueOwner to set
	 */
	public void setLeagueOwner(User leagueOwner) {
		this.leagueOwner = leagueOwner;
	}

	/**
	 * @return the competition
	 */
	public Competition getCompetition() {
		return competition;
	}

	/**
	 * @param competition
	 *            the competition to set
	 */
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	/**
	 * @return the pendingChallengers
	 */
	public Set<Challenger> getPendingChallengers() {
		return pendingChallengers;
	}

}
