package controllers;

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
        String response = ServiceUtil.callPOST("/services/leagues/createLeague", null, queryParameters, 50000);
		if( response.equals("")){
			return ok("error");
		}
		return ok(response);
		
	}
	
	public static Result addChallengersToLeague(String challengers) {
		
		String leagueName = session().get("leagueName");
		System.out.println("League details are... id : " + leagueName+ "emailIds : " +challengers);
		Map<String, String> queryParameters = new HashMap<String, String>();
		queryParameters.put("leagueName",leagueName);
    	queryParameters.put("challengers", challengers);
        String response = ServiceUtil.callPOST("/services/leagues/addChallengersToLeague", null, queryParameters, 50000);
        
		if( response.equals("")){
			return ok("error");
		}
		session().remove("leagueName");
		return ok(response);
		
	}
	
	

}
