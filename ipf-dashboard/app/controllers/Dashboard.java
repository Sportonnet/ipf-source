package controllers;

import java.util.HashMap;
import java.util.Map;

import play.libs.WS;
import play.mvc.Controller;
import play.mvc.Result;

public class Dashboard extends Controller {

	public static Result getPlayers(String team) {

		System.out.println("team " + team);
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("team", team);
		WS.Response response = ServiceUtil.callGET(
				"/services/teams/getTeamDetails", "application/json",
				queryParams);
		return ok(response.getBody());
	}

	public static Result getAllFixtures(String leagueName, String type) {

		System.out.println("leagueName " + leagueName);
		String url = "";
		if (type.equalsIgnoreCase("past")) {
			url = "/services/cricketfixtures/getPastFixtures";
		} else if (type.equalsIgnoreCase("future")) {
			url = "/services/cricketfixtures/getUpcomingFixtures";
		} else if (type.equalsIgnoreCase("present")) {
			url = "/services/cricketfixtures/getFixtures";
		}

		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("leagueName", leagueName);
		WS.Response response = ServiceUtil.callGET(url, "application/json",
				queryParams);
		System.out.println("the result of getFixturesDetails "
				+ response.getBody());
		return ok(response.getBody());
	}
	
	public static Result getFixtureDetails(String leagueName, String fixtureId) {

		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("leagueName", leagueName);
		queryParams.put("fixtureId", fixtureId);
		String response = ServiceUtil.callPOST("/services/challergerService/getCricketChallenges/",
				null, queryParams, 50000);
		return ok(response);

	}
	
	public static Result savePredictions(String fixtureId, String leagueName, String maxWct, String maxRun, String MofM, String mWnr, String bAns) {

		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("fixtureId", fixtureId);
		queryParams.put("leagueName", leagueName);
		queryParams.put("challengerEmailId", session().get("email"));
		if(maxWct.equalsIgnoreCase("Drag Player here"))
		{
			maxWct = "";
		}
		if(maxRun.equalsIgnoreCase("Drag Player here"))
		{
			maxRun = "";
		}
		if(MofM.equalsIgnoreCase("Drag Player here"))
		{
			MofM = "";
		}
		if(mWnr.equalsIgnoreCase("Drag Team here"))
		{
			mWnr = "";
		}
		if(bAns.equalsIgnoreCase("Drag Bonus Ans here"))
		{
			bAns = "";
		}
		queryParams.put("bestBowler", maxWct);
		queryParams.put("bestBatsman", maxRun);
		queryParams.put("manOfTheMatch", MofM);
		queryParams.put("winnerTeam", mWnr);
		queryParams.put("bonusAnswer", bAns);
		
		System.out.println("maxWct "+maxWct +"mWnr "+mWnr + session().get("email"));
		String response = ServiceUtil.callPOST("/services/prediction/saveCricketPrediction/",
				null, queryParams, 50000);
		return ok(response);

	}
	
	public static Result getMyAllLeague() {

		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("user", session().get("email"));
		String response = ServiceUtil.callPOST("/services/users/getUserLeagues/",
				null, queryParams, 50000);
		return ok(response);

	}
	
}
