/**
 * 
 */
package com.iplfreaks.services.rest.api;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Aniket
 * 
 */
@Path("/prediction")
@Produces({ "application/json" })
public interface ISavePredictionRestService {
	/**
	 * 
	 * @param leagueName
	 *            name of the league for which challenger is predicting
	 * @param fixtureId
	 *            name of the fixture against the prediction by challenger
	 * @param challengerEmailId
	 *            email id of the challenger
	 * @param bestBowler
	 *            name of the best bowler
	 * @param bestBatsman
	 *            name of the best batsman
	 * @param manOfTheMatch
	 *            name of the man of the match
	 * @param winnerTeam
	 *            name of the winning team
	 * @param bonus
	 *             bonus questions and answers
	 */
	@POST
	@Path("/saveCricketPrediction")
	public String saveCricketPrediction(
			@FormParam("leagueName") String leagueName,
			@FormParam("fixtureId") String fixtureId,
			@FormParam("challengerEmailId") String challengerEmailId,
			@FormParam("bestBowler") String bestBowler,
			@FormParam("bestBatsman") String bestBatsman,
			@FormParam("manOfTheMatch") String manOfTheMatch,
			@FormParam("winnerTeam") String winnerTeam,
			@FormParam("bonusAnswer") List<String> bonus);
}
