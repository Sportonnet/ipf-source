/**
 * 
 */
package com.iplfreaks.game.cricket;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jayeshm3
 *
 */
public class CricketChallenge {
	
	//Unique identifier for the fixture
		private String fixtureId;
		
		private HashSet<CricketPrediction> predictions = new HashSet<CricketPrediction>();
		
		private CricketPrediction result;

		/**
		 * @return the fixtureId
		 */
		public String getFixtureId() {
			return fixtureId;
		}

		/**
		 * @param fixtureId the fixtureId to set
		 */
		public void setFixtureId(String fixtureId) {
			this.fixtureId = fixtureId;
		}

		/**
		 * @return the predictions
		 */
		public Set<CricketPrediction> getPredictions() {
			return predictions;
		}

		/**
		 * @param predictions the predictions to set
		 */
		public void setPredictions(HashSet<CricketPrediction> predictions) {
			this.predictions = predictions;
		}

		/**
		 * @return the result
		 */
		public CricketPrediction getResult() {
			return result;
		}

		/**
		 * @param result the result to set
		 */
		public void setResult(CricketPrediction result) {
			this.result = result;
		}

}
