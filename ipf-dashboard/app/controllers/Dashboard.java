package controllers;

import java.util.HashMap;
import java.util.Map;

import play.libs.WS;
import play.mvc.Controller;
import play.mvc.Result;

public class Dashboard extends Controller {
	
	public static Result getPlayers(String team) {

		

			System.out.println("team "+ team);
		Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("team", team);
        WS.Response response = ServiceUtil.callGET("/services/teams/getTeamDetails", "application/json", queryParams);
        return ok(response.getBody());
		}

	}
