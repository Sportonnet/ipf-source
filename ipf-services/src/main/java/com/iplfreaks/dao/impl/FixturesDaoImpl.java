package com.iplfreaks.dao.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.iplfreaks.dao.api.IFixturesDao;
import com.iplfreaks.game.Fixture;

public class FixturesDaoImpl implements IFixturesDao {

	private MongoTemplate mongoTemplate;

	private static final String FIXTURE_COLLECTION = "fixtures";

	@Override
	public List<Fixture> getFixtures() {

		Integer day = new DateTime().getDayOfMonth();
		Integer month = new DateTime().getMonthOfYear();
		Integer year = new DateTime().getYear();

		final String floorTime = year.toString()
				+ "-"
				+ (month.toString().length() < 2 ? "0" + month.toString()
						: month.toString()) + "-" + day.toString();

		final String ceilTime = year.toString()
				+ "-"
				+ (month.toString().length() < 2 ? "0" + month.toString()
						: month.toString()) + "-"
				+ new Integer(day + 1).toString();

		final Query fixtureQuery = new Query(Criteria.where("dateTime")
				.gt(new DateTime(floorTime)).lt(new DateTime(ceilTime)))
				.with(new Sort(Direction.ASC, "dateTime"));

		System.out.println("Query : " + fixtureQuery.toString());

		final List<Fixture> fixtures = this.mongoTemplate.find(fixtureQuery,
				Fixture.class, FIXTURE_COLLECTION);
		return fixtures;
	}

	@Override
	public List<Fixture> getPastFixtures() {

		Integer day = new DateTime().getDayOfMonth();
		Integer month = new DateTime().getMonthOfYear();
		Integer year = new DateTime().getYear();

		final String floorTime = year.toString()
				+ "-"
				+ (month.toString().length() < 2 ? "0" + month.toString()
						: month.toString()) + "-" + day.toString();

		final Query fixtureQuery = new Query(Criteria.where("dateTime").lt(
				new DateTime(floorTime)));

		System.out.println("Query : " + fixtureQuery.toString());

		final List<Fixture> fixtures = this.mongoTemplate.find(fixtureQuery,
				Fixture.class, FIXTURE_COLLECTION);
		return fixtures;
	}

	@Override
	public List<Fixture> getUpcomingFixtures() {

		Integer day = new DateTime().getDayOfMonth();
		Integer month = new DateTime().getMonthOfYear();
		Integer year = new DateTime().getYear();

		final String ceilTime = year.toString()
				+ "-"
				+ (month.toString().length() < 2 ? "0" + month.toString()
						: month.toString()) + "-"
				+ new Integer(day + 1).toString();

		final Query fixtureQuery = new Query(Criteria.where("dateTime").gt(
				new DateTime(ceilTime)));

		System.out.println("Query : " + fixtureQuery.toString());

		final List<Fixture> fixtures = this.mongoTemplate.find(fixtureQuery,
				Fixture.class, FIXTURE_COLLECTION);
		return fixtures;
	}

	/**
	 * @return the mongoTemplate
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * @param mongoTemplate
	 *            the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}
