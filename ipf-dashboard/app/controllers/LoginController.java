package controllers;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.ning.http.client.FluentStringsMap;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.dashboard;
import views.html.index;

public class LoginController extends Controller{

	
	public static Result authenticate(String uName, String password) {

			session().put("email", uName);
			//String requestData = "emailId="+URLEncoder.encode(uName)+"&password="+URLEncoder.encode(password);
			FluentStringsMap queryParams = new FluentStringsMap();
			queryParams.add("emailId", uName);
			queryParams.add("password", password);
			
			String  response = ServiceUtil.callPOST("/services/login/isUserAuthorized/", queryParams);
			if(response.equalsIgnoreCase("true"))
			{
				return ok("success");
			}else{
				return ok("fail");
			}
			
		
	}
	
	public static Result signUp(String uName, String email, String password) {

		FluentStringsMap queryParams = new FluentStringsMap();
		queryParams.add("name", uName);
		queryParams.add("emailId", email);
		queryParams.add("password", password);

		String response = ServiceUtil.callPOST("/services/users/createUser/",
				queryParams);
		System.out.println("We reached here" + response);
		return ok(response);

	}
	
	public static Result goToDashboard() {

			return ok(dashboard.render());
		
	}
	
	public static Result logOut() {

		session().clear();
		return ok(index.render(""));
	
	}
	
}
