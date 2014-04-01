package com.iplfreaks.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.iplfreaks.cache.services.api.ICacheService;
import com.iplfreaks.core.Competition;
import com.iplfreaks.dao.repository.CompetitionRepository;
import com.iplfreaks.game.Fixture;
import com.iplfreaks.services.api.IFixturesService;

public class FixturesServiceImpl implements IFixturesService {

	private CompetitionRepository competitionRepository;
	private ICacheService cacheService;

	public void init() {
	}

	@Override
	public List<Fixture> getFixtures(String competitionSport,
			String competitionName) {
		List<Fixture> fixtures = this.cacheService.getFixtures(
				competitionSport, competitionName);
		if (fixtures == null) {
			List<Competition> competitions = this.competitionRepository
					.findByNameAndSport(competitionName, competitionSport);
			fixtures = new ArrayList<Fixture>(competitions.get(0).getFixtures());
		}
		final List<Fixture> todaysFixtures = new ArrayList<Fixture>();

		for (final Fixture fixture : fixtures) {
			final int day = fixture.getDateTime().toLocalDateTime()
					.getDayOfMonth();
			final int month = fixture.getDateTime().toLocalDateTime()
					.getMonthOfYear();
			final LocalDate today = new DateTime().toLocalDate();
			if (day == today.getDayOfMonth() && month == today.getMonthOfYear()) {
				todaysFixtures.add(fixture);
			}
		}

		return todaysFixtures;
	}

	@Override
	public List<Fixture> getPastFixtures(String competitionSport,
			String competitionName) {
		List<Fixture> fixtures = this.cacheService.getFixtures(
				competitionSport, competitionName);

		if (fixtures == null) {
			List<Competition> competitions = this.competitionRepository
					.findByNameAndSport(competitionName, competitionSport);
			fixtures = new ArrayList<Fixture>(competitions.get(0).getFixtures());
		}
		final List<Fixture> pastFixtures = new ArrayList<Fixture>();

		for (final Fixture fixture : fixtures) {
			final int day = fixture.getDateTime().toLocalDateTime()
					.getDayOfMonth();
			final int month = fixture.getDateTime().toLocalDateTime()
					.getMonthOfYear();
			final LocalDate today = new DateTime().toLocalDate();

			if (month < today.getMonthOfYear()
					|| (month == today.getMonthOfYear() && day < today
							.getDayOfMonth())) {
				pastFixtures.add(fixture);
			}
		}

		return pastFixtures;
	}

	@Override
	public List<Fixture> getUpcomingFixtures(String competitionSport,
			String competitionName) {
		List<Fixture> fixtures = this.cacheService.getFixtures(
				competitionSport, competitionName);

		if (fixtures == null) {
			List<Competition> competitions = this.competitionRepository
					.findByNameAndSport(competitionName, competitionSport);
			fixtures = new ArrayList<Fixture>(competitions.get(0).getFixtures());
		}

		final List<Fixture> upcomingFixtures = new ArrayList<Fixture>();

		for (final Fixture fixture : fixtures) {
			final int day = fixture.getDateTime().toLocalDateTime()
					.getDayOfMonth();
			final int month = fixture.getDateTime().toLocalDateTime()
					.getMonthOfYear();
			final LocalDate today = new DateTime().toLocalDate();

			if (month > today.getMonthOfYear()
					|| (month == today.getMonthOfYear() && day > today
							.getDayOfMonth())) {
				upcomingFixtures.add(fixture);
			}
		}

		return upcomingFixtures;
	}

	/**
	 * @return the competitionRepository
	 */
	public CompetitionRepository getCompetitionRepository() {
		return competitionRepository;
	}

	/**
	 * @param competitionRepository
	 *            the competitionRepository to set
	 */
	public void setCompetitionRepository(
			CompetitionRepository competitionRepository) {
		this.competitionRepository = competitionRepository;
	}

	/**
	 * @return the cacheService
	 */
	public ICacheService getCacheService() {
		return cacheService;
	}

	/**
	 * @param cacheService
	 *            the cacheService to set
	 */
	public void setCacheService(ICacheService cacheService) {
		this.cacheService = cacheService;
	}

}
