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
	
	public static Result getFixturesDetails(String leagueName, String type) {

		System.out.println("leagueName " + leagueName);
		String url = "";
		if(type.equalsIgnoreCase("past"))
		{
			url = "/services/cricketfixtures/getPastFixtures";
		}else if(type.equalsIgnoreCase("future"))
		{
			url = "/services/cricketfixtures/getUpcomingFixtures";
		}else if(type.equalsIgnoreCase("present"))
		{
			url = "/services/cricketfixtures/getFixtures";
		}
		
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("leagueName", leagueName);
		WS.Response response = ServiceUtil.callGET(
				url, "application/json",
				queryParams);
		System.out.println("the result of getFixturesDetails "+response.getBody());
		return ok(response.getBody());
	}

}
