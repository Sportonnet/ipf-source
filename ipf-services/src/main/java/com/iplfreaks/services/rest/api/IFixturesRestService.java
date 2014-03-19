package com.iplfreaks.services.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/fixtures")
@Produces({ "application/json" })
public interface IFixturesRestService {

	/**
	 * Rest Service returns the fixture which will be held today
	 * 
	 * @return
	 */
	@GET
	@Path("/getFixtures")
	public String getFixtures();

	/**
	 * Rest Service returns all the fixtures before today
	 * 
	 * @return
	 */
	@GET
	@Path("/getPastFixtures")
	public String getPastFixtures();

	/**
	 * Rest Service returns all the fixtures tomorrow onwards
	 * 
	 * @return
	 */
	@GET
	@Path("/getUpcomingFixtures")
	public String getUpcomingFixtures();
}
