/**
 * 
 */
package com.iplfreaks.services.rest.impl;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.iplfreaks.common.RestServiceResponse;
import com.iplfreaks.common.Status;
import com.iplfreaks.services.api.ISavePredictionService;
import com.iplfreaks.services.rest.api.ISavePredictionRestService;

/**
 * @author Aniket
 * 
 */
public class SavePredictionRestServiceImpl implements
		ISavePredictionRestService {

	private Logger logger = Logger
			.getLogger(SavePredictionRestServiceImpl.class);
	private ISavePredictionService savePredictionService;

	@Override
	public String saveCricketPrediction(String leagueName, String fixtureId,
			String challengerEmailId, String bestBowler, String bestBatsman,
			String manOfTheMatch, String winnerTeam, String bonusAnswer) {
		RestServiceResponse response = null;
		if (!this.savePredictionService.canSavePrediction(fixtureId)) {
			response = new RestServiceResponse(Status.ERROR.name(),
					"Prediction window closed for this fixture", null);

			return new Gson().toJson(response);
		}

		try {
			this.savePredictionService.saveCricketPrediction(leagueName,
					fixtureId, challengerEmailId, bestBowler, bestBatsman,
					manOfTheMatch, winnerTeam, bonusAnswer);
			response = new RestServiceResponse(Status.SUCCESS.name(), null,
					null);
		} catch (Exception e) {
			this.logger.error(e.getMessage());
			response = new RestServiceResponse(Status.ERROR.name(),
					"System is temporarily down, please try again later", null);
		}
		return new Gson().toJson(response);
	}

	/**
	 * @return the savePredictionService
	 */
	public ISavePredictionService getSavePredictionService() {
		return savePredictionService;
	}

	/**
	 * @param savePredictionService
	 *            the savePredictionService to set
	 */
	public void setSavePredictionService(
			ISavePredictionService savePredictionService) {
		this.savePredictionService = savePredictionService;
	}

}
