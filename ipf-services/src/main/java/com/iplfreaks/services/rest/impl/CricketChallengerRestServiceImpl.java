/**
 * 
 */
package com.iplfreaks.services.rest.impl;

import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.google.gson.Gson;
import com.iplfreaks.common.RestServiceResponse;
import com.iplfreaks.common.Status;
import com.iplfreaks.services.api.IChallengerService;
import com.iplfreaks.services.rest.api.IChallengerRestService;

/**
 * @author Aniket
 * 
 */
@Path("/challergerService")
public class CricketChallengerRestServiceImpl implements IChallengerRestService {
	private IChallengerService challengerService;

	@Override
	@POST
	@Path("/getCricketChallenges")
	public String getFixtureChallenges(
			@FormParam("leagueName") String leagueName,
			@FormParam("fixtureId") String fixtureId) {

		RestServiceResponse response = null;
		try {
			Map<String, Object> result = this.challengerService
					.getFixtureChallenges(leagueName, fixtureId);
			response = new RestServiceResponse(Status.SUCCESS.name(), null,
					result);
		} catch (Exception e) {
			e.printStackTrace();
			response = new RestServiceResponse(Status.ERROR.name(),
					e.getMessage(), null);
		}

		return new Gson().toJson(response);
	}

	/**
	 * @return the challengerService
	 */
	public IChallengerService getChallengerService() {
		return challengerService;
	}

	/**
	 * @param challengerService
	 *            the challengerService to set
	 */
	public void setChallengerService(IChallengerService challengerService) {
		this.challengerService = challengerService;
	}

}
