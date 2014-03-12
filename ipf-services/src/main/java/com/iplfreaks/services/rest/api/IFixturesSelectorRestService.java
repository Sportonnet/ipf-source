package com.iplfreaks.services.rest.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.joda.time.DateTime;

@Path("/fixtures")
@Produces({ "application/json" })
public interface IFixturesSelectorRestService {

	/**
	 * This method returns the matches for the current date
	 * 
	 * @param date
	 *            date of the match
	 * @return
	 */
	@GET
	@Path("/getFixtures/{date}")
	public List<String> getFixtures(@PathParam("date") DateTime date);
}
