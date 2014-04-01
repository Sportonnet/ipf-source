package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class LeagueCreateEditService extends Controller {
	
	public static Result submitLeague(String competetionType, String leagueName) {

		System.out.println("League details are... competetionType : " + competetionType+ "leagueName : " +leagueName);

        String response = ServiceUtil.callPOST("/service/userManagementRestService/userManagement/createUser", null, null, 50000);
		if( response.equals("")){
			return ok("error");
		}
		return ok(response);
		
	}
	
	public static Result addMemberToLeague(String id, String emailIds) {

		System.out.println("League details are... id : " + id+ "emailIds : " +emailIds);

        String response = ServiceUtil.callPOST("/service/userManagementRestService/userManagement/createUser", null, null, 50000);
		if( response.equals("")){
			return ok("error");
		}
		return ok(response);
		
	}
	
	

}
