package com.iplfreaks.core;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

import com.iplfreaks.base.BaseEntity;
import com.iplfreaks.user.User;

/**
 * @author dhananjayp
 *
 */
public class League extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4308164605799997987L;

	private String name;
	
	private Set<Challenger> challengers;
	
	private Set<Challenge> pendingChallengers;

	private DateTime leagueStartDate;

	private User leagueOwner;
	
	private Competition competition;
	
	
	public League(String name,User leagueOwner,String startDate) {
		this.name = name;
		this.leagueOwner = leagueOwner;
		this.leagueStartDate =new DateTime(startDate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Challenger> getChallengers() {
		return challengers;
	}

	public void addChallenger(Challenger challenger){
		if(this.challengers == null)
			this.challengers = new HashSet<Challenger>();
		this.challengers.add(challenger);
	}
	
	public DateTime getLeagueStartDate() {
		return leagueStartDate;
	}

	public void setLeagueStartDate(DateTime leagueStartDate) {
		this.leagueStartDate = leagueStartDate;
	}
	
	public User getLeagueOwner() {
		return leagueOwner;
	}

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
	 * @param competition the competition to set
	 */
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	/**
	 * @return the pendingChallengers
	 */
	public Set<Challenge> getPendingChallengers() {
		return pendingChallengers;
	}

	/**
	 * @param pendingChallengers the pendingChallengers to set
	 */
	public void setPendingChallengers(Set<Challenge> pendingChallengers) {
		this.pendingChallengers = pendingChallengers;
	}

	public static void main(String[] args) {
		String str = "20131003";
		DateTime dateTime= new DateTime(str);
		System.out.println(dateTime);
	}
}
