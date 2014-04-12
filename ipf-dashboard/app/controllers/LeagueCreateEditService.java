package controllers;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import play.libs.F.Promise;
import play.libs.WS.Response;
import play.libs.WS.WSRequest;
import play.mvc.Controller;
import play.mvc.Result;

import com.ning.http.client.FluentStringsMap;

public class LeagueCreateEditService extends Controller {

	public static Result submitLeague(String competitionName,
			String leagueName, String competitionSport) {

		String leagueOwnerId = session().get("loginName");
		session().put("leagueName", leagueName);
		System.out.println("Email id----->" + leagueOwnerId);
		System.out.println("League details are... competitionName : "
				+ competitionName + "leagueName : " + leagueName
				+ "leagueOwnerId:" + leagueOwnerId + "competitionSport:"
				+ competitionSport);
		Map<String, String> queryParameters = new HashMap<String, String>();
		queryParameters.put("competitionName", competitionName);
		queryParameters.put("leagueName", leagueName);
		queryParameters.put("leagueOwnerId", leagueOwnerId);
		queryParameters.put("competitionSport", competitionSport);
		String response = ServiceUtil.callPOST(
				"/services/cricketleagues/createLeague", null, queryParameters,
				50000);
		if (response.equals("")) {
			return ok("error");
		}
		return ok(response);

	}

	public static Result addChallengersToLeague(String challengers)
			throws UnsupportedEncodingException {

		String leagueName = session().get("leagueName");
		System.out.println("League details are... id : " + leagueName
				+ "emailIds : " + challengers);
		FluentStringsMap map = new FluentStringsMap();

		String result = java.net.URLDecoder.decode(challengers, "UTF-8");
		System.out.println("Results----------->" + result);
		String challengerSplit = result.replaceAll("\\[", "").replaceAll("\\]",
				"");
		System.out.println("Removing braces--------->" + challengerSplit);
		String challengerCommaSplit = challengerSplit.replace("\"", "");
		System.out.println("Removing commas--------->" + challengerCommaSplit);
		String[] challenger = challengerCommaSplit.trim().split(",");
		Set<String> challengersSet = new HashSet<String>();
		for (String email : challenger) {
			System.out.println("EmailId------->" + email);
			challengersSet.add(email);
		}
		map.add("leagueName", leagueName);
		map.add("challengers", challengersSet);
		// String response =
		// ServiceUtil.callPOST("/services/cricketleagues/addChallengersToLeague",
		// null, queryParameters, 50000);
		WSRequest request = new WSRequest("POST");

		request.setUrl("http://localhost:8181/services/cricketleagues/addChallengersToLeague");
		request.setHeader(CONTENT_TYPE, "application/x-www-form-urlencoded");
		request.setQueryParameters(map);
		Promise<Response> response = request.execute();
		System.out.println("response  " + response.get().getBody());
		if (response.equals("")) {
			return ok("error");
		}
		session().remove("leagueName");
		return ok(response.get().getBody());

	}

	/*
	 * public static String callPOST() {
	 * 
	 * WSRequest request = new WSRequest("POST"); request.setUrl(
	 * "http://localhost:8181/services/cricketleagues/addChallengersToLeague");
	 * request.setHeader(CONTENT_TYPE, "application/x-www-form-urlencoded");
	 * 
	 * FluentStringsMap map = new FluentStringsMap();
	 * 
	 * map.add("leagueName", "t20-freaks");
	 * 
	 * Set<String> challengers = new HashSet<String>();
	 * challengers.add("hiren.develiya@citiustech.com");
	 * challengers.add("aniket.divekar@abc.com");
	 * challengers.add("mohini.mudaliar@citiustech.com");
	 * challengers.add("jayesh.mair@ge.com");
	 * 
	 * map.add("challengers", challengers);
	 * 
	 * request.setQueryParameters(map); Promise<Response> response =
	 * request.execute();
	 * 
	 * System.out.println(response.get().getBody());
	 * 
	 * return response.get().getBody(); }
	 */

}
