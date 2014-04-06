package controllers;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import play.mvc.Controller;
import play.mvc.Result;

public class LeagueCreateEditService extends Controller {
	
	public static Result submitLeague(  String competitionName, String leagueName, String competitionSport) {

		String leagueOwnerId = session().get("loginName");
		session().put("leagueName", leagueName);
		System.out.println("Email id----->"+leagueOwnerId);
		System.out.println("League details are... competitionName : " + competitionName+ "leagueName : " +leagueName+ "leagueOwnerId:" +leagueOwnerId+ "competitionSport:"+competitionSport);
		Map<String, String> queryParameters = new HashMap<String, String>();
    	queryParameters.put("competitionName",competitionName);
    	queryParameters.put("leagueName",leagueName);
    	queryParameters.put("leagueOwnerId",leagueOwnerId);
    	queryParameters.put("competitionSport",competitionSport);
        String response = ServiceUtil.callPOST("/services/cricketleagues/createLeague", null, queryParameters, 50000);
		if( response.equals("")){
			return ok("error");
		}
		return ok(response);
		
	}
	
	public static Result addChallengersToLeague(String challengers) throws UnsupportedEncodingException {
		
		String leagueName = session().get("leagueName");
		System.out.println("League details are... id : " + leagueName+ "emailIds : " +challengers);
		Map<String, String> queryParameters = new HashMap<String, String>();
		queryParameters.put("leagueName",leagueName);
		
		String result = java.net.URLDecoder.decode(challengers, "UTF-8");
		System.out.println("Results----------->"+result);
		String challengerSplit = result.replaceAll("\\[", "").replaceAll("\\]","");
		System.out.println("Removing braces--------->"+challengerSplit);
		String challengerCommaSplit = challengerSplit.replace("\"","");
		System.out.println("Removing commas--------->"+challengerCommaSplit);
		String[] challenger = challengerCommaSplit.trim().split(",");
		for (String email : challenger) {
			System.out.println("EmailId------->"+email);
			queryParameters.put("challengers", email);
		}
		
        String response = ServiceUtil.callPOST("/services/cricketleagues/addChallengersToLeague", null, queryParameters, 50000);
        
		if( response.equals("")){
			return ok("error");
		}
		session().remove("leagueName");
		return ok(response);
		
	}
	
	

}
