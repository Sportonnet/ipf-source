package controllers;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.dashboard;
import views.html.index;

public class LoginController extends Controller{

	
	public static Result authenticate(String uName, String password) {

			session().put("loginName", uName);
			String requestData = "emailId="+URLEncoder.encode(uName)+"&password="+URLEncoder.encode(password);			
			String response = ServiceUtil.callPOST("/services/login/isUserAuthorized/", requestData, null, 50000);
			if("true".equalsIgnoreCase("true"))
			{
				return ok("success");
			}else{
				return ok("fail");
			}
			
		
	}
	
	public static Result signUp(String uName, String email, String password) {
		
		Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("name", uName);
        queryParams.put("emailId", email);
        queryParams.put("password", password);
					
		String response = ServiceUtil.callPOST("/services/signup/createUser/", null, queryParams, 50000);
		System.out.println("We reached here"+response);
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
