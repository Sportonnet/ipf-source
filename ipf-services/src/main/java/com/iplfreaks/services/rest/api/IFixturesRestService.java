package com.iplfreaks.services.rest.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/fixtures")
@Produces({ "application/json" })
public interface IFixturesRestService {

	/**
	 * Rest Service returns the fixture which will be held today
	 * 
	 * @return
	 */
	@POST
	@Path("/getFixtures")
	public String getFixtures(
			@QueryParam("competitionSport") String competitionSport,
			@QueryParam("competitionName") String competitionName);

	/**
	 * Rest Service returns all the fixtures before today
	 * 
	 * @return
	 */
	@POST
	@Path("/getPastFixtures")
	public String getPastFixtures(
			@QueryParam("competitionSport") String competitionSport,
			@QueryParam("competitionName") String competitionName);

	/**
	 * Rest Service returns all the fixtures tomorrow onwards
	 * 
	 * @return
	 */
	@POST
	@Path("/getUpcomingFixtures")
	public String getUpcomingFixtures(
			@QueryParam("competitionSport") String competitionSport,
			@QueryParam("competitionName") String competitionName);
}
